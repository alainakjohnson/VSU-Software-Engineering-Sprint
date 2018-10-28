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
	
	Comment comment1 = new Comment (question1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla bibendum euismod sodales. Nullam finibus ex nec ornare feugiat. Curabitur hendrerit pellentesque nunc ut ullamcorper. Phasellus vulputate rhoncus purus, id pulvinar ligula cursus faucibus. Mauris tempus diam ex, eget accumsan quam dictum a. In mauris lectus, porttitor id urna vel, euismod ultricies justo. Curabitur convallis elementum leo, id dignissim enim luctus ut. Integer quis convallis est.", date);
	
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
			
			//BART adds a comment to question1
			bart.addComment(javaBeginners, question1, comment1, date);

			//AARON asks a question and Homer answers it
			aaron.addQuestion(javaBeginners, question3, date);
			homer.addAnswer(javaBeginners, question3, answer3, date);

			//Some Questions from BOB in Java Gods
			bob.addQuestion(javaGods, question4, date);
			bob.addQuestion(javaGods, question4, date);
			
			//Adding and removing votes from Question 1
			bob.setVote(1, question1);
			aaron.setVote(1, question1);
			bart.setVote(1, question1);
			// 3 points total for this question to Homer
			
			//Adding and removing votes from Question 2
			bob.setVote(0, question2);
			aaron.setVote(1, question2);
			bart.setVote(0, question2);
			// -1 points total for this question to Homer
			
			//Adding and removing votes from Question 3
			bob.setVote(1, question3);
			homer.setVote(1, question3);
			// 2 points total for this question to Aaron
			
			//Adding and removing votes from Answer 1
			aaron.setVote(1, answer1);
			// 1 point total for this question to Bob
	
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
	System.out.println("-------------------------------------");
	System.out.println("getQuestion(): " + answer1.getQuestion());
	System.out.println("-------------------------------------");
	System.out.println("getMembership() for question1: \n" + question1.getMembership());
	System.out.println("getMembership() for answer1: \n" + answer1.getMembership());
	System.out.println("\n|=================================|");
	
	//returns total points for question
	//Question 1 should be 3
	//Question 2 should be -1
	//Question 3 should be 2
	//Answer 1 should be 1
	System.out.println("\n|==========getPoints():==========|");
	System.out.println("Question 1's Points: " + question1.getPoints());
	System.out.println("Question 2's Points: " + question2.getPoints());
	System.out.println("Question 3's Points: " + question3.getPoints());
	System.out.println("Answer 1's Points: " + answer1.getPoints());
	System.out.println("\n|================================|");
	
	System.out.println("\n+===================COMMENTS===================+");
	System.out.println("getComment(): " + question1.getComment());
	System.out.println("\n|=================================|");

	System.out.println("\n************************************************");

	}
}
