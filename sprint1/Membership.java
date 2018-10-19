package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Membership{

   //private int points;
   private LocalDateTime dateJoined;
   private Member member;
   private Group group;
   private List<Question> questions = new ArrayList<Question>();
   private List<Answer> answers = new ArrayList<Answer>();

   public Membership (Member member, Group group, LocalDateTime dateJoined){
   		this.member = member;
   		this.group = group;
   		this.dateJoined = dateJoined;
   }

   public String toString(){
	   return "dateJoined: " + member + " joined " + group + ".";
   }

   LocalDateTime getDateJoined(){
	   return dateJoined;
   }

   Member getMember(){
	   return member;
   }

   Group getGroup(){
	   return group;
   }

   List<Question> getQuestions(){
	   return questions;
   }

   List<Answer> getAnswers(){
	   return answers;
   }
}
