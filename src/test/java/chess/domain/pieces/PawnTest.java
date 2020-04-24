package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.coordinate.Distance;
import chess.domain.pieces.exceptions.CanNotAttackException;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.pieces.exceptions.CanNotReachException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PawnTest {
	Pawn pawn;
	Pawn pawnOnceMoved;

	@BeforeEach
	void setUp() {
		pawn = creationAssistant.createPawn("black", "a1");
		pawnOnceMoved = creationAssistant.createPawn("black", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("a2");
		Pawn expect = creationAssistant.createPawn("black", "a2");

		assertThat(pawn.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove() {
		Direction direction = creationAssistant.createDirection("North");

		assertThatThrownBy(() -> pawn.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}

	@Test
	void canAttack() {
		Direction direction = creationAssistant.createDirection("North_East");
		Piece other = creationAssistant.createPawn("white", "a2");

		assertThatThrownBy(() -> pawn.validateAttack(direction, other))
				.isInstanceOf(CanNotAttackException.class);
	}

	@Test
	void canReach() {
		Distance distance = creationAssistant.createDistance("vertical_two");

		assertThatThrownBy(() -> pawnOnceMoved.validateReach(distance))
				.isInstanceOf(CanNotReachException.class);
	}
}