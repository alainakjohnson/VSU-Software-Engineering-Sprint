package sprint1;

import java.time.LocalDateTime;

public class IntTestDisplay{

	public static void main(String[] args) {
		//Creating groups and members
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group group2 = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member member2 = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());

		//Storing groups in the membership list of groups
//		Membership.storeGroup(group1);
//		Membership.storeGroup(group2);

		//Display the info for Java Beginners
		System.out.print("GROUP INFO:\n" + group1.toString());
		//Display the list of groups
//		System.out.println("\n\nDISPLAYING THE LIST OF GROUPS:");
//		Membership.displayGroupList();
//		System.out.println("\n");


		//Joining Bob to only one group
		member1.joinGroup(group1, LocalDateTime.now());
		//Joining Homer to both groups
		member2.joinGroup(group1, LocalDateTime.now());
		member2.joinGroup(group2, LocalDateTime.now());



		//Member retrieves information for group by searching for Java Beginners
		System.out.println("\n\nUSING MEMBER getGroup METHOD TO RETRIEVE JAVA BEGINNERS GROUP INFO:\n" + member1.getGroup("Java Beginners"));

		//Retrieving member Bob Smith from Java Beginners group
		System.out.println("\n\nUSING GROUP getMember METHOD TO RETRIEVE BOB SMITH USING HIS EMAIL:\n" + group1.getMember("bsmith@yahoo.com"));

		//Retrieving the number of members in Java Beginners group and displaying all members
		System.out.println("\nNUMBER OF MEMBERS IN JAVA BEGINNERS: " + group1.getNumMembers());
		System.out.println("\n\nGETTING THE LIST OF MEMBERS IN JAVA BEGINNERS:\n" + group1.getMembers());

		//Displaying search for Homer Simpson
		System.out.println("\n\nRETRIEVING MEMBER HOMER SIMPSON FROM JAVA EXPERTS GROUP USING HIS EMAIL:\n" + group2.getMember("HSimpson@gmail.com"));

		//Displaying all members in the Java Experts group
		System.out.println("\n\nGETTING THE LIST OF MEMBERS IN JAVA EXPERTS:\n" + group2.getMembers());

		//Displaying how many groups Homer Simpson is in
		System.out.println("\nNUMBER OF GROUPS HOMER IS IN: " + member2.getNumGroups());
		System.out.println("\nGROUPS HOMER IS A MEMBER OF:\n" + member2. getGroups());





	}


}
