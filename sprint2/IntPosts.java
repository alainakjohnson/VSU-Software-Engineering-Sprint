package sprint2;

import java.time.LocalDateTime;
import java.time.Month;

public class IntPosts {
	
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
			
			//Adding and removing votes from Question 1
			bob.setVote(1, question1);
			aaron.setVote(1, question1);
			bart.setVote(0, question1);
			
			//Adding and removing votes from Question 2
			bob.setVote(0, question2);
			aaron.setVote(1, question2);
			bart.setVote(0, question2);
			
			//Adding and removing votes from Answer 1
			aaron.setVote(1, answer1);
			
			//Adding the points from the post to the members
			question1.addToMemberPoints(question1.getPoints());
			question2.addToMemberPoints(question2.getPoints());
			answer1.addToMemberPoints(answer1.getPoints());
	
	System.out.println("\n************************************************");

	System.out.println("+===================POSTS===================+");

	//Basic Getters using question1 and answer1
	System.out.println("\n|==========Basic Getters:==========|");
	System.out.println("getTitle(): " + question1.getTitle());
	System.out.println("getText(): " + question1.getText());
	System.out.println("getDate(): " + question1.getDate());
	System.out.println("getAuthor(): " + question1.getAuthor());
	System.out.println("getGroup(): " + question1.getGroup());
	System.out.println("getAnswer(): " + question1.getAnswer());
	System.out.println("getPoints(): " + question1.getPoints());
	System.out.println("-------------------------------------");
	System.out.println("getQuestion(): " + answer1.getQuestion());
	System.out.println("-------------------------------------");
	System.out.println("getMembership() for question1: \n" + question1.getMembership());
	System.out.println("getMembership() for answer1: \n" + answer1.getMembership());
	System.out.println("\n|=================================|");

	System.out.println("\n************************************************");

	}
}
