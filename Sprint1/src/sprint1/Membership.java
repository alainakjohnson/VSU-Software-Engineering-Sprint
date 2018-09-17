package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Membership{
   
   private LocalDateTime dateJoined;
   private int points;
   
   private static List<Group> groupList = new ArrayList<Group>();
   private List<Member> memberList;
   
  
   public static void storeGroup(Group group) {
	   
	   groupList.add(group);
   }
   
   public void storeMember(Member member) {
	   
	   memberList.add(member);
   }
   
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
