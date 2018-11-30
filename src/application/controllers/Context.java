package application.controllers;

import application.classes.Member;
import application.classes.Group;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }
    
    private Member member = new Member(null,null,null,null,null);
    private Group group = new Group(null,null,null);
    
    public void setCurrentMember(Member member) {
        this.member = member;
    }
    
    public Member currentMember() {
        return member;
    }
    
    public void createGroup(Group group) {
        this.group = group;
    }
    
    public Group newGroup() {
        return group;
    }
    
}