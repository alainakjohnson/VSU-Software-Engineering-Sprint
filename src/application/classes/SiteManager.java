package application.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDateTime;
import java.io.Serializable;

public class SiteManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Member> members = new ArrayList<Member>();
	private List<Group> groups = new ArrayList<Group>();
	
	public SiteManager() {
		
	}
	
	public boolean addMember(String firstName, String lastName, String screenName, String emailAddress, LocalDateTime dateCreated) {
		Member temp = new Member(firstName, lastName, screenName, emailAddress, dateCreated);	
		for(Member m : members) {
			if(m.getEmailAddress().equals(emailAddress))
				return false;
		}
		members.add(temp);
		return true;	
	}
	
	public Member getMember(String emailAddress) {
		for(Member m : members) {
			if(m.getEmailAddress().equals(emailAddress))
				return m;
		}
		return null;
	}
	
	public List<Member> getMembers() {
		Collections.sort( members, new Comparator<Member>() {
			public int compare(Member m1, Member m2) {
				int res = m1.getLastName().compareToIgnoreCase(m2.getLastName());
				if (res != 0)
					return res;
				return m1.getFirstName().compareToIgnoreCase(m2.getFirstName());
			}				
		});
		return members;
	}
	
	public List<Member> getMembers(String text){
		List<Member> tempList = new ArrayList<Member>();
			for(Member m : members) {
				if(m.getFirstName().contains(text))
					tempList.add(m);
				else if(m.getLastName().contains(text))
					tempList.add(m);
				else if(m.getScreenName().contains(text))
					tempList.add(m);
				else if(m.getEmailAddress().contains(text))
					tempList.add(m);
			}
			Collections.sort( tempList, new Comparator<Member>() {
				public int compare(Member m1, Member m2) {
					int res = m1.getLastName().compareToIgnoreCase(m2.getLastName());
					if (res != 0)
						return res;
					return m1.getFirstName().compareToIgnoreCase(m2.getFirstName());
				}				
			});
		return tempList;
	}
	
	public boolean addGroup(String title, String description, LocalDateTime dateCreated) {
		Group temp = new Group(title, description, dateCreated);
		for(Group g : groups) {
			if(g.getTitle().equals(title))
				return false;	
		}
		groups.add(temp);
		return true;
	}
	
	public Group getGroup(String title) {
		for(Group g : groups) {
			if(g.getTitle().equals(title))
				return g;
		}
		return null;
	}
	
	public List<Group> getGroups() {
		Collections.sort( groups, new Comparator<Group>() {
			public int compare(Group g1, Group g2) {
				return g1.getTitle().compareToIgnoreCase(g2.getTitle());
			}				
		});
		return groups;
	}
	
	public List<Group> getGroups(String text){
		List<Group> tempList = new ArrayList<Group>();
		for(Group g : groups) {
			if(g.getTitle().contains(text))
				tempList.add(g);
			else if(g.getDescription().contains(text))
				tempList.add(g);
		}
		Collections.sort( tempList, new Comparator<Group>() {
			public int compare(Group g1, Group g2) {
				return g1.getTitle().compareToIgnoreCase(g2.getTitle());
			}				
		});
	return tempList;
	}
	
	public List<Group> getPopularGroups(int n) {
		List<Group> popularGroups = new ArrayList<Group>();
		Collections.sort( groups, new Comparator<Group>() {
			public int compare(Group g1, Group g2) {
				return Integer.compare(g1.getNumMembers(),g2.getNumMembers());
			}				
		}.reversed());
		for(int i=0; i<=n; i++) {
			Group temp;
			temp = groups.get(i);
			popularGroups.add(temp);
		}
		return popularGroups;
	}
	
	public List<Group> getActiveGroups(int n) {
		List<Group> activeGroups = new ArrayList<Group>();
		Collections.sort( groups, new Comparator<Group>() {
			public int compare(Group g1, Group g2) {
				return Integer.compare((g1.getQuestions().size()+g1.getAnswers().size()), (g2.getQuestions().size()+g2.getAnswers().size()));
			}				
		}.reversed());
		for(int i=0; i<=n; i++) {
			Group temp;
			temp = groups.get(i);
			activeGroups.add(temp);
		}
		return activeGroups;
	}
	
	public List<Member> getActiveMembers(int n) {
		List<Member> activeMembers = new ArrayList<Member>();
		Collections.sort( members, new Comparator<Member>() {
			public int compare(Member m1, Member m2) {
				int activity1 = 0;
				int activity2 = 0;
				for (Group g1 : groups) {
					activity1 = activity1 + m1.getQuestions(g1).size() + m1.getAnswers(g1).size();
				}
				for (Group g2 : groups) {
					activity2 = activity2 + m2.getQuestions(g2).size() + m2.getAnswers(g2).size();
				}
				return Integer.compare(activity1, activity2);
			}				
		}.reversed());
		for(int i=0; i<=n; i++) {
			Member temp;
			temp = members.get(i);
			activeMembers.add(temp);
		}
		return activeMembers;
	}
}

