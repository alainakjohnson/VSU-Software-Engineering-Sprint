package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupTest {
	
	
	public static void main(String[] args) {
		//Creating groups and members
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group group2 = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member member2 = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());
		
		//Storing groups in the membership list of groups
		Membership.storeGroup(group1);
		Membership.storeGroup(group2);
		
		//Display the info for Java Beginners
		System.out.print("\n\n" + group1.toString());
		//Display the list of groups
		System.out.println("\n");
		Membership.displayGroupList();
		System.out.println("\n");
		
		//Displaying the basic Group values for group Java Beginners
		System.out.print("\nTitle: " + group1.getTitle());
		System.out.print("\n\nDescription:" + group1.getDescription());
		System.out.print("\n\nGroup Created: " + group1.getDateCreated());
		System.out.println("\n");
		
		//Joining members to groups
		member1.joinGroup(group1, LocalDateTime.now());
		member2.joinGroup(group1, LocalDateTime.now());
		member2.joinGroup(group2, LocalDateTime.now());
		
		//Retrieving member Bob Smith from Java Beginners group
		System.out.println("\n" + group1.getMember("bsmith@yahoo.com"));
		
		//Retrieving the number of members in Java Beginners group and displaying all members
		System.out.println("\nNumber of Members in Java Beginners: " + group1.getNumMembers());
		System.out.println("\n" + group1.getMembers());
		
		//Displaying search for Homer Simpson
		System.out.println("\n" + group2.getMember("HSimpson@gmail.com"));
		
		//Displaying all members in the Java Experts group
		System.out.println("\n" + group2.getMembers());
	}	
}