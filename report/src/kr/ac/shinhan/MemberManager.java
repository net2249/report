package kr.ac.shinhan;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;



public class MemberManager {

	public static TeamMember addTeamMember(String name, String id, String tel,
			String mail, String katok, String cip, String gitid) {
		// TODO Auto-generated method stub
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember m = new TeamMember(name,id,tel,mail,katok,cip,gitid);
		pm.makePersistent(m);
		return m;
	}

	
	public static TeamMember getMember(String key) 
		{ 
	 		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager(); 
	 		TeamMember m = pm.getObjectById(TeamMember.class,key); 
	 		 
			return m; 
	 	} 
	
	public static void updateMember(TeamMember newMember)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		TeamMember memberObject = MemberManager.getMember(newMember.getid()+"");
		memberObject.setName(newMember.getName());
		memberObject.setid(newMember.getid());
		memberObject.settel(newMember.gettel());
		memberObject.setmail(newMember.getmail());
		memberObject.setkatok(newMember.getkatok());
		memberObject.setcip(newMember.getcip());
		memberObject.setgitid(newMember.getgitid());
		
		pm.close();
		
	}
	
	public static void deleteMember(String key) 
	 	{ 
	 		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager(); 
	 		TeamMember m = MemberManager.getMember(key); 
	 		
	 		pm.deletePersistent(pm.getObjectById(TeamMember.class, key)); 

			
	 	} 
	
	public static List<TeamMember> getMemberByName(String name) 
	 	{ 
	 		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager(); 
	 		Query qry = pm.newQuery(TeamMember.class); 
	 		qry.setFilter("name == nameParam"); 
			qry.declareParameters("String nameParam"); 
 		 
			List<TeamMember> memberList = (List<TeamMember>) qry.execute(name); 
			 
			return memberList; 
		} 
	public static List<TeamMember> getAllMembers() 
	 	{ 
	 		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager(); 
	 		Query qry = pm.newQuery(TeamMember.class); 
	 		List<TeamMember> memberList = (List<TeamMember>) qry.execute(); 
	 
	 
	 		return memberList; 
	 	} 




}
