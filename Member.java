import java.util.*;

public class Member {

	LocalDateTime dateCreated;
	String firstName;
	String lastName;
	String screenName;
	String emailAddress;
	Scanner scan = new Scanner();

   public Member(String firstName, String lastName, String screenName, String emailAddress, LocalDateTime dateCreated){
   
      this.firstName = firstName;
      this.lastName = lastName;
      this.screenName = screenName;
      this.emailAddress = emailAddress;
      this.dateCreated = dateCreated;
   }

	public String getEmailAddress(){

	}

	public LocalDateTime getDateCreated(){

	}

	public String getFirstName(){


	}
	public String getLastName(){
			
	}

	public String getScreenName(){
			
	}

	public void joinGroup(String groupName){
			
	}

	public int getNumGroups(){

	}

   public int getGroup(String groupID){
   
   }
   
   public List<Group> getGroups(){
   
   }
   
   public void addQuestion(Group group, Question question, LocalDateTime date){
   
   }
   
   public LocalDateTime getDateJoined(Group group){
   
   
   }
   
   public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date){
   
   }
   
   public List<Question> getQuestions(Group group){
   
   
   }
   
   public List<Answer> getAnswer(Group group){
   
   
   }
   
   public String toString(){
   
   
   }
}