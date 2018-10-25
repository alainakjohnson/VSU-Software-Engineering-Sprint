package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

	@Test
	@DisplayName ("Answer: getQuestion method")
	void testAnswerGetQuestion() {
		Question q = new Question("title", "post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.getQuestion();
		Question expected = q;
		Question actual = a.getQuestion();
		assertEquals(expected,actual);
	}

}
