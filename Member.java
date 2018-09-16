package sprint1;

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

	// joins member to group and records time.
	public void joinGroup(Group group, LocalDateTime dateJoined){		
		group.add(this.Member)
		dateJoined = LocalDateTime
	}

	//returns the number of groups this member is a member of.
	public int getNumGroups(){
		return this.getGroups().size;
	}

	//returns the group that corresponds to the groupid.
    public Group getGroup(String groupID){
		for each id of groupID{
			String title = getGroups().get(i).title;
			if(title == groupID)
				return title;
    }
   
   //returns a list of all groups the member is a member of.
   public List<Group> getGroups(){
		groups.add();
    	return groups;
   }
   
   //adds the question to the group by this member
   //records date asked
   public void addQuestion(Group group, Question question, LocalDateTime date){ 
		group.add(this.Question);
		date = LocalDateTime;
   }
   
   public LocalDateTime getDateJoined(Group group){
		return joinGroup.dateJoined;
   }
   
   //adds this member's answer to the question, which is in this group.
   //records date answered.
   public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date){
		group.add(this.Answer);
		date = LocalDateTime;
   }
   
   //returns all questions asked by this member in this group
   public List<Question> getQuestions(Group group){
		return group.Questions; // need to specify by member
   }
   
   //returns all answers answered by this member in this group
   public List<Answer> getAnswer(Group group){   
		return group.Answers; // need to specify by member
   }
  
   public String toString(){
	    return "First Name" + firstName
			+ "Last Name" + lastName
	   		+ "Screen Name" + screenName
	   		+ "Email Address" + emailAddress
	   		+ "Account Created" + dateCreated;
   }
}