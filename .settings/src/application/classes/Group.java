package application.classes;

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

	//// HELPER METHODS ////
	
	// add group to membership
	void addMembership (Membership membership){
		memberships.add(membership);
	}
	//
	
	// comparator for sorting MEMBERS
	Comparator<Member> sortByName = new Comparator<Member>() {
		public int compare(Member a, Member b) {
			int mem = a.getLastName().compareToIgnoreCase(b.getLastName());
			if (mem != 0)
				return mem;
			return a.getFirstName().compareToIgnoreCase(b.getFirstName());
			}};
	//
			
	// comparator for sorting Groups
	Comparator<Post> sortByDate = new Comparator<Post>() {
		public int compare(Post a, Post b) {
			LocalDateTime Post1 = a.getDate();
			LocalDateTime Post2 = b.getDate();

			return Post2.compareTo(Post1);
			}};
	//
			
	// comparator for sorting activity
	Comparator<Member> sortByActive = new Comparator<Member>() {
		public int compare(Member a, Member b) {
			int Member1 = a.getQuestions(a.getGroup(title)).size()+a.getAnswers(a.getGroup(title)).size();
			int Member2 = b.getQuestions(b.getGroup(title)).size()+b.getAnswers(b.getGroup(title)).size();

			return Member2 - Member1;
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

		Collections.sort(tempMemberList, sortByName);
		return tempMemberList;
	}


	// RETURN LIST OF MOST ACTIVE MEMBERS sorted by activity (total questions+answers), most active to least
	public List<Member> getActiveMembers(int n){
		List<Member> mostActiveMembers = new ArrayList<Member>();
		mostActiveMembers = getMembers();
		Collections.sort(mostActiveMembers, sortByActive);
		if(n >= mostActiveMembers.size()){
			return mostActiveMembers;
			}
		mostActiveMembers = mostActiveMembers.subList(0, n);
		return mostActiveMembers;
	}


	// SORT ON DATE MOST RECENT TO LEAST
	public List<Question> getQuestions(){
	List<Question> questions = new ArrayList<Question>();
		for(Membership m : memberships) {
			questions.addAll(m.getQuestions());
		}
		Collections.sort(questions, sortByDate);
		return questions;
	}

	//get the n most recent answers from above
	public List<Question> getQuestions(int n){
	List<Question> questions = new ArrayList<Question>();
		for(Membership m : memberships) {
			questions.addAll(m.getQuestions());
		}
		Collections.sort(questions, sortByDate);

		if(n >= questions.size())
			return questions;
		else
			return questions = questions.subList(0, n);
	}

	// SORT ON DATE MOST RECENT TO LEAST
	public List<Answer> getAnswers(){
	List<Answer> answers = new ArrayList<Answer>();
		for(Membership m : memberships) {
			answers.addAll(m.getAnswers());
		}
		Collections.sort(answers, sortByDate);
		return answers;
	}

	//get the n most recent answers from above
	public List<Answer> getAnswers(int n){
		List<Answer> answers = new ArrayList<Answer>();
			for(Membership m : memberships) {
				answers.addAll(m.getAnswers());
			}

			Collections.sort(answers, sortByDate);

			if(n >= answers.size())
				return answers;
			else
				return answers = answers.subList(0, n);
		}

	public String toString() {
		return "Title: " + title
				+ "\nDescription: " + description
				+ "\nDate Created: " + dateCreated;
	}

}
