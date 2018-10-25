package sprint2;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class SiteManager {
	private List<Membership> members = new ArrayList<Membership>();
	private List<Membership> groups = new ArrayList<Membership>();
	
	public SiteManager() {
		
	}
	
	public boolean addMember(String firstName, String lastName, String screenName, String emailAddress, LocalDateTime dateCreated) {
		
	}
	
	public Member getMember(String emailAddress) {
		
	}
	
	public List<Member> getMembers() {
		
	}
	
	public List<Member> getMembers(String text){
		
	}
	
	public boolean addGroup(String title, String description, LocalDateTime datecreated) {
		
	}
}

