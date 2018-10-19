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

	// helper methods
	//helper to add group to membership
	void addMembership (Membership membership){
		memberships.add(membership);
	}
	//
	//helper method comparator for sorting MEMBERS
	Comparator<Member> memberComparator = new Comparator<Member>() {
		public int compare(Member a, Member b) {
			int mem = a.getLastName().compareToIgnoreCase(b.getLastName());
			if (mem != 0)
				return mem;
			return a.getFirstName().compareToIgnoreCase(b.getFirstName());
			}};
	//
	//helper method comparator for sorting Groups
	Comparator<Post> sortByDate = new Comparator<Post>() {
		public int compare(Post a, Post b) {
			LocalDateTime Post1 = a.getDate();
			LocalDateTime Post2 = b.getDate();

			return Post1.compareTo(Post2);
			}};
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

	// SORT ON DATE MOST RECENT TO LEAST
	public List<Question> getQuestions(){
	List<Question> questions = new ArrayList<Question>();
		for(Membership m : memberships) {
			questions.addAll(m.getQuestions());
		}
		Collections.sort(questions, sortByDate);
		Collections.reverse(questions);
		return questions;
	}

	// SORT ON DATE MOST RECENT TO LEAST
	public List<Answer> getAnswers(){
	List<Answer> answers = new ArrayList<Answer>();
		for(Membership m : memberships) {
			answers.addAll(m.getAnswers());
		}

		Collections.sort(answers, sortByDate);
		 Collections.reverse(answers);
		return answers;
	}

	public String toString() {
		return "\nTitle: " + title
				+ "\nDescription: " + description
				+ "\nDate Created: " + dateCreated;
	}

}