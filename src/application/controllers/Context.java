package application.controllers;

import application.classes.Member;

public class Context {
    private final static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }
    
    private Member member = new Member(null,null,null,null,null);
    
    public void setCurrentMember(Member member) {
        this.member = member;
    }
    
    public Member currentMember() {
        return member;
    }
    
}