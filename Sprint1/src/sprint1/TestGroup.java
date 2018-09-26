package sprint1;

import java.time.LocalDateTime;

public class TestGroup {

	public static void main(String[] args) {
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		
		
		//Display the info for Java Beginners
		System.out.print("\nDISPLAYING THE toString METHOD OF GROUP:\n\t" + group1.toString());
		//Display the list of groups
		System.out.println("\n");
		
		//Displaying the basic Group values for group Java Beginners
		System.out.print("\nDISPLAYING getTitle FOR JAVA BEGINNERS GROUP:\n\n\tTitle: " + group1.getTitle());
		System.out.print("\n\nDISPLAYING getDescription FOR JAVA BEGINNERS GROUP:\n\n\tDescription:" + group1.getDescription());
		System.out.print("\n\nDISPLAYING getDateCreated FOR JAVA BEGINNERS GROUP:\n\n\tGroup Created: " + group1.getDateCreated());
		System.out.println("\n\n");

	}

}
