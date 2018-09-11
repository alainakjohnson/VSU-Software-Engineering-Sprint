import java.util.*;


	public class Question {
		private String title;

		public Question(String title, String question, LocalDateTime dateCreated){

		      this.title = title;
		      this.question = question;
		      this.dateCreated = dateCreated;
		   }

		public String getTitle(){
			return title;
		}

		public void setTitle(String title){
			this.title = title;
		}

		public void addAnswer(Answer answer){
			this.Answer = answer;
			List<Answer> Answers = new List<>;

			Answers.add(this.Answer);
		}

		public List<Answer> getAnswer(){
			return List<Answer>;
		}

		public String toString(){
			return null;
		}