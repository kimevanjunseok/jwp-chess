package chess.controller;

import chess.repository.exceptions.DaoNoneSelectedException;
import chess.entity.RoomEntity;
import chess.service.ChessRoomsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/chess/rooms")
public class SpringRoomsController {
	private static final String EMPTY = "";

	private final ChessRoomsService chessRoomsService;

	public SpringRoomsController(final ChessRoomsService chessRoomsService) {
		this.chessRoomsService = chessRoomsService;
	}

	@GetMapping()
	private String load(final Model model) {
		final List<RoomEntity> rooms = chessRoomsService.findAllRooms();
		model.addAttribute("rooms", rooms);
		return "rooms";
	}

	@PostMapping()
	private String manage(
			@RequestParam(value = "method", defaultValue = EMPTY) final String method,
			@RequestParam(value = "room_name", defaultValue = EMPTY) final String roomName) {

		if ("delete".equals(method)) {
			return delete(roomName);
		}

		try {
			return enter(roomName);
		} catch (DaoNoneSelectedException e) {
			return create(roomName);
		}
	}

	private String delete(final String roomName) {
		chessRoomsService.deleteRoomByRoomName(roomName);
		return Constants.REDIRECT + "/chess/rooms";
	}

	private String enter(final String roomName) {
		final RoomEntity roomEntity = chessRoomsService.findRoomByRoomName(roomName);
		return Constants.REDIRECT + "/chess/rooms/" + roomEntity.getId();
	}

	private String create(final String roomName) {
		chessRoomsService.addRoomByRoomName(roomName);
		return Constants.REDIRECT + "/chess/rooms";
	}
}
