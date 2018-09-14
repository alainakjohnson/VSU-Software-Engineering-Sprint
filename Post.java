package sprint1;

import java.time.LocalDateTime;

public abstract class Post {
	
	protected String text;
	protected LocalDateTime date;
	
	public Post(String text, LocalDateTime date) {
		
		this.text = text;
		this.date = date;
	}
	
	public String getText() {
		
		return text;
		
	}
	
	public LocalDateTime getDate() {
		
		return date;
		
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	public Member getAuthor() {
		
		return;
	}
	
	public Group getGroup() {
		
		return;
	}
	
	protected void setMembership(Membership membership) {
		
		
	}
	
	protected Membership getMembership() {
		
		return 
	}
}

