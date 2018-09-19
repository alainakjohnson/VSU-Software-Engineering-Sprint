package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Membership{
   
   private LocalDateTime dateJoined;
   private int points;
   
  
   
   private static List<Group> groupList = new ArrayList<Group>();
   private static List<Member> unassignedMembers;
  // private static List<ArrayList<Member>> memberList = new ArrayList<ArrayList<Member>>(10);
   
  
   public Membership(Group group){
	   final ArrayList<Member> memberList = new ArrayList<Member>();
	   LocalDateTime dateJoined;
	   //storeGroup(group);  
	   
   }
   
   public static void joinAsMember(Group group) {
	   
	   
   }
   public static void storeGroup(Group group) {
	   
	   //groupList.add(group);
	   
   }
   
//   //correlates with joinGroup method in member
//   public static void storeMember(Group group, Member member) {
//	   
//	   for(int i = 0; i < groupList.size(); i++) {
//		    
//		  if(memberList.size() == 0) {
//			  tempMemberList.add(member);
//			  memberList.get(0).add((Member) tempMemberList);
//			  
//		  }
//		  else if(group.getTitle().equals(groupList.get(i).getTitle())){
//			  
//			  memberList.get(i).add(member);
//		  } 
//			   
//			   
//		   
//		   //memberList.add().add(member);
//	   }
//   }
   
//   public static List<Group> getNumG() {
//	   
//	   return groupList;
//   }
   
//   public void addToGroup(Group group, Member member) {
//	   
//	   for(int i = 0; i < groupList.size(); i++) {
//		   
//		   if(groupList.get(i).equals(group)) {
//			   
//			   
//		   }
//	   }
//	   
//   }
   
//   public List<Member> giveMemberList(){
//	   
//	   
//   }
   
   public static void displayGroupList(){
	   System.out.println("============Group List================");
	   for(int i = 0; i<groupList.size(); i++) {
		   System.out.println(groupList.get(i));
	   }
	   System.out.println("=======================================");
   }
   public String toString(){

	   return "1";
   }



}
