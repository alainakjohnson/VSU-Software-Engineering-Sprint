package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class SiteManagerTest {

	@Test
	@DisplayName ("test addMember method, member doesnt exist")
	void testAddMember1() {
		SiteManager sm = new SiteManager();
		boolean expected = true;
		boolean actual = sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test addMember method, member exists")
	void testAddMember2() {
		SiteManager sm = new SiteManager();
		sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		boolean expected = false;
		boolean actual = sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getMember method, member exists")
	void testGetMember1() {
		SiteManager sm = new SiteManager();
		sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Member expected = new Member("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Member actual = sm.getMember("jsmith@yahoo.com");
		assertEquals(expected.getEmailAddress(), actual.getEmailAddress());
	}
	
	@Test
	@DisplayName ("test getMember method, member doesn't exist")
	void testGetMember2() {
		SiteManager sm = new SiteManager();
		Member expected = null;
		Member actual = sm.getMember("jsmith@yahoo.com");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getMembers method")
	void testGetMembers1() {
		SiteManager sm = new SiteManager();
		List<String> expected = new ArrayList<String>();
		expected.add("Bob");
		expected.add("Jane");
		expected.add("Jim");
		sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Jane", "Smith", "janeSmith", "janesmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Bob", "Ross", "Boss", "boss@yahoo.com", LocalDateTime.now());
		List<Member> temp = new ArrayList<Member>();
		temp = sm.getMembers();
		List<String> actual = new ArrayList<String>();
		for(Member m : temp) {
			actual.add(m.getFirstName());
		}
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getMembers search method")
	void testGetMembers2() {
		SiteManager sm = new SiteManager();
		sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Jane", "Smith", "janeSmith", "janesmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Bob", "Ross", "Boss", "boss@yahoo.com", LocalDateTime.now());
		String search = "esmith";
		List<Member> actual = sm.getMembers(search);
		List<Member> expected = new ArrayList<Member>();
		expected.add(sm.getMember("janesmith@yahoo.com"));
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test addGroup method, group doesnt exist")
	void testAddGroup1() {
		SiteManager sm = new SiteManager();
		boolean expected = true;
		boolean actual = sm.addGroup("Group", "Testing", LocalDateTime.now());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test addGroup method, group exists")
	void testAddGroup2() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		boolean expected = false;
		boolean actual = sm.addGroup("Group", "Testing", LocalDateTime.now());
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getGroup method, group exists")
	void testGetGroup1() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		Group expected = new Group("Group", "Testing", LocalDateTime.now());
		Group actual = sm.getGroup("Group");
		assertEquals(expected.getTitle(), actual.getTitle());
	}
	
	@Test
	@DisplayName ("test getGroup method, group doesn't exist")
	void testGetGroup2() {
		SiteManager sm = new SiteManager();
		Group expected = null;
		Group actual = sm.getGroup("Group");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getGroups method")
	void testGetGroups1() {
		SiteManager sm = new SiteManager();
		List<String> expected = new ArrayList<String>();
		expected.add("Group");
		expected.add("Org");
		expected.add("Team");
		sm.addGroup("Org", "Sitting", LocalDateTime.now());
		sm.addGroup("Team", "Playing", LocalDateTime.now());
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		List<Group> temp = new ArrayList<Group>();
		temp = sm.getGroups();
		List<String> actual = new ArrayList<String>();
		for(Group g : temp) {
			actual.add(g.getTitle());
		}
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getGroups search method")
	void testGetGroups2() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Org", "Sitting", LocalDateTime.now());
		sm.addGroup("Team", "Playing", LocalDateTime.now());
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		String search = "Play";
		List<Group> actual = sm.getGroups(search);
		List<Group> expected = new ArrayList<Group>();
		expected.add(sm.getGroup("Team"));
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getPopularGroups method")
	void testGetPopularGroups() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Org", "Sitting", LocalDateTime.now());
		sm.addGroup("Team", "Playing", LocalDateTime.now());
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		sm.addGroup("Troupe", "Dancing", LocalDateTime.now());
		sm.addGroup("Squadron", "Flying", LocalDateTime.now());
		Member m1 = new Member("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Member m2 = new Member("Jane", "Smith", "janeSmith", "janesmith@yahoo.com", LocalDateTime.now());
		Member m3 = new Member("Bob", "Ross", "Boss", "boss@yahoo.com", LocalDateTime.now());
		m1.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m3.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m1.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		List<Group> actual = sm.getPopularGroups(1);
		List<Group> expected = new ArrayList<Group>();
		expected.add(sm.getGroup("Squadron"));
		expected.add(sm.getGroup("Team"));
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getActiveGroups method")
	void testGetActiveGroups() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Org", "Sitting", LocalDateTime.now());
		sm.addGroup("Team", "Playing", LocalDateTime.now());
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		sm.addGroup("Troupe", "Dancing", LocalDateTime.now());
		sm.addGroup("Squadron", "Flying", LocalDateTime.now());
		Member m1 = new Member("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Member m2 = new Member("Jane", "Smith", "janeSmith", "janesmith@yahoo.com", LocalDateTime.now());
		Member m3 = new Member("Bob", "Ross", "Boss", "boss@yahoo.com", LocalDateTime.now());
		m1.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m3.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m1.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		Question question1 = new Question("q1", "qtext", LocalDateTime.now());
		Question question2 = new Question("q2", "qtext", LocalDateTime.now());
		Question question3 = new Question("q3", "qtext", LocalDateTime.now());
		Question question4 = new Question("q4", "qtext", LocalDateTime.now());
		Question question5 = new Question("q5", "qtext", LocalDateTime.now());
		m1.addQuestion(sm.getGroup("Squadron"), question1, LocalDateTime.now());
		m2.addQuestion(sm.getGroup("Squadron"), question2, LocalDateTime.now());
		m3.addQuestion(sm.getGroup("Squadron"), question3, LocalDateTime.now());
		m1.addQuestion(sm.getGroup("Team"), question4, LocalDateTime.now());
		m2.addQuestion(sm.getGroup("Team"), question5, LocalDateTime.now());
		List<Group> actual = sm.getActiveGroups(1);
		List<Group> expected = new ArrayList<Group>();
		expected.add(sm.getGroup("Squadron"));
		expected.add(sm.getGroup("Team"));
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName ("test getActiveMembers method")
	void testGetActiveMembers() {
		SiteManager sm = new SiteManager();
		sm.addGroup("Org", "Sitting", LocalDateTime.now());
		sm.addGroup("Team", "Playing", LocalDateTime.now());
		sm.addGroup("Group", "Testing", LocalDateTime.now());
		sm.addGroup("Troupe", "Dancing", LocalDateTime.now());
		sm.addGroup("Squadron", "Flying", LocalDateTime.now());
		sm.addMember("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Jane", "Smith", "janeSmith", "janesmith@yahoo.com", LocalDateTime.now());
		sm.addMember("Bob", "Ross", "Boss", "boss@yahoo.com", LocalDateTime.now());
		Member m1 = sm.getMember("jsmith@yahoo.com");
		Member m2 = sm.getMember("janesmith@yahoo.com");
		Member m3 = sm.getMember("boss@yahoo.com");
		m1.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m3.joinGroup(sm.getGroup("Squadron"), LocalDateTime.now());
		m1.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		m2.joinGroup(sm.getGroup("Team"), LocalDateTime.now());
		Question question1 = new Question("q1", "qtext", LocalDateTime.now());
		Question question2 = new Question("q2", "qtext", LocalDateTime.now());
		Question question3 = new Question("q3", "qtext", LocalDateTime.now());
		Question question4 = new Question("q4", "qtext", LocalDateTime.now());
		Question question5 = new Question("q5", "qtext", LocalDateTime.now());
		m1.addQuestion(sm.getGroup("Squadron"), question1, LocalDateTime.now());
		m2.addQuestion(sm.getGroup("Squadron"), question2, LocalDateTime.now());
		m3.addQuestion(sm.getGroup("Squadron"), question3, LocalDateTime.now());
		m1.addQuestion(sm.getGroup("Team"), question4, LocalDateTime.now());
		m2.addQuestion(sm.getGroup("Team"), question5, LocalDateTime.now());
		List<Member> actual = sm.getActiveMembers(1);
		List<Member> expected = new ArrayList<Member>();
		expected.add(sm.getMember("jsmith@yahoo.com"));
		expected.add(sm.getMember("janesmith@yahoo.com"));
		assertEquals(expected, actual);
	}
}
