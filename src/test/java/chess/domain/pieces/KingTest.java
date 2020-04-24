package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.coordinate.Distance;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.pieces.exceptions.CanNotReachException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KingTest {
	King king;

	@BeforeEach
	void setUp() {
		king = creationAssistant.createKing("black", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("a2");
		King expect = creationAssistant.createKing("black", "a2");

		assertThat(king.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove_ThrowException() {
		Direction direction = creationAssistant.createDirection("knight");

		assertThatThrownBy(() -> king.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}

	@Test
	void canReach() {
		Distance distance = creationAssistant.createDistance("vertical_two");

		assertThatThrownBy(() -> king.validateReach(distance))
				.isInstanceOf(CanNotReachException.class);

	}
}