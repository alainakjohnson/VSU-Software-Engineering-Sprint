package sprint2;

import java.time.LocalDateTime;
import java.time.Month;

public class IntMemberGroupMembership {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		LocalDateTime pastDate =LocalDateTime.of(2017,Month.APRIL,17,8,5); //used for testing order

		//Creating groups and members
		Group javaBeginners = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());
		Group javaExperts = new Group("Java Experts", "A group for the best programmers", LocalDateTime.now());
		Group javaGods = new Group("Java Gods", "A locked group for only the best of the best", LocalDateTime.now());
		Group awesomeProgrammers = new Group("Awesome Programmers", "a group for awesome programmers!!!!!!!!!!!!!!!!", LocalDateTime.now());
		Member bob = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Member homer = new Member("Homer", "Simpson", "donuts", "HSimpson@gmail.com", LocalDateTime.now());
		Member bart = new Member("Bart", "Simpson", "bartman", "eatmyshorts@gmail.com", LocalDateTime.now());
		Member aaron = new Member("Aaron", "Aaronson", "bigA", "aaaaaaaa@gmail.com", LocalDateTime.now());

		Question question1 = new Question("What does static mean?", "Can someone explain to me what static means?", LocalDateTime.now());
		Question question2 = new Question("What is the meaning of life?", "Just what the title says", pastDate);
		Question question3 = new Question("Hi! I'm new!", "What is Java exactly?", LocalDateTime.now());
		Question question4 = new Question("This is a dummy question.", "Text", LocalDateTime.now());

		Answer answer1 = new Answer(question1, "It means that the object belongs to the class instead of instances of that class", LocalDateTime.now());
		Answer answer2 = new Answer(question2, "No one knows.", pastDate);
		Answer answer3 = new Answer(question3, "I'm Homer.", LocalDateTime.now());

		//VOID METHODS:

		//Joining Bob to both groups

		bob.joinGroup(javaExperts, LocalDateTime.now());
		bob.joinGroup(javaBeginners, LocalDateTime.now());
		bob.joinGroup(javaGods, LocalDateTime.now());
		bob.joinGroup(awesomeProgrammers, LocalDateTime.now());

		//Joining Homer to only one group
		homer.joinGroup(javaBeginners, LocalDateTime.now());

		//Joining Aaron to only one group for sorting reasons
		aaron.joinGroup(javaBeginners, LocalDateTime.now());

		//Joining Bart to only one group for sorting reasons
		bart.joinGroup(javaBeginners, LocalDateTime.now());

		//HOMER asks a question
		homer.addQuestion(javaBeginners, question1, date);

		//BOB answers the question
		bob.addAnswer(javaBeginners, question1, answer1, date);

		//HOMER asks another question, and Bob answers it
		homer.addQuestion(javaBeginners, question2, date);
		bob.addAnswer(javaBeginners, question2, answer2, date);

		//AARON asks a question and Homer answers it
		aaron.addQuestion(javaBeginners, question3, date);
		homer.addAnswer(javaBeginners, question3, answer3, date);

		//Some Questions from BOB in Java Gods
		bob.addQuestion(javaGods, question4, date);
		bob.addQuestion(javaGods, question4, date);


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
		System.out.println("\n|==========getGroup(String):==========|");
		System.out.println(bob.getGroup("Java Beginners"));
		System.out.println(bart.getGroup("Java Experts"));
		System.out.println("\n|===============================|");

		//Retrieves the number of Groups Bob is a member of.
		System.out.println("\n|==========getNumGroups():==========|");
		System.out.println(bob.getNumGroups());
		System.out.println("\n|===================================|");

		//Retrieves the groups Bob is a member of.
		//Sorted by Title.
		//Awesome Programmers -> Java Beginners -> Java Experts -> Java Gods
		System.out.println("\n|==========getGroups():==========|");
		System.out.println(bob.getGroups());
		System.out.println("\n|================================|");

		//Sorted by title, the groups Bob is most active in.
		//Awesome Programmers -> Java Beginners -> Java Gods
		System.out.println("\n|==========getGroups(int):==========|");
		System.out.println(bob.getGroups(3));
		System.out.println("\n|================================|");

		//Retrieves the date Bob joined Java Beginners.
		System.out.println("\n|==========getDateJoined(Group):==========|");
		System.out.println(bob.getDateJoined(javaBeginners));
		System.out.println("\n|================================|");

		//Retrieves all questions Homer has asked in Java Beginners:
		//sorted from most to least recent.
		//Should sort: question 1 (What does static mean?) -> question 2 (What is the meaning of life?)
		System.out.println("\n|==========getQuestions(Group):==========|");
		System.out.println(homer.getQuestions(javaBeginners));
		System.out.println("\n|================================|");

		//Should return: question 1 ONLY
		System.out.println("\n|==========getQuestions(Group, int):==========|");
		System.out.println(homer.getQuestions(javaBeginners,1));
		System.out.println("\n|================================|");

		//Retrieves all answers Bob has answered in Java Beginners:
		//sorted from most to least recent.
		//Should sort: Answer 1 (It means the object belongs to the class...) -> Answer 2 (No one knows)
		System.out.println("\n|==========getAnswers(Group):==========|");
		System.out.println(bob.getAnswers(javaBeginners));
		System.out.println("\n|================================|");

		//Should return: all answers even tho its less than 3
		System.out.println("\n|==========getAnswers(Group, int):==========|");
		System.out.println(bob.getAnswers(javaBeginners,3));
		System.out.println("\n|================================|");
		
		//Retrieves points associated with the member
		//Homer = 2 points; Bob = 0 points;
		System.out.println("\n|==========getPoints():==========|");
		System.out.println(homer.getPoints());
		System.out.println(bob.getPoints());
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
		System.out.println("\n|==========getMember(String):==========|");
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

		//Retrieving members in Java Beginners in order of who is most active
		// should be Homer (3 total posts) -> Bob (2 total posts) -> Aaron (1 total post) (Bart has 0 posts)
		System.out.println("\n|==========getActiveMembers(int):==========|");
		System.out.println(javaBeginners.getActiveMembers(3));
		System.out.println("\n|===================================|");

		//Retrieving all questions for Java Beginners
		//sorted from most to least recent
		//Should sort: Question 3 (Hi! I'm new!) -> Question 1 (What does static mean?) -> Question 2 (What is the meaning of life?)
		System.out.println("\n|==========getQuestions():==========|");
		System.out.println(javaBeginners.getQuestions());
		System.out.println("\n|===================================|");

		//Should post all 3 questions.
		System.out.println("\n|==========getQuestions(int):==========|");
		System.out.println(javaBeginners.getQuestions(4));
		System.out.println("\n|===================================|");

		//Retrieving all answers for Java Beginners
		//sorted from most to least recent
		//Should sort: Answer 3 ("I'm Homer) -> Answer 1 (It means the object belongs to the class...) -> Answer 2 (No one knows)
		System.out.println("\n|==========getAnswers():==========|");
		System.out.println(javaBeginners.getAnswers());
		System.out.println("\n|=================================|");

		//Should only post 1 answer
		System.out.println("\n|==========getAnswers(int):==========|");
		System.out.println(javaBeginners.getAnswers(1));
		System.out.println("\n|=================================|");

		System.out.println("\n************************************************");
	}
}