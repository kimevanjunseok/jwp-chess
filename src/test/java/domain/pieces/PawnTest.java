package domain.pieces;

import domain.pieces.exceptions.CanNotAttackException;
import domain.pieces.exceptions.CanNotMoveException;
import domain.pieces.exceptions.CanNotReachException;
import domain.coordinate.Direction;
import domain.coordinate.Distance;
import domain.coordinate.Coordinate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static domain.testAssistant.creationAssistant.createDirection;
import static domain.testAssistant.creationAssistant.createDistance;
import static domain.testAssistant.creationAssistant.createPawn;
import static domain.testAssistant.creationAssistant.createPoint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PawnTest {
	Pawn pawn;
	Pawn pawnOnceMoved;

	@BeforeEach
	void setUp() {
		pawn = createPawn("black", "a1");
		pawnOnceMoved = createPawn("black", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = createPoint("a2");
		Pawn expect = createPawn("black", "a2");

		assertThat(pawn.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove() {
		Direction direction = createDirection("North");

		assertThatThrownBy(() -> pawn.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}

	@Test
	void canAttack() {
		Direction direction = createDirection("North_East");
		Piece other = createPawn("white", "a2");

		assertThatThrownBy(() -> pawn.validateAttack(direction, other))
				.isInstanceOf(CanNotAttackException.class);
	}

	@Test
	void canReach() {
		Distance distance = createDistance("vertical_two");

		assertThatThrownBy(() -> pawnOnceMoved.validateReach(distance))
				.isInstanceOf(CanNotReachException.class);
	}
}