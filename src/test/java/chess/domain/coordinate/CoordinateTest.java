package chess.domain.coordinate;

import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

	@Test
	void test() {
		assertThat(new Coordinate(Row.EIGHT, Column.A)).isEqualTo(new Coordinate(Row.EIGHT, Column.A));
	}

	@Test
	void add() {
		Coordinate coordinate = creationAssistant.createPoint("b2");
		Coordinate expect = creationAssistant.createPoint("a1");

		assertThat(coordinate.add(1, -1)).isEqualTo(expect);
	}

	@Test
	void getRepresentation() {
		assertThat(new Coordinate(Row.FOUR, Column.E).getRepresentation()).isEqualTo("e4");
	}
}