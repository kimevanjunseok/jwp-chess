package chess.domain.coordinate;

import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

	@Test
	void of_N() {
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("a2");
		Direction expect = creationAssistant.createDirection("North");

		assertThat(Direction.of(from, to)).isEqualTo(expect);
	}

	@Test
	void of_Ne() {
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("b2");
		Direction expect = creationAssistant.createDirection("North_East");

		assertThat(Direction.of(from, to)).isEqualTo(expect);
	}

	@Test
	void of_Knight() {
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("c2");
		Direction expect = creationAssistant.createDirection("knight");

		assertThat(Direction.of(from, to)).isEqualTo(expect);
	}

	@Test
	void of_SamePosition_Else() {
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("a1");
		Direction expect = creationAssistant.createDirection("else");

		assertThat(Direction.of(from, to)).isEqualTo(expect);
	}

	@Test
	void of_ElsePosition_Else() {
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("h2");
		Direction expect= creationAssistant.createDirection("else");

		assertThat(Direction.of(from, to)).isEqualTo(expect);
	}
}