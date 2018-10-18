package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	// HELPER METHODS
	//helper method comparator for sorting Groups
	Comparator<Group> groupComparator = new Comparator<Group>() {
		public int compare(Group a, Group b) {
			return a.getTitle().compareToIgnoreCase(b.getTitle());
			}};
	//
	//helper method comparator for sorting Posts by date
	Comparator<Post> sortByDate = new Comparator<Post>() {
		public int compare(Post a, Post b) {
			LocalDateTime Post1 = a.getDate();
			LocalDateTime Post2 = b.getDate();

			return Post1.compareTo(Post2);
			}};
	//


	// joins member to group and records time joined
	public void joinGroup(Group group, LocalDateTime dateJoined){
		dateJoined = LocalDateTime.now();
		Membership membership = new Membership(this, group, dateJoined);
		memberships.add(membership);
		group.addMembership(membership);
	}

	//returns the number of groups this member is a member of.
	public int getNumGroups(){
		return memberships.size();
	}

	//returns the group that corresponds to the groupid *under the assumption groupID = title.
    public Group getGroup(String groupID){
    	Group group = null;
		for(Membership m : memberships) {
			if(m.getGroup().getTitle().equals(groupID)) {
				group = m.getGroup();
			}
		}
		return group;
    }

   //returns a list of all groups the member is a member of.
    // SORT LIST ON TITLE
   public List<Group> getGroups(){
	   List<Group> tempGroupList = new ArrayList<Group>();
	   		for(Membership m : memberships) {
	   			tempGroupList.add(m.getGroup());
	   			}

	   Collections.sort(tempGroupList, groupComparator);
	   return tempGroupList;
   }

//   adds the question to the group by this member
//   records date asked
   public void addQuestion(Group group, Question question, LocalDateTime date){
	  for(Membership m : memberships)
		  if(m.getGroup().equals(group)){
			question.setMembership(m);
			m.getQuestions().add(question);
		  }
   }

   public LocalDateTime getDateJoined(Group group){
	   LocalDateTime date = null;
	   for(Membership m : memberships)
			  if(m.getGroup().equals(group)){
				  date = m.getDateJoined();
			  }
	   return date;
  }

   //adds this member answer to the question, which is in this group.
   //records date answered.
   public void addAnswer(Group group, Question question, Answer answer, LocalDateTime date){
	   question.addAnswer(answer);
	   for(Membership m : memberships)
			  if(m.getGroup().equals(group)){
				  answer.setMembership(m);
				  m.getAnswers().add(answer);
			  }
   }

   //returns all questions asked by this member in this group
   // SORT ON DATE MOST RECENT TO LEAST
   public List<Question> getQuestions(Group group){
	   List<Question> memberQuestions = new ArrayList<Question>();
	   for(Membership m : memberships){
		   if(m.getGroup().equals(group)){
			   memberQuestions.addAll(m.getQuestions());
		   }
	   }
	   Collections.sort(memberQuestions, sortByDate);
	   Collections.reverse(memberQuestions);
	   return memberQuestions;

   }

   //returns all answers answered by this member in this group
// SORT ON DATE MOST RECENT TO LEAST
   public List<Answer> getAnswers(Group group){
	   List<Answer> memberAnswers = new ArrayList<Answer>();
	   for (Membership m : memberships){
		   if(m.getGroup().equals(group)){
			   memberAnswers.addAll(m.getAnswers());
		   }
	   }

	   Collections.sort(memberAnswers, sortByDate);
	   Collections.reverse(memberAnswers);
		return memberAnswers;

   }

   public String toString(){
	    return "\nScreen Name: " + screenName
	    		+ "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName
				+ "\nEmail Address: " + emailAddress
				+ "\nAccount Created: " + dateCreated;
   }

}
