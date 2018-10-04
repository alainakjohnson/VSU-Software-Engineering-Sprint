package sprint1;

import java.time.LocalDateTime;

public class TestMember {


	public static void main(String[] args) {
		Member member1 = new Member("Bob", "Smith", "bsmith88", "bsmith@yahoo.com", LocalDateTime.now());


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
		//join group
//		System.out.print("\n\nMEMBER dateJoined METHOD FOR BOB SMITH:\n\tDate member joined Group Java Beginngers" + member1.joinGroup(group1, Membership.getDateJoined(group1)) + "\n");
		//number of groups
		System.out.print("\n\nMEMBER getNumGroups METHOD FOR BOB SMITH:\n\tNumber of Groups this member is a member of: " + member1.getNumGroups() + "\n");
		//get group
		System.out.print("\n\nMEMBER getGroup METHOD FOR BOB SMITH:\n\tGroup Cooresponding to ID: " + member1.getGroup("Java Beginners") + "\n");
		//groups member belongs to
		System.out.print("\n\nMEMBER getGroups METHOD FOR BOB SMITH:\n\tGroups this member is a member of: " + member1.getGroups() + "\n");
		//add question
//		System.out.print("\n\nMEMBER addQuestion METHOD FOR BOB SMITH:\n\tQuestions asked by this member in this group: " + member1.addQuestion("Java Beginners","What does static mean?", dateAsked) + "\n");
//		//get date joined
//		System.out.print("\n\nMEMBER getDateJoined METHOD FOR BOB SMITH:\n\tDate this member joined this group: " + member1.getDateJoined() + "\n");
//		//add answer
//		System.out.print("\n\nMEMBER addAnswer METHOD FOR BOB SMITH:\n\tAnswers added to this question/date recorded: " + member1.addAnswer() + "\n");
//		//get questions
//		System.out.print("\n\nMEMBER getQuestions METHOD FOR BOB SMITH:\n\tQuestions asked by this member: " + member1.getQuestions() + "\n");
//		//get answers
//		System.out.print("\n\nMEMBER getAnswers METHOD FOR BOB SMITH:\n\tAnswers said by this member: " + member1.getAnswers() + "\n");

	}

}
