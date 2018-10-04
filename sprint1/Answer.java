package sprint1;

import java.time.LocalDateTime;

class Answer extends Post {
		private Question question;

		public Answer(Question question, String text, LocalDateTime date){
			super(text, date);
			this.question = question;
		   }


		public Question getQuestion(){
			return question;
		}

		public String toString(){
			return "Answer for question: " + question.getTitle() + ": " +
					text +
				   "Created by user " + getAuthor() + " on " + getDate();
		}
	}