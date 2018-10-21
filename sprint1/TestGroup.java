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
		//date created
		System.out.print("\n\nDISPLAYING getDateCreated FOR JAVA BEGINNERS GROUP:\n\n\tGroup Created: " + group1.getDateCreated() + "\n");
		//title
		System.out.print("\nDISPLAYING getTitle FOR JAVA BEGINNERS GROUP:\n\n\tTitle: " + group1.getTitle() + "\n");
		//description
		System.out.print("\n\nDISPLAYING getDescription FOR JAVA BEGINNERS GROUP:\n\n\tDescription:" + group1.getDescription() + "\n");
		//number of members
		System.out.print("\nDISPLAYING getNumMembers FOR JAVA BEGINNERS GROUP:\n\n\tNumber of Members: " + group1.getNumMembers() + "\n");
		//member
		System.out.print("\nDISPLAYING getMember FOR JAVA BEGINNERS GROUP:\n\n\tMember associated with HSimpson@gmail.com: " + group1.getMember("bsmith@yahoo.com") + "\n");
		//get members
		System.out.print("\nDISPLAYING getMembers FOR JAVA BEGINNERS GROUP:\n\n\tMembers: " + group1.getMembers() + "\n");
		//get questions
		System.out.print("\n\nDISPLAYING getQuestions FOR JAVA BEGINNERS GROUP:\n\n\tQuestions Asked: " + group1.getQuestions() + "\n");
		//get answers
		System.out.print("\n\nDISPLAYING getAnswers FOR JAVA BEGINNERS GROUP:\n\n\tQuestions Answered: " + group1.getAnswers() + "\n");
	}

}
