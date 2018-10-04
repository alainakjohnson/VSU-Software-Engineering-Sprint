package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member {

	private LocalDateTime dateCreated;
	private String firstName;
	private String lastName;
	private String screenName;
	private String emailAddress;

	private List<Membership> memberships = new ArrayList<Membership>();

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

	// joins member to group and records time joined
	public void joinGroup(Group group, LocalDateTime dateJoined){
		dateJoined = LocalDateTime.now();
		//this needs to be passed in, tho. maybe pulled from membership class
		memberships.add(emailAddress, group, dateJoined);
	}

	//returns the number of groups this member is a member of.
	public int getNumGroups(){
		return memberships.size();
	}

	//returns the group that corresponds to the groupid *under the assumption groupID = title.
    public Group getGroup(String groupID){
    	Group group = null;
		for(int i = 0; i < memberships.size(); i++) {
			if(memberships.get(i).getTitle().equals(groupID)) {
				group = memberships.get(i);
			}
		}
		return group;
    }

   //returns a list of all groups the member is a member of.
   public List<Group> getGroups(){
	   return memberships;
   }

   //adds the question to the group by this member
   //records date asked
//   public void addQuestion(Group group, Question question, LocalDateTime date){
//		group.add(this.Question);
//		date = LocalDateTime;
//   }

//   public LocalDateTime getDateJoined(Group group){
//	   return dateJoined;
//	   //need to probably create a helper method to grab "dateJoined" from memberships
//   }

//   //adds this member answer to the question, which is in this group.
//   //records date answered.
//   public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date){
//		group.add(this.Answer);
//		date = LocalDateTime;
//   }
//
//   //returns all questions asked by this member in this group
//   public List<Question> getQuestions(Group group){
//
//	   return group.getQuestions();
//
//   }
//
//   //returns all answers answered by this member in this group
//   public List<Answer> getAnswer(Group group){
//
//		return group.getAnswers();
//
//   }

   public String toString(){
	    return "\nFirst Name:" + firstName
			+ "\nLast Name:" + lastName
	   		+ "\nScreen Name:" + screenName
	   		+ "\nEmail Address:" + emailAddress
	   		+ "\nAccount Created:" + dateCreated;
   }

}
