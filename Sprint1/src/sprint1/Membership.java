package sprint1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Membership{
   
   //dateJoined not yet implemented for joinGroup
   //private LocalDateTime dateJoined;
   private int points;
   
  
   
   private static List<Group> groupList = new ArrayList<Group>();
   
   public Membership() {
	   
	   
   }
   
   public static void storeGroup(Group group) {
	   
	   groupList.add(group);
	   
   }
   
   public static Group retrieveGroup(String groupID) {
	   
	   Group group = new Group("Null", "Null", LocalDateTime.now());
	   for(int i = 0; i< groupList.size(); i++) {
		   
		   if(groupList.get(i).getTitle().equals(groupID)) {
			   
			   group = groupList.get(i);
			   
			  
		   }
		   
	   }
	   return group;
   }
   
   public static void displayGroupList(){
	   System.out.println("============Group List================");
	   for(int i = 0; i<groupList.size(); i++) {
		   System.out.println(groupList.get(i));
	   }
	   System.out.println("=======================================");
   }
   
   public int totalNumGroups() {
	   int numGroup = 0;
	   for(int i = 0; i < groupList.size(); i++) {
		   if(groupList.get(i) != null) {
			   
			   numGroup++;
		   }
		   
	   }
	   return numGroup;  
   }
   
//   public String toString(){
//
//	   return "Number of Groups: " + totalNumGroups()
//			  + "\n" + displayGroupList();
//   }



}
