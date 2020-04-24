package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QueenTest {
	Queen queen = creationAssistant.createQueen("black", "a1");

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("a2");
		Queen expect = creationAssistant.createQueen("black", "a2");

		assertThat(queen.move(coordinate)).isEqualTo(expect);
	}

	@Test
	void canMove() {
		Direction direction = creationAssistant.createDirection("knight");

		assertThatThrownBy(() -> queen.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}
}