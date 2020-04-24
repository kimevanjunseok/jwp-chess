package chess.domain.coordinate;

import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceTest {

	@Test
	@DisplayName("수직과 수평일 시 테스트")
	void of_VerticalOrHorizontal() {
		Distance expect = creationAssistant.createDistance("one");
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("a2");

		assertThat(Distance.of(from, to)).isEqualTo(expect);
	}

	@Test
	@DisplayName("대각선일 시 테스트")
	void of_Diagonal() {
		Distance expect = creationAssistant.createDistance("one");
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("b2");

		assertThat(Distance.of(from, to)).isEqualTo(expect);
	}

	@Test
	@DisplayName("수직 2칸일 시 테스트")
	void of_VerticalTwo() {
		Distance expect = creationAssistant.createDistance("vertical_two");
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("a3");

		assertThat(Distance.of(from, to)).isEqualTo(expect);
	}

	@Test
	@DisplayName("수평 2칸일 시 Else가 나오는지 테스트")
	void of_HorizontalTwo() {
		Distance expect = creationAssistant.createDistance("else");
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("c1");

		assertThat(Distance.of(from, to)).isEqualTo(expect);
	}

	@Test
	@DisplayName("그 외 Else가 나오는지 테스트")
	void of_Else() {
		Distance expect = creationAssistant.createDistance("else");
		Coordinate from = creationAssistant.createPoint("a1");
		Coordinate to = creationAssistant.createPoint("c2");

		assertThat(Distance.of(from, to)).isEqualTo(expect);
	}
}