package sprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MembershipTest {

	@Test
	@DisplayName ("test getMember method")
	void testGetMember() {
		Member member = new Member ("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Group group = new Group ("Jim's Group", "GroupMadeByJim", LocalDateTime.now());
		Membership membership = new Membership(member, group, LocalDateTime.now());
		
		Member actual = membership.getMember();
		Member expected = member;
		assertEquals(actual, expected);
	}
	
	@Test
	@DisplayName ("test getGroup method")
	void testGetGroup() {
		Member member = new Member ("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Group group = new Group ("Jim's Group", "GroupMadeByJim", LocalDateTime.now());
		Membership membership = new Membership(member, group, LocalDateTime.now());
		
		Group actual = membership.getGroup();
		Group expected = group;
		assertEquals(actual, expected);
	}
	
	@Test
	@DisplayName ("test getDateJoined method")
	void testGetDateJoined() {
		LocalDateTime date;
		Member member = new Member ("Jim", "Smith", "jSmith", "jsmith@yahoo.com", LocalDateTime.now());
		Group group = new Group ("Jim's Group", "GroupMadeByJim", LocalDateTime.now());
		Membership membership = new Membership(member, group, date =LocalDateTime.now());
		
		LocalDateTime actual = membership.getDateJoined();
		LocalDateTime expected = date;
		assertEquals(actual, expected);
	}

}
