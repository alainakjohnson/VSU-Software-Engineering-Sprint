
package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Group{
	private LocalDateTime dateCreated;
	private String title;
	private String description;
	private List<Question> questions = new ArrayList<Question>();
	private List<Answer> answers = new ArrayList<Answer>();
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

	public int getNumMembers() {
		return memberships.size();
	}

	public Member getMember(String emailAddress) {
		Member member = null;
		for(int i = 0; i < memberships.size(); i++) {
			if(memberships.getMember(i).getMember.equals(emailAddress)) {
				member = memberships.get(i);
			}
		}
		return member;
	}

	public List<Member> getMembers(){
		return memberships.getMember();
	}

	public List<Question> getQuestions(){
		return questions;
	}

	public List<Answer> getAnswers(){
		return answers;
	}

	public String toString() {
		return "\nTitle: " + title
				+ "\nDescription: " + description
				+ "\nDate Created: " + dateCreated;
	}
}