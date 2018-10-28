package sprint2;

import java.time.LocalDateTime;

class Comment extends Post {
	private Question question;
	int maxLength = 150;

	public Comment(Question question, String text, LocalDateTime date){
		super(text, date);
		this.question = question;
		
		if (text.length() >= maxLength)
			this.text = text.substring(0, maxLength);
		else this.text = text;
		}
		
	public Question getQuestion(){
		return question;
		}

	public String toString(){
		return "Comment for question: " + question.getTitle() + ": " +
				text + "\n" +
				"Created by user: " + getAuthor() + " on " + getDate() + "\n";
		}
}