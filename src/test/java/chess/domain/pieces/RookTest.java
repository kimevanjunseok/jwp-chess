package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RookTest {
	Rook rook;

	@BeforeEach
	void setUp() {
		rook = creationAssistant.createRook("black", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("a2");
		Rook expect = creationAssistant.createRook("black", "a2");

		assertThat(rook.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove() {
		Direction direction = creationAssistant.createDirection("North_East");

		assertThatThrownBy(() -> rook.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}
}