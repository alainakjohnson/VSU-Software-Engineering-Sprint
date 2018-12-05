package application.classes;

import java.util.*;
import java.time.LocalDateTime;

class Question extends Post {
	private String title;
	private List<Answer> answers = new ArrayList<Answer>();
	private List<Comment> comments = new ArrayList<Comment>();

	public Question(String title, String text, LocalDateTime date){
		super(text, date);
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void addAnswer(Answer answer){
		answers.add(answer);
	}

	public List<Answer> getAnswer(){
		return answers;
	}

	//// Added for Requirement 6 ////
	
	public void addComment(Comment comment){
		comments.add(comment);
	}

	public List<Comment> getComment(){
		return comments;
	}
	
	////

	public String toString(){
		return getTitle() + "\n" +
			   getText() + "\n" +
			   "Created by user: " + getAuthor() + " on " + getDate() + "\n";
	}

}
