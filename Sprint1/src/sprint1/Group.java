
package sprint1;

import java.time.LocalDateTime;

public class Group{
	LocalDateTime dateCreated;
	String title;
	String description;
	
	public Group(String title, String description, LocalDateTime dateCreated) {
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
	}
	
//	public int getNumMembers() {
//		return this.List<Members>.size;
//	}
//	
//	public Member getMember(String emailAddress) {
//		
//	}
//	
//	public List<Member> getMembers(){
//		
//	}
//	
//	public List<Question> getQuestions(){
//		
//	}
//	
//	public List<Answer> getAnswers(){
//		
//	}
	
	public String toString() {
		return "\nTitle: " + title 
				+ "\nDescription: " + description
				+ "\nDate Created: " + dateCreated;
	}
}