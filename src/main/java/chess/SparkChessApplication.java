package chess;

import chess.controller.ChessHomeController;
import chess.controller.ChessRoomController;
import chess.controller.ChessRoomsController;
import chess.controller.ChessStatisticController;
import spark.Spark;

public class SparkChessApplication {

	private static final ChessRoomsController ROOMS_CONTROLLER = ChessRoomsController.getInstance();
	private static final ChessRoomController ROOM_CONTROLLER = ChessRoomController.getInstance();
	private static final ChessStatisticController STATISTIC_CONTROLLER
			= ChessStatisticController.getInstance();
	private static final ChessHomeController HOME_CONTROLLER = ChessHomeController.getInstance();

	public static void main(String[] args) {
		Spark.port(ServerInfo.PORT);
		Spark.staticFiles.location(ServerInfo.STATIC_FILES);

		ROOMS_CONTROLLER.run();
		ROOM_CONTROLLER.run();
		STATISTIC_CONTROLLER.run();
		HOME_CONTROLLER.run();
	}
}
