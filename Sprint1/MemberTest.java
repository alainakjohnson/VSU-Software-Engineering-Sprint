package sprint1;

import java.time.LocalDateTime;

public class MemberTest {
	
	public static void main(String[] args) {
		//Creating test members
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		
		//Testing the display for all basic Member values for member Bob Smith
		System.out.print(member1.toString());
		System.out.println("\n");
		System.out.print("\n\nFirst Name: " + member1.getFirstName());
		System.out.print("\n\nLast Name: " + member1.getLastName());
		System.out.print("\n\nScreen Name: " + member1.getScreenName());
		System.out.print("\n\nEmail: " + member1.getEmailAddress());
		System.out.print("\n\nAccount Created: " + member1.getDateCreated());
	}
}