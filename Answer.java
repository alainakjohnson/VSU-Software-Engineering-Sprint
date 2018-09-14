import java.util.*;

public class Answer implements Post {
		public Answer(Question question, String answer, LocalDateTime dateCreated){
		      this.title = title;
		      this.question = question;
		      this.dateCreated = dateCreated;
		   }


		public Question getQuestion(){
			return question;
		}

		public String toString(){
			return null;
		}


	}