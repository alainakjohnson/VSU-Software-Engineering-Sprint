package sprint1;

import java.util.*;

class Answer extends Post {
		public Answer(Question question, String answer, LocalDateTime dateCreated){
		      answer = text;
		      this.question = question;//Need to change this to relate to actual question
		      this.dateCreated = date;
		   }


		public Question getQuestion(){
			return question;
		}

		public String toString(){
			return getQuestion.toString() + 
				   text +
				   "Created by user " + getAuthor() + " on " + getDate();
		}


	}