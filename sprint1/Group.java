package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Group{
	LocalDateTime dateCreated;
	String title;
	String description;
	
	
	
	public Group(String title, String description, LocalDateTime dateCreated) {
		final ArrayList<Member> memberList = new ArrayList<Member>();
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
