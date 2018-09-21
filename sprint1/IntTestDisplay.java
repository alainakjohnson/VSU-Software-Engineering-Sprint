package sprint1;

import java.time.LocalDateTime;

public class IntTestDisplay{
	
	public static void main(String[] args) {
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group group2 = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Membership membership1 = new Membership(group1);
		
		
		//Membership.storeGroup(group1);
		//Membership.storeGroup(group2);
		
		//for group
		System.out.print("\n\n" + group1.toString());
		System.out.println("\n");
		Membership.displayGroupList();
		System.out.println("\n");
		System.out.print(group1.getTitle());
		System.out.println("\n");
		System.out.print(group1.getDescription());
		System.out.println("\n");
		System.out.print(group1.getDateCreated());
		System.out.println("\n");
		
		//for member
		System.out.print(member1.toString());
		System.out.println("\n");
		System.out.print(member1.getFirstName());
		System.out.println("\n");
		System.out.print(member1.getLastName());
		System.out.println("\n");
		System.out.print(member1.getScreenName());
		System.out.println("\n");
		System.out.print(member1.getEmailAddress());
		System.out.println("\n");
		System.out.print(member1.getDateCreated());
		
		//System.out.println(Membership.getNumG());
		
		//member1.joinGroup(group1, member1.getDateCreated());
		
		
		
	}
	

}