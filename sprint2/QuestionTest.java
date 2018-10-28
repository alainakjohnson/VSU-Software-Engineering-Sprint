package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuestionTest {

	@Test
	@DisplayName ("Question: getTitle method")
	void testQuestionGetTitle() {
		Question q = new Question("title", "post", LocalDateTime.now());
		q.getTitle();
		String expected = "title";
		String actual = q.getTitle();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Question: setTitle method")
	void testQuestionSetTitle() {
		Question q = new Question("title", "post", LocalDateTime.now());
		q.setTitle("new title");
		String expected = "new title";
		String actual = q.getTitle();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Question: addAnswer method")
	void testQuestionAddAnswer() {
		Question q = new Question("title", "post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		q.addAnswer(a);
		Answer expected = a;
		Answer actual = q.getAnswer().get(0);
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Question: getAnswer method")
	void testQuestionGetAnswer() {
		Question q = new Question("title", "post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		Answer a2 = new Answer(q, "answer post", LocalDateTime.now());
		q.addAnswer(a);
		q.addAnswer(a2);
		Answer expected = a2;
		Answer actual = q.getAnswer().get(1);
		assertEquals(expected,actual);
	}
	

}