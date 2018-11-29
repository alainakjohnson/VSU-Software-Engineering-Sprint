package sprint2;

import java.time.LocalDateTime;

public abstract class Post {

	protected String text;
	protected LocalDateTime date;
	protected Membership membership;
	protected int points = 0;
	protected int vote;

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
		return membership.getMember();
	}

	public Group getGroup() {
		return membership.getGroup();
	}

	protected void setMembership(Membership membership) {
		this.membership = membership;
	}

	protected Membership getMembership() {
		return membership;
	}
	
	//// Added for Requirement 6 ////
	
	//adds points to the question
	void setPoints(int vote){
		if(vote == 1) {
 			this.points++;
 			addToMemberPoints(1);
 		}
 		else if(vote == 0) {
 			this.points--;	
 			addToMemberPoints(-1);
 		}
	}
	
	int getPoints(){
		return points;
	}
	
	//adds points to total member count.
	void addToMemberPoints(int points){
 		getAuthor().setPoints(points);
	}
	
}
