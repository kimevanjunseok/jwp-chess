package chess.controller;

import chess.dao.exceptions.DaoNoneSelectedException;
import chess.service.ChessRoomService;
import spark.Spark;
import chess.view.Announcement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SparkRoomController {
	private static final String PATH = "/chess/rooms/:id";
	private static final String STATIC_PATH = "/chess.hbs";
	private static final String SLASH = "/";
	private static final String EMPTY = "";
	private static final String ID_PARAM = ":id";
	private static final String COMMAND_QUERYPARAM = "command";
	private static final String TABLE_KEY = "table";
	private static final String ANNOUNCEMENT_KEY = "announcement";

	private final ChessRoomService chessRoomService;

	public SparkRoomController(final ChessRoomService chessRoomService) {
		this.chessRoomService = chessRoomService;
	}

	public void run() {
		routeGetMethod();
		routePostMethod();
	}

	private void routeGetMethod() {
		Spark.get(PATH, (request, response) -> {
			final int roomId = Integer.parseInt(request.params(ID_PARAM));
			try {
				return response(roomId);
			} catch (DaoNoneSelectedException e) {
				initRoom(roomId);
				return response(roomId);
			}
		});
	}

	private String response(final int roomId) throws SQLException {
		final String boardHtml = chessRoomService.loadBoardHtml(roomId);
		final String announcementMessage = chessRoomService.loadAnnouncementMessage(roomId);

		final Map<String, Object> map = new HashMap<>();
		map.put(TABLE_KEY, boardHtml);
		map.put(ANNOUNCEMENT_KEY, announcementMessage);

		return Renderer.getInstance().render(map, STATIC_PATH);
	}

	private void initRoom(final int roomId) throws SQLException {
		chessRoomService.saveNewState(roomId);
		chessRoomService.saveNewPieces(roomId);
		chessRoomService.saveNewAnnouncementMessage(roomId);
	}

	private void routePostMethod() {
		Spark.post(PATH, (request, response) -> {
			final int roomId = Integer.parseInt(request.params(ID_PARAM));
			final String command = request.queryParams(COMMAND_QUERYPARAM);

			try {
				chessRoomService.updateRoom(roomId, command);
			} catch (RuntimeException e) {
				chessRoomService.saveAnnouncementMessage(roomId, Announcement.of(e.getMessage()).getString());
			}
			response.redirect(SparkRoomsController.PATH + SLASH + request.params(ID_PARAM));
			return EMPTY;
		});
	}
}
