package sprint1;

import java.time.LocalDateTime;

public class TestMember {

	
	public static void main(String[] args) {
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		
		
		//Testing the display for all basic Member values for member Bob Smith
		System.out.print("MEMBER toString METHOD FOR BOB SMITH:" + member1.toString());
		System.out.println("\n");
		System.out.print("\n\nMEMBER getTitle METHOD FOR BOB SMITH:\n\tFirst Name: " + member1.getFirstName());
		System.out.print("\n\nMEMBER getLastName METHOD FOR BOB SMITH:\n\tLast Name: " + member1.getLastName());
		System.out.print("\n\nMEMBER getScreenName METHOD FOR BOB SMITH:\n\tScreen Name: " + member1.getScreenName());
		System.out.print("\n\nMEMBER getEmailAddress METHOD FOR BOB SMITH:\n\tEmail: " + member1.getEmailAddress());
		System.out.print("\n\nMEMBER getDateCreated METHOD FOR BOB SMITH:\n\tAccount Created: " + member1.getDateCreated());
	}

}
