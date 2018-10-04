package sprint1;

import java.time.LocalDateTime;

public abstract class Post {

	protected String text;
	protected LocalDateTime date;
	protected Membership membership;

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
}


