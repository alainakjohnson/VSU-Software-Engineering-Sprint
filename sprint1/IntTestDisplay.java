package sprint1;

import java.time.LocalDateTime;

public class IntTestDisplay{

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();

		//Creating groups and members
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group group2 = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member member2 = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());
		Question question1 = new Question("What does static mean?", "Can someone explain to me what static means?", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "It means that the object belongs to the class instead of instances of that class", LocalDateTime.now());

		//Display the info for Java Beginners
		System.out.print("GROUP INFO:\n" + group1.toString());

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

		//BOB asks a question. Questions
		//add question
		member1.addQuestion(member1.getGroup("Java Beginners"), question1, date);
		//get date joined
		System.out.print("\n\nMEMBER getDateJoined METHOD FOR BOB SMITH:\n\tDate this member joined this group: " + member1.getDateJoined(group1) + "\n");
		//add answer
		member1.addAnswer(member1.getGroup("Java Beginners"), question1, answer1, date);
		//get questions
		System.out.print("\n\nMEMBER getQuestions METHOD FOR BOB SMITH:\n\tQuestions asked by this member: " + member1.getQuestions(member1.getGroup("Java Beginners")) + "\n");
		//get answers
		System.out.print("\n\nMEMBER getAnswers METHOD FOR BOB SMITH:\n\tAnswers from this member: " + member1.getAnswers(member1.getGroup("Java Beginners")) + "\n");



	}


}
