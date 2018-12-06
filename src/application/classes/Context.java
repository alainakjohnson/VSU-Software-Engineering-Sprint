package application.classes;

import java.time.LocalDateTime;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }
    
    //presentation values
    private Member member = new Member("admin", "admin", "admin", "admin", LocalDateTime.now());
    
//    private Member member = new Member(null,null,null,null,null);
    private Group group = new Group(null,null,null);
    private SiteManager siteManager = new SiteManager();
    
    public void SiteManager(SiteManager siteManager) {
    	this.siteManager = siteManager;
    }
    
    public SiteManager getSiteManager() {
        return siteManager;
    }
    
    // CURRENT INSTANCE MEMBER MANAGER
    
    public void setCurrentMember(String firstname, String lastname, String screenname, String email, LocalDateTime dateCreated){
    	siteManager.addMember(firstname, lastname, screenname, email, LocalDateTime.now());
    }
    
    public Member activeMember(String email) { // this is the member whose information we're looking at
    	this.member = siteManager.getMember(email);
        return member;
    }
    
    
    public Member currentMember(String email) { // this is the member who is logged in
    	this.member = siteManager.getMember(email);
        return member;
    }
    
    public Member currentMember() {
    	return member;
    }
    
    //CURRENT INSTANCE GROUP MANAGER
 
    public void setNewGroup(String title, String description, LocalDateTime dateCreated) {
        siteManager.addGroup(title, description, dateCreated);
    }
    
    public Group activeGroup(String title) { // this is the group whose information we're looking at
    	this.group = siteManager.getGroup(title);
        return group;
    }
   
    public Group getGroup(String title) { // this is the group we most recently created
    	this.group = siteManager.getGroup(title);
        return group;
    }
    
    public Group getGroup() {
    	return group;
    }
    
}