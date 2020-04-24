package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class KnightTest {
	Knight knight;

	@BeforeEach
	void setUp() {
		knight = creationAssistant.createKnight("black", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("b3");
		Knight expect = creationAssistant.createKnight("black", "b3");

		assertThat(knight.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove() {
		Direction direction = creationAssistant.createDirection("North");

		assertThatThrownBy(() -> knight.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}
}