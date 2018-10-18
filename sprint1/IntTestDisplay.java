package sprint1;

import java.time.LocalDateTime;
public class IntTestDisplay{

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();

		//Creating groups and members
		Group javaBeginners = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group javaExperts = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member bob = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member homer = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());
		Member bart = new Member("Bart", "Simpson", "bartman", "eatmyshorts@gmail.com", LocalDateTime.now());
		Member aaron = new Member("Aaron", "Aaronson", "bigA", "aaaaaaaa@gmail.com", LocalDateTime.now());
		Question question1 = new Question("What does static mean?", "Can someone explain to me what static means?", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "It means that the object belongs to the class instead of instances of that class", LocalDateTime.now());
		Question question2 = new Question("I have another question", "What is the meaning of life?", LocalDateTime.now());
		Answer answer2 = new Answer(question2, "No one knows.", LocalDateTime.now());

		//Display the info for Java Beginners
		System.out.print("GROUP INFO:\n" + javaBeginners.toString());

		//Joining Bob to both groups
		bob.joinGroup(javaBeginners, LocalDateTime.now());
		bob.joinGroup(javaExperts, LocalDateTime.now());
		//Joining Homer to only one group
		homer.joinGroup(javaBeginners, LocalDateTime.now());
		//Joining Aaron to only one group for sorting reasons
		aaron.joinGroup(javaBeginners, LocalDateTime.now());
		//Joining Bart to only one group for sorting reasons
		bart.joinGroup(javaBeginners, LocalDateTime.now());

		//Member retrieves information for group by searching for Java Beginners
		System.out.println("\n\nUSING MEMBER getGroup METHOD TO RETRIEVE JAVA BEGINNERS GROUP INFO:\n" + bob.getGroup("Java Beginners"));

		//Retrieving member Bob Smith from Java Beginners group
		System.out.println("\n\nUSING GROUP getMember METHOD TO RETRIEVE BOB SMITH USING HIS EMAIL:\n" + javaBeginners.getMember("bsmith@yahoo.com"));

		//Retrieving the number of members in Java Beginners group and displaying all members
		System.out.println("\nNUMBER OF MEMBERS IN JAVA BEGINNERS // getNumMembers(): " + javaBeginners.getNumMembers());
		System.out.println("\n\nGETTING THE LIST OF MEMBERS IN JAVA BEGINNERS // getMembers():\n" + javaBeginners.getMembers());

		//Displaying search for Homer Simpson
		System.out.println("\n\nRETRIEVING MEMBER HOMER SIMPSON FROM JAVA EXPERTS GROUP USING HIS EMAIL:\n" + javaBeginners.getMember("HSimpson@gmail.com"));

		//Displaying how many groups Bob Smith is in
		System.out.println("\n\nNUMBER OF GROUPS BOB IS IN: " + bob.getNumGroups());
		System.out.println("\n\nGROUPS BOB IS A MEMBER OF:\n" + bob.getGroups());

		//Displaying all questions for GROUP 1 "Java Beginners"
		//Displaying all answers for GROUP 1 "Java Beginners"
		//NOT WORKING**********
		System.out.println("\n\nQUESTIONS FROM THE GROUP:\n" + javaBeginners.getQuestions());
		System.out.println("ANSWERS FROM THE GROUP:\n" + javaBeginners.getAnswers());

		//Homer asks a question.
		//add question
		homer.addQuestion(homer.getGroup("Java Beginners"), question1, date);
		//get date joined
		System.out.print("\n\nMEMBER getDateJoined METHOD FOR BOB SMITH:\n\tDate this member joined this group: \n" + bob.getDateJoined(javaBeginners) + "\n");
		//add answer
		bob.addAnswer(bob.getGroup("Java Beginners"), question1, answer1, date);
		//second question and answer
		homer.addQuestion(homer.getGroup("Java Beginners"), question2, date);
		bob.addAnswer(bob.getGroup("Java Beginners"), question2, answer2, date);
		//get questions
		System.out.print("\n\nMEMBER getQuestions METHOD FOR HOMER SIMPSON:\n\tQuestions asked by this member: \n" + homer.getQuestions(homer.getGroup("Java Beginners")) + "\n");
		//get answers
		System.out.print("\n\nMEMBER getAnswers METHOD FOR BOB SMITH:\n\tAnswers from this member: \n" + bob.getAnswers(bob.getGroup("Java Beginners")) + "\n");



	}


}
