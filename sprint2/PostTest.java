package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class PostTest {

	@Test
	@DisplayName ("Post - Question: getText method")
	void testPostGetTextQ() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.getText();
		String expected = "question post";
		String actual = q.getText();
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName ("Post - Answer: getText method")
	void testPostGetTextA() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.getText();
		String expected = "answer post";
		String actual = a.getText();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Question: getDate method")
	void testPostGetDateQ() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.getDate();
		LocalDateTime expected = LocalDateTime.now();
		LocalDateTime actual = q.getDate();
		assertEquals(expected,actual);
	}

	@Test
	@DisplayName ("Post - Answer: getDate method")
	void testPostGetDateA() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.getDate();
		LocalDateTime expected = LocalDateTime.now();
		LocalDateTime actual = a.getDate();
		assertEquals(expected,actual);
	}
		
	@Test
	@DisplayName ("Post - Question: setText method")
	void testPostSetTextQ() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.setText("this is my new question!");
		String expected = "this is my new question!";
		String actual = q.getText();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Answer: setText method")
	void testPostSetTextA() {
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.setText("this is my new answer!");
		String expected = "this is my new answer!";
		String actual = a.getText();
		assertEquals(expected,actual);
	}
	

	@Test
	@DisplayName ("Post - Question: getAuthor method")
	void testPostGetAuthorQ() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.setMembership(membership);
		Member expected = m;
		Member actual = q.getAuthor();
		assertEquals(expected,actual);
	}
	
	
	@Test
	@DisplayName ("Post - Answer: getAuthor method")
	void testPostGetAuthorA() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.setMembership(membership);
		Member expected = m;
		Member actual = a.getAuthor();
		assertEquals(expected,actual);
	}
	
	
	@Test
	@DisplayName ("Post - Question: getGroup method")
	void testPostGetGroupQ() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.setMembership(membership);
		Group expected = g;
		Group actual = q.getGroup();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Answer: getGroup method")
	void testPostGetGroupA() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.setMembership(membership);
		Group expected = g;
		Group actual = a.getGroup();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Question: setMembership method")
	void testPostSetMembershipQ() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.setMembership(membership);
		Membership expected = membership;
		Membership actual = q.getMembership();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Answer: setMembership method")
	void testPostSetMembershipA() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.setMembership(membership);
		Membership expected = membership;
		Membership actual = a.getMembership();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Question: getMembership method")
	void testPostGetMembershipQ() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		q.setMembership(membership);
		Membership expected = membership;
		Membership actual = q.getMembership();
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName ("Post - Answer: getMembership method")
	void testPostGetMembershipA() {
		Member m = new Member ("Alaina", "Johnson", "akjohnson", "akjohnson@valdosta.edu",  LocalDateTime.now());
		Group g = new Group("Java Beginners", "a group for Java Beginners", LocalDateTime.now());
		Membership membership = new Membership(m, g, LocalDateTime.now());
		Question q = new Question("question title", "question post", LocalDateTime.now());
		Answer a = new Answer(q, "answer post", LocalDateTime.now());
		a.setMembership(membership);
		Membership expected = membership;
		Membership actual = a.getMembership();
		assertEquals(expected,actual);
	}
}
