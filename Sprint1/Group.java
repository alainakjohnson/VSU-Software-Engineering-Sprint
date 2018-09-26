package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Group{
	LocalDateTime dateCreated;
	String title;
	String description;
	List<Member> memberList = new ArrayList<Member>();
	
	
	public Group(String title, String description, LocalDateTime dateCreated) {
		//final ArrayList<Member> memberList = new ArrayList<Member>();
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
		int numMem = 0;
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i) != null) {
				
				numMem++;
			}
		}
		return numMem;
	}
	
	public Member getMember(String emailAddress) {
		Member member = null;
		for(int i = 0; i < memberList.size(); i++) {
			
			if(memberList.get(i).getEmailAddress().equals(emailAddress)) {
				
				member = memberList.get(i);
			}
			
		}
		return member;
	}
	
	public List<Member> getMembers(){
		
		return memberList;
	}
	
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
