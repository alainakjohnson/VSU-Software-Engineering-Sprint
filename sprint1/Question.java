package sprint1;

import java.util.*;
import java.time.LocalDateTime;

class Question extends Post {
	private String title;
	private List<Answer> answers = new ArrayList<Answer>();

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

	public String toString(){
		return getTitle() + "\n" +
			   getText() + "\n" +
			   "Created by user: " + getAuthor() + " on " + getDate() + "\n";
	}
}