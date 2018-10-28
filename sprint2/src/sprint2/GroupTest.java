package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupTest {

	@Test
	@DisplayName ("test getNumMembers method")
	void testGetNumMembers() {
		Member member = new Member ("Bob", "Bobert", "boberto", "bob@bob", LocalDateTime.now());
		Member member1 = new Member ("Bobb", "Bobb", "bobb", "bobb@bob", LocalDateTime.now());
		Member member2 = new Member ("Bobby", "Bobby", "bobby", "bobby@bob", LocalDateTime.now());
		Group group = new Group ("BobGroup", "GroupForBobs", LocalDateTime.now());
		member.joinGroup(group, LocalDateTime.now());
		member1.joinGroup(group, LocalDateTime.now());
		member2.joinGroup(group, LocalDateTime.now());
		int actual = 3;
		int expected = group.getNumMembers();
		assertEquals(actual, expected);
	}
	
	@Test
	@DisplayName ("test getMember method")
	void testGetMember() {
		Member member = new Member ("Bob", "Bobert", "boberto", "bob@bob", LocalDateTime.now());
		Group group = new Group ("BobGroup", "GroupForBobs", LocalDateTime.now());
		member.joinGroup(group, LocalDateTime.now());
		
		Member actual = member;
		Member expected = group.getMember("bob@bob");
		assertEquals(actual, expected);
	}
	

}
