package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.team.Team;

public class Bishop extends Piece {

    public Bishop(Team team, Coordinate coordinate) {
        super(PieceType.BISHOP, team, coordinate);
    }

    @Override
    public Piece move(Coordinate afterCoordinate) {
        return new Bishop(getTeam(), afterCoordinate);
    }

    @Override
    public void validateMoveDirection(Direction direction) {
        if (direction.isNotDiagonal()) {
            throw new CanNotMoveException("비숍은 대각선으로만 움직일 수 있습니다.");
        }
    }
}
