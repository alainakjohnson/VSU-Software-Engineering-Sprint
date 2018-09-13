import java.util.*;

public class Member {

	LocalDateTime dateCreated;
	String firstName;
	String lastName;
	String screenName;
	String emailAddress;

   public Member(String firstName, String lastName, String screenName, String emailAddress, LocalDateTime dateCreated){
   
      this.firstName = firstName;
      this.lastName = lastName;
      this.screenName = screenName;
      this.emailAddress = emailAddress;
      this.dateCreated = dateCreated;
   }

	public String getEmailAddress(){
		return emailAddress;
	}

	public LocalDateTime getDateCreated(){
		return dateCreated;
	}

	public String getFirstName(){
		return firstName;

	}
	public String getLastName(){
		return lastName;
	}

	public String getScreenName(){
		return screenName;
	}

	public void joinGroup(Group group, LocalDateTime dateJoined){
		List<Group> groups = new List;
		List<Members> members = new list;
		groups.add(this.Group);
		members.add(this.Member);
		
	}

	public int getNumGroups(){
		
	}

    public Group getGroup(String groupID){
    	
    }
   
    public List<Group> getGroups(){
    	groups = this.List<Group>;
    	return groups;
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