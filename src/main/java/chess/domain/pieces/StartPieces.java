package chess.domain.pieces;

import static chess.domain.team.Team.BLACK;
import static chess.domain.team.Team.WHITE;

import chess.domain.coordinate.Column;
import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Row;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StartPieces {
    private static Set<Piece> pieces;

    static {
        pieces = new HashSet<>();
        pieces.add(new King(BLACK, new Coordinate(Row.EIGHT, Column.E)));
        pieces.add(new King(WHITE, new Coordinate(Row.ONE, Column.E)));
        pieces.add(new Queen(BLACK, new Coordinate(Row.EIGHT, Column.D)));
        pieces.add(new Queen(WHITE, new Coordinate(Row.ONE, Column.D)));
        pieces.add(new Bishop(BLACK, new Coordinate(Row.EIGHT, Column.C)));
        pieces.add(new Bishop(BLACK, new Coordinate(Row.EIGHT, Column.F)));
        pieces.add(new Bishop(WHITE, new Coordinate(Row.ONE, Column.C)));
        pieces.add(new Bishop(WHITE, new Coordinate(Row.ONE, Column.F)));
        pieces.add(new Knight(BLACK, new Coordinate(Row.EIGHT, Column.B)));
        pieces.add(new Knight(BLACK, new Coordinate(Row.EIGHT, Column.G)));
        pieces.add(new Knight(WHITE, new Coordinate(Row.ONE, Column.B)));
        pieces.add(new Knight(WHITE, new Coordinate(Row.ONE, Column.G)));
        pieces.add(new Rook(BLACK, new Coordinate(Row.EIGHT, Column.A)));
        pieces.add(new Rook(BLACK, new Coordinate(Row.EIGHT, Column.H)));
        pieces.add(new Rook(WHITE, new Coordinate(Row.ONE, Column.A)));
        pieces.add(new Rook(WHITE, new Coordinate(Row.ONE, Column.H)));

        for (Column column: Column.values()) {
            pieces.add(new Pawn(BLACK, new Coordinate(Row.SEVEN, column)));
            pieces.add(new Pawn(WHITE, new Coordinate(Row.TWO, column)));
        }
    }

    public Set<Piece> getInstance() {
        return Collections.unmodifiableSet(pieces);
    }
}