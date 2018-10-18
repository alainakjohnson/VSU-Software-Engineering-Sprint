package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Group{
	private LocalDateTime dateCreated;
	private String title;
	private String description;
//	private List<Question> questions;
//	private List<Answer> answers;
	private List<Membership> memberships = new ArrayList<Membership>();

	public Group(String title, String description, LocalDateTime dateCreated) {
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
	 }

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	//helper to add group to membership
	void addMembership (Membership membership){
		memberships.add(membership);
	}
	//

	public int getNumMembers() {
		return memberships.size();
	}

	public Member getMember(String emailAddress) {
		Member member = null;
		for(Membership m : memberships) {
			if(m.getMember().getEmailAddress().equals(emailAddress)) {
				member = m.getMember();
			}
		}
		return member;
	}

	// RETURN LIST OF ALL MEMBERS, SORTED BY LAST NAME THEN FIRST NAME
	public List<Member> getMembers(){
		List<Member> tempMemberList = new ArrayList<Member>();
			for(Membership m : memberships) {
				tempMemberList.add(m.getMember());
			}

		Collections.sort(tempMemberList, memberComparator);
		return tempMemberList;
	}

	//comparator for sorting MEMBERS
	 Comparator<Member> memberComparator = new Comparator<Member>() {

			public int compare(Member a, Member b) {
			   String memberName1 = a.getLastName().toUpperCase();
			   String memberName2 = b.getLastName().toUpperCase();

			   //ascending order
			   return memberName1.compareTo(memberName2);
		    }};

	// SORT ON DATE MOST RECENT TO LEAST
	public List<Question> getQuestions(){
	List<Question> questions = new ArrayList<Question>();
		for(Membership m : memberships) {
			questions.addAll(m.getQuestions());
		}
		return questions;
	}

	// SORT ON DATE MOST RECENT TO LEAST
	public List<Answer> getAnswers(){
	List<Answer> answers = new ArrayList<Answer>();
		for(Membership m : memberships) {
			answers.addAll(m.getAnswers());
		}
		return answers;
	}

	public String toString() {
		return "\nTitle: " + title
				+ "\nDescription: " + description
				+ "\nDate Created: " + dateCreated;
	}

}