package chess.domain.pieces;

import chess.domain.coordinate.Coordinate;
import chess.domain.coordinate.Direction;
import chess.domain.pieces.exceptions.CanNotMoveException;
import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BishopTest {
	Bishop bishop;

	@BeforeEach
	void setUp() {
		bishop = creationAssistant.createBishop("white", "a1");
	}

	@Test
	void move() {
		Coordinate coordinate = creationAssistant.createPoint("a2");
		Bishop expect = creationAssistant.createBishop("white", "a2");

		assertThat(bishop.move(coordinate)).isEqualTo(expect);
	}

	@Test
	@DisplayName("비숍이 갈 수 없는 방향일 시 예외를 던지는지 테스트")
	void canMove_ThrowException() {
		Direction direction = creationAssistant.createDirection("North");

		assertThatThrownBy(() -> bishop.validateMoveDirection(direction))
				.isInstanceOf(CanNotMoveException.class);
	}

	@Test
	@DisplayName("비숍이 갈 수 있는 방향일 시 예외를 던지지 않는지 테스트")
	void canMove() {
		Direction direction = creationAssistant.createDirection("North_East");

		bishop.validateMoveDirection(direction);
	}
}
