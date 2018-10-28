package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
//import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

	@Test
	@DisplayName ("Test joinGroup method")
	void testJoinGroup() {
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		
		member.joinGroup(group, LocalDateTime.now());
		
		Boolean expected = true;
		Boolean actual = false;
		
		if (group.getMember("email") != null ) {
			actual = true;
		}
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("Test getNumGroups method")
	void testGetNumGroups() {
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Group group1 = new Group ("GroupTitle1", "GroupDescription1", LocalDateTime.now());
		Group group2 = new Group ("GroupTitle2", "GroupDescription2", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		
		member.joinGroup(group, LocalDateTime.now());
		member.joinGroup(group1, LocalDateTime.now());
		member.joinGroup(group2, LocalDateTime.now());
		
		int expected = 3;
		int actual = member.getNumGroups();
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("Test getGroup method")
	void testGetGroup() {
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		member.joinGroup(group, LocalDateTime.now());
		member.getGroup("GroupTitle");
		
		Group expected = group;
		Group actual = member.getGroup("GroupTitle");
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("Test addQuestion method")
	void testAddQuestion() {
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		member.joinGroup(group, LocalDateTime.now());
		Question question = new Question("qTitle", "qtext", LocalDateTime.now());
		member.addQuestion(group, question, LocalDateTime.now());
				
		String expected = "qTitle";
		String actual = question.getTitle();
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("Test getDateJoined method")
	void testGetDateJoined() {
		LocalDateTime date;
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		member.joinGroup(group, date = LocalDateTime.now());
		
		LocalDateTime expected = date;
		LocalDateTime actual = member.getDateJoined(group);
		
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test for addAnswer method")
	void testAddAnswer() {
		Group group = new Group ("GroupTitle", "GroupDescription", LocalDateTime.now());
		Member member = new Member("first", "last", "screen", "email", LocalDateTime.now());
		member.joinGroup(group, LocalDateTime.now());
		Question question = new Question("qTitle", "qtext", LocalDateTime.now());
		Answer answer = new Answer (question, "AnswertoQ", LocalDateTime.now());
		member.addQuestion(group, question, LocalDateTime.now());
		member.addAnswer(group, question, answer, LocalDateTime.now());
				
		String expected = "AnswertoQ";
		String actual = answer.text;
		
		assertEquals(expected, actual);
	}


}
