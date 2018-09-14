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

	public static String getEmailAddress(){
		return emailAddress;
	}

	public static String getDateCreated(){
		return dateCreated;
	}

	public static String getFirstName(){
		return firstName;
	}
	
	public static String getLastName(){
		return lastName;
	}

	public static String getScreenName(){
		return screenName;
	}

	public void joinGroup(Group group, LocalDateTime dateJoined){		
		group.add(this.Member)
		dateJoined = LocalDateTime
	}

	public int getNumGroups(){
		return this.getGroups().size;
	}

    public Group getGroup(String groupID){
    	for (int i = 0; i < this.List<Group>.size; i++) {
			if(this.List<Group>.get(i).title == groupID)
				return this.List<Group>.get(i);
    }
   
   public List<Group> getGroups(){
    	List<Group> groups = new List;
		groups.add();
    	return groups;
   }
   
   public void addQuestion(Group group, Question question, LocalDateTime date){
		List<Question> Questions = new List; 
		Questions.add(this.Question);
   }
   
   public LocalDateTime getDateJoined(Group group){
		return joinGroup.dateJoined;
   }
   
   public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date){
	   List<Answer> Answers = new List; 
	   Answers.add(this.Answer);		
   }
   
   public List<Question> getQuestions(Group group){
		return Questions;
   }
   
   public List<Answer> getAnswer(Group group){   
		return Answers;
   }
  
   public String toString(){
	    return "First Name" + firstName
			+ "Last Name" + lastName
	   		+ "Screen Name" + screenName
	   		+ "Email Address" + emailAddress
	   		+ "Account Created" + dateCreated;
   }
}