package application.controllers;

import application.classes.Member;
import application.classes.Group;
import application.classes.SiteManager;

import java.time.LocalDateTime;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }
    
    private Member member = new Member(null,null,null,null,null);
    private Group group = new Group(null,null,null);
    private SiteManager siteManager = new SiteManager();
    
    public void SiteManager(SiteManager siteManager) {
    	this.siteManager = siteManager;
    }
    
    public SiteManager getSiteManager() {
        return siteManager;
    }
    
    // making and adding new member
    
    public void setCurrentMember(String firstname, String lastname, String screenname, String email, LocalDateTime dateCreated){
    	siteManager.addMember(firstname, lastname, screenname, email, LocalDateTime.now());
    }
    
    public Member currentMember(String email) {
    	this.member = siteManager.getMember(email);
        return member;
    }
    
    public Member currentMember() {
    	return member;
    }
    
    // making and adding new group
    
    public void setNewGroup(String title, String description, LocalDateTime dateCreated) {
        siteManager.addGroup(title, description, dateCreated);
    }
   
    public Group getGroup(String title) {
    	this.group = siteManager.getGroup(title);
        return group;
    }
    
    public Group getGroup() {
    	return group;
    }
    
}