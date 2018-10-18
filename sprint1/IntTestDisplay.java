package sprint1;

import java.time.LocalDateTime;
//import java.time.Month;
public class IntTestDisplay{

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		//LocalDateTime oldDate =LocalDateTime.of(2017,Month.APRIL,17,8,5); //used for testing order

		//Creating groups and members
		Group javaBeginners = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group javaExperts = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Member bob = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member homer = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());
		Member bart = new Member("Bart", "Simpson", "bartman", "eatmyshorts@gmail.com", LocalDateTime.now());
		Member aaron = new Member("Aaron", "Aaronson", "bigA", "aaaaaaaa@gmail.com", LocalDateTime.now());

		Question question1 = new Question("What does static mean?", "Can someone explain to me what static means?", LocalDateTime.now());
		Question question2 = new Question("I have another question", "What is the meaning of life?", LocalDateTime.now());

		Answer answer1 = new Answer(question1, "It means that the object belongs to the class instead of instances of that class", LocalDateTime.now());
		Answer answer2 = new Answer(question2, "No one knows.", LocalDateTime.now());

		//ACTIONS:

		//Joining Bob to both groups

		bob.joinGroup(javaExperts, LocalDateTime.now());
		bob.joinGroup(javaBeginners, LocalDateTime.now());

		//Joining Homer to only one group
		homer.joinGroup(javaBeginners, LocalDateTime.now());

		//Joining Aaron to only one group for sorting reasons
		aaron.joinGroup(javaBeginners, LocalDateTime.now());

		//Joining Bart to only one group for sorting reasons
		bart.joinGroup(javaBeginners, LocalDateTime.now());

		//HOMER asks a question
		homer.addQuestion(homer.getGroup("Java Beginners"), question1, date);

		//BOB answers the question
		bob.addAnswer(bob.getGroup("Java Beginners"), question1, answer1, date);

		//HOMER asks another question, and Bob answers it
		homer.addQuestion(homer.getGroup("Java Beginners"), question2, date);
		bob.addAnswer(bob.getGroup("Java Beginners"), question2, answer2, date);


		//MEMBER METHODS:
		System.out.println("+===================MEMBER METHODS===================+");

		//Basic getters (using Bob as Example)
		System.out.println("\n|==========Basic Getters:==========|");
		System.out.println("getEmailAddress(): " + bob.getEmailAddress());
		System.out.println("getDateCreated(): " + bob.getDateCreated());
		System.out.println("getFirstName(): " + bob.getFirstName());
		System.out.println("getLastName(): " + bob.getLastName());
		System.out.println("getScreenName(): " + bob.getScreenName());
		System.out.println("\n|==================================|");

		//Retrieves information for Java Beginners if Bob is a member.
		//Should return Null if person is not a member.
		System.out.println("\n|==========getGroup():==========|");
		System.out.println(bob.getGroup("Java Beginners"));
		System.out.println(bart.getGroup("Java Experts"));
		System.out.println("\n|===============================|");

		//Retrieves the number of Groups Bob is a member of.
		System.out.println("\n|==========getNumGroups():==========|");
		System.out.println(bob.getNumGroups());
		System.out.println("\n|===================================|");

		//Retrieves the groups Bob is a member of.
		//Sorted by Title.
		//Java Beginners -> Java Experts
		System.out.println("\n|==========getGroups():==========|");
		System.out.println(bob.getGroups());
		System.out.println("\n|================================|");

		//Retrieves the date Bob joined Java Beginners.
		System.out.println("\n|==========getDateJoined():==========|");
		System.out.println(bob.getDateJoined(javaBeginners));
		System.out.println("\n|================================|");

		//Retrieves all questions Homer has asked in Java Beginners:
		//sorted from most to least recent.
		System.out.println("\n|==========getQuestions():==========|");
		System.out.println(homer.getQuestions(homer.getGroup("Java Beginners")));
		System.out.println("\n|================================|");

		//Retrieves all answers Bob has answered in Java Beginners:
		//sorted from most to least recent.
		System.out.println("\n|==========getAnswers():==========|");
		System.out.println(bob.getAnswers(bob.getGroup("Java Beginners")));
		System.out.println("\n|================================|");

		System.out.println("\n************************************************");

		System.out.println("+===================GROUP METHODS===================+");
		//GROUP METHODS:

		//Basic getters (using Java Beginners)
		System.out.println("\n|==========Basic Getters:==========|");
		System.out.println("getDateCreated(): " + javaBeginners.getDateCreated());
		System.out.println("getTitle(): " + javaBeginners.getTitle());
		System.out.println("getDescription(): " + javaBeginners.getDescription());
		System.out.println("\n|==================================|");

		//Retrieving member Bob Smith from Java Beginners group
		System.out.println("\n|==========getMember():==========|");
		System.out.println(javaBeginners.getMember("bsmith@yahoo.com"));
		System.out.println("\n|================================|");

		//Retrieving number of members in Java Beginners
		System.out.println("\n|==========getNumMembers():==========|");
		System.out.println(javaBeginners.getNumMembers());
		System.out.println("\n|====================================|");

		//Retrieving member by email address.
		System.out.println("\n|==========getMember():==========|");
		System.out.println(javaBeginners.getMember("HSimpson@gmail.com"));
		System.out.println("\n|================================|");

		//Retrieving members in Java Beginners in alphabetical order,
		//sorted by last name, then first name.
		//the order this should appear in: Aaron -> Bart -> Homer -> Bob
		System.out.println("\n|==========getMembers():==========|");
		System.out.println(javaBeginners.getMembers());
		System.out.println("\n|=================================|");

		//Retrieving all questions for Java Beginners ** DOES NOT WORK **
		//sorted from most to least recent
		System.out.println("\n|==========getQuestions():==========|");
		System.out.println(javaBeginners.getQuestions());
		System.out.println("\n|===================================|");

		//Retrieving all answers for Java Beginners ** DOES NOT WORK **
		//sorted from most to least recent
		System.out.println("\n|==========getAnswers():==========|");
		System.out.println(javaBeginners.getAnswers());
		System.out.println("\n|=================================|");

		System.out.println("\n************************************************");

		System.out.println("+===================POSTS===================+");

		//Basic Getters using question1 and answer2
		System.out.println("\n|==========Basic Getters:==========|");
		System.out.println("getTitle(): " + question1.getTitle());
		System.out.println("getText(): " + question1.getText());
		System.out.println("getDate(): " + question1.getDate());
		System.out.println("getAuthor(): " + question1.getAuthor());
		System.out.println("getGroup(): " + question1.getGroup());
		System.out.println("getAnswer(): " + question1.getAnswer());
		System.out.println("-------------------------------------");
		System.out.println("getQuestion(): " + answer1.getQuestion());
		System.out.println("-------------------------------------");
		System.out.println("getMembership() for question1: \n" + question1.getMembership());
		System.out.println("getMembership() for answer1: \n" + answer1.getMembership());
		System.out.println("\n|=================================|");

		System.out.println("\n************************************************");

		//toStrings:
		//Display the info for the Groups:
		System.out.println("\n|==========GROUP INFO:==========|");
		System.out.println(javaBeginners.toString());
		System.out.println(javaExperts.toString());
		System.out.println("\n|===============================|");

		//Display the info for the Members:
		System.out.println("\n|==========MEMBER INFO:==========|");
		System.out.println(bob.toString());
		System.out.println(homer.toString());
		System.out.println(aaron.toString());
		System.out.println(bart.toString());
		System.out.println("\n|===============================|");

		//Display the info for Question 1:
		System.out.println("\n|==========QUESTION 1:==========|");
		System.out.println(question1.toString());
		System.out.println("\n|===============================|");

		//Display the info for Answer 1:
		System.out.println("\n|==========Answer 1:==========|");
		System.out.println(answer1.toString());
		System.out.println("\n|===============================|");

	}


}
