package domain.testAssistant;

import view.board.Board;
import view.board.RowOfBoard;
import domain.command.MoveCommandTokens;
import domain.pieces.*;
import domain.coordinate.Direction;
import domain.coordinate.Distance;
import domain.coordinate.Coordinate;
import domain.state.Ended;
import domain.state.Moved;
import domain.state.Started;
import domain.team.Team;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class creationAssistant {
	public static Team createTeam(String string) {
		return Team.valueOf(string.toUpperCase());
	}

	public static Coordinate createPoint(String point) {
		return Coordinate.of(point);
	}

	public static Direction createDirection(String direction) {
		return Direction.valueOf(direction.toUpperCase());
	}

	public static Distance createDistance(String distance) {
		return Distance.valueOf(distance.toUpperCase());
	}

	public static Bishop createBishop(String team, String point) {
		return new Bishop(createTeam(team), createPoint(point));
	}

	public static King createKing(String team, String point) {
		return new King(createTeam(team), createPoint(point));
	}

	public static Knight createKnight(String team, String point) {
		return new Knight(createTeam(team), createPoint(point));
	}

	public static Pawn createPawn(String team, String point) {
		return new Pawn(createTeam(team), createPoint(point));
	}

	public static Queen createQueen(String team, String point) {
		return new Queen(createTeam(team), createPoint(point));
	}

	public static Rook createRook(String team, String point) {
		return new Rook(createTeam(team), createPoint(point));
	}

	public static Pieces createPieces(Piece... pieces) {
		Set<Piece> pieceSet = Arrays.stream(pieces)
				.collect(Collectors.toSet());

		return new Pieces(pieceSet);
	}

	public static StartPieces createStartPieces() {
		return new StartPieces();
	}

	public static Ended createEnded(Piece... pieces) {
		return new Ended(createPieces(pieces));
	}

	public static Started createStartedWithStartPieces(Piece... pieces) {
		return new Started(new Pieces(createStartPieces().getInstance()));
	}

	public static Moved createMoved(Piece... pieces) {
		return new Moved(createPieces(pieces));
	}

	public static MoveCommandTokens createMoveCommandTokens(String string) {
		return MoveCommandTokens.of(string);
	}

	public static RowOfBoard createEmptyRowOfBoard() {
		return RowOfBoard.createEmpty();
	}

	public static Board createBoard(Piece... pieces) {
		Set<Piece> pieceSet = Arrays.stream(pieces)
				.collect(Collectors.toSet());

		return Board.of(pieceSet);
	}
}
