package chess.domain.state;

import chess.domain.testAssistant.creationAssistant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStateTest {

	@Test
	void pushCommand_Start() {
		Ended ended = creationAssistant.createEnded();
		Started started = creationAssistant.createStartedWithStartPieces();

		assertThat(ended.pushCommend("start")).isEqualTo(started);
	}

	@Test
	void pushCommend_Move() {
		Moved moved = creationAssistant.createMoved(creationAssistant.createPawn("white", "a2"),
				creationAssistant.createKing("white", "c1"),
				creationAssistant.createKing("black", "d1"));
		Moved expect = creationAssistant.createMoved(creationAssistant.createPawn("white", "a4"),
				creationAssistant.createKing("white", "c1"),
				creationAssistant.createKing("black", "d1"));

		assertThat(moved.pushCommend("move a2 a4")).isEqualTo(expect);
	}
}