package sprint1;

import java.time.LocalDateTime;

public class TestMember {


	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();

		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());
		Question question1 = new Question("What does static mean?", "Can someone explain to me what static means?", LocalDateTime.now());
		Answer answer1 = new Answer(question1, "It means that the object belongs to the class instead of instances of that class", LocalDateTime.now());
		Group group1 = new Group("Java Beginners", "A group for beginners", LocalDateTime.now());


		//Testing the display for all basic Member values for member Bob Smith
		System.out.print("MEMBER toString METHOD FOR BOB SMITH:" + member1.toString() + "\n");
		//email
		System.out.print("\n\nMEMBER getEmailAddress METHOD FOR BOB SMITH:\n\tEmail: " + member1.getEmailAddress() + "\n");
		//date created
		System.out.print("\n\nMEMBER getDateCreated METHOD FOR BOB SMITH:\n\tAccount Created: " + member1.getDateCreated() + "\n");
		//first name
		System.out.print("\n\nMEMBER getFirstName METHOD FOR BOB SMITH:\n\tFirst Name: " + member1.getFirstName() + "\n");
		//last name
		System.out.print("\n\nMEMBER getLastName METHOD FOR BOB SMITH:\n\tLast Name: " + member1.getLastName() + "\n");
		//screen name
		System.out.print("\n\nMEMBER getScreenName METHOD FOR BOB SMITH:\n\tScreen Name: " + member1.getScreenName() + "\n");
		member1.joinGroup(group1, date);
		//number of groups
		System.out.print("\n\nMEMBER getNumGroups METHOD FOR BOB SMITH:\n\tNumber of Groups this member is a member of: " + member1.getNumGroups() + "\n");
		//get group
		System.out.print("\n\nMEMBER getGroup METHOD FOR BOB SMITH:\n\tGroup Cooresponding to ID: " + member1.getGroup("Java Beginners") + "\n");
		//groups member belongs to
		System.out.print("\n\nMEMBER getGroups METHOD FOR BOB SMITH:\n\tGroups this member is a member of: " + member1.getGroups() + "\n");
		//add question
		member1.addQuestion(member1.getGroup("Java Beginners"), question1, date);
//		//get date joined
		System.out.print("\n\nMEMBER getDateJoined METHOD FOR BOB SMITH:\n\tDate this member joined this group: " + member1.getDateJoined(group1) + "\n");
//		//add answer
		member1.addAnswer(member1.getGroup("Java Beginners"), question1, answer1, date);
		//get questions
		System.out.print("\n\nMEMBER getQuestions METHOD FOR BOB SMITH:\n\tQuestions asked by this member: " + member1.getQuestions(member1.getGroup("Java Beginners")) + "\n");
		//get answers
		System.out.print("\n\nMEMBER getAnswers METHOD FOR BOB SMITH:\n\tAnswers from this member: " + member1.getAnswers(member1.getGroup("Java Beginners")) + "\n");
	}

}
