package sprint2;

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
	protected int points;

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

	//// HELPER METHODS ////
	
	// comparator for sorting Groups
	Comparator<Group> sortByTitle = new Comparator<Group>() {
		public int compare(Group a, Group b) {
			return a.getTitle().compareToIgnoreCase(b.getTitle());
			}};
	//
			
	// comparator for sorting Posts by date
	Comparator<Post> sortByDate = new Comparator<Post>() {
		public int compare(Post a, Post b) {
			LocalDateTime Post1 = a.getDate();
			LocalDateTime Post2 = b.getDate();

			return Post2.compareTo(Post1);
			}};
	//
			
	// comparator for sorting activity IN GROUP
	Comparator<Group> sortByActive = new Comparator<Group>() {
		public int compare(Group a, Group b) {
			int Group1 = getQuestions(a).size()+getAnswers(a).size();
			int Group2 = getQuestions(b).size()+getAnswers(b).size();

			return Group2 - Group1;
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

	   Collections.sort(tempGroupList, sortByTitle);
	   return tempGroupList;
   }

   //returns user's n most active groups, sorted on title
   public List<Group> getGroups(int n){
	   List<Group> mostActiveGroups = new ArrayList<Group>();
	   mostActiveGroups = getGroups();
	   Collections.sort(mostActiveGroups, sortByActive);
	   if(n >= mostActiveGroups.size()){
		   Collections.sort(mostActiveGroups, sortByTitle);
		   return mostActiveGroups;
		   }
	   mostActiveGroups = mostActiveGroups.subList(0, n);
	   Collections.sort(mostActiveGroups, sortByTitle);
	   return mostActiveGroups;
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
	   return memberQuestions;
   }

   //get the n most recent answers from above
   public List<Question> getQuestions(Group group, int n){
	   List<Question> recentQuestions = new ArrayList<Question>();
	   if(n >= getQuestions(group).size()){
		   return getQuestions(group);
		   }
	   recentQuestions = getQuestions(group).subList(0, n);
	   return recentQuestions;
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
	   return memberAnswers;
   }

   //get the n most recent answers from above
   public List<Answer> getAnswers(Group group, int n){
	   List<Answer> recentAnswers = new ArrayList<Answer>();
	   if(n >= getAnswers(group).size()){
		   return getAnswers(group);
		   }
	   recentAnswers = getAnswers(group).subList(0, n);
	   return recentAnswers;
   }
   
	//// Added for Requirement 6 ////

   //gets member's total points
	int getPoints(){
		for (Membership m : memberships) {
			if(m.getMember() == this) {
				this.points = m.getPoints();
			}
		}
		return points;
	}
	
	void setPoints(int newPoints){
		for (Membership m : memberships) {
			if(m.getMember() == this) {
				m.setPoints(newPoints);
			}
		}
		this.points += newPoints;
	}
 	
 	void setVote(int vote, Post p){
 		p.setPoints(vote);
 	}

 	
    //adds a comment
    public void addComment(Group group, Question question, Comment comment, LocalDateTime date){
 	   question.addComment(comment);
 	   for(Membership m : memberships)
 			  if(m.getGroup().equals(group)){
 				  comment.setMembership(m);
 				  m.getComments().add(comment);
 			  }
    }
 	
 	////
 	
   public String toString(){
	    return "\nScreen Name: " + screenName
	    		+ "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName
				+ "\nEmail Address: " + emailAddress
				+ "\nAccount Created: " + dateCreated;
   }

}
