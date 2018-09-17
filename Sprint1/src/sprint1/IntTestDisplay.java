package sprint1;

import java.time.LocalDateTime;

public class IntTestDisplay{
	
	public static void main(String[] args) {
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group group2 = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member member = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Membership.storeGroup(group1);
		Membership.storeGroup(group2);
		
		System.out.print(member.toString());
		System.out.print("\n\n" + group1.toString());
		System.out.println("\n");
		Membership.displayGroupList();
		
	}
	

}
