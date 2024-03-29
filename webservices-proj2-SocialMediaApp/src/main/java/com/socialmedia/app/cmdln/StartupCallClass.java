package com.socialmedia.app.cmdln;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.socialmedia.app.dtos.PostComments;
import com.socialmedia.app.dtos.Posts;
import com.socialmedia.app.dtos.Users;
import com.socialmedia.app.repo.SocialMediaUsersRepo;
import com.socialmedia.app.repo.Social_Media_Post_Comments_Repo;
import com.socialmedia.app.repo.Social_media_Posts_Repo;

@Component
public class StartupCallClass implements CommandLineRunner{

	@Autowired
	SocialMediaUsersRepo urepo;
	
	@Autowired
	Social_media_Posts_Repo prepo;
	
	@Autowired
	Social_Media_Post_Comments_Repo crepo;
	
	public static void justprint(int x)
	{
		System.out.println(x);
	}
	
	Scanner sc=new Scanner(System.in);
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside run");
		Users u1=new Users();
		u1.setUname("shiva");
		u1.setUemailid("shiva.gmail.com");
		u1.setUpass("shiva123");
		u1.setUstatus("active");
		
		u1=urepo.save(u1);
		
		Posts p1=new Posts();
		p1.setPostdesc("playing cricket");
		p1.setPostlikescnt(53);
		p1.setUser(u1);
		p1=prepo.save(p1);
		
		
		PostComments pc1=new PostComments();
		pc1.setPostcmnt("Cool!!!");
		pc1.setIspostactive(true);
		pc1.setPosteddate(new Date());
		pc1.setPost(p1);
		crepo.save(pc1);
        
		PostComments pc2=new PostComments();
		pc2.setPostcmnt("You guys are having fun!!!");
		pc2.setIspostactive(true);
		pc2.setPosteddate(new Date());
		pc2.setPost(p1);
		crepo.save(pc2);
		
		Users u=urepo.findByUnameAndUemailid("dpl", "dpl@gmail.com");
		System.out.println(u.toString());
		
		System.out.println("-------1");
		
//		Posts p=prepo.findByConditon(u.getUname(),"playing cricket");
//		System.out.println(p.toString());
//	   p.getPostcmnts().forEach(System.out::println);
	   
		/*
		 * System.out.println("-----2");
		 * System.out.println("Enter the email id: to view ur posts and comments");
		 * String emailid=sc.next(); System.out.
		 * println("Enter the search key for the commments u want to search with:");
		 * String cmnt=sc.next();
		 * 
		 * PostComments pscmnt=crepo.findByEmailandUserCondition(emailid,cmnt);
		 * System.out.println(pscmnt);
		 */
	   
	   
	   
		System.out.println("end of run");
		
		
		
		List<Integer> lst=Arrays.asList(13,27,2,11,5,1,4,19,16);
		
		// iterate using enhanced for loop
//		for(int x: lst)
//		{
//			System.out.println(x);
//		}
		
		// streams is used to convert the collection to stream of no's
		
		lst.stream().filter(t-> t%2==0).forEach(StartupCallClass::justprint);
		
		List<String> lststr=Arrays.asList("shiva","sai","roopesh","varu");
		
		lststr.stream().forEach(x->System.out.println(x+" :: "+x.length()));
		
		
		
		
	String	queryToExecute = "SELECT M.MIPF_BEZ,M.KUNDENNUMMER,COUNT(*) "
				+ "FROM AUFGABE A INNER JOIN MAV_VORGANG M ON A.ID=M.FK_AUFGABE "
				+ "WHERE A.STATUS='OFFEN' "
				+ "AND A.TYP='MAV_ZfA'";
		String groupByClause = " GROUP BY M.MIPF_BEZ, M.KUNDENNUMMER ";
		
		
		
		System.out.println(queryToExecute+groupByClause);
		
//		List<Posts> plst=Arrays.asList(p1);
//		u1.setPosts(plst);
//		u1=urepo.save(u1);
//		urepo.save(u1);
//		p1.setUser(u1);
//		p1=prepo.save(p1);
//		PostComments c1=new PostComments("You guys are awesome!!!Having Fun..", true, new Date());
//        crepo.save(c1);
//        List<PostComments> pclst=Arrays.asList(c1);
//        p1.setPostcmnts(pclst);
//        prepo.save(p1);
//        List<Posts> plst=Arrays.asList(p1);
//        u1.setPosts(plst);
//        urepo.save(u1);
		
		//		List<Posts> lst=new ArrayList<Posts>();
//		lst.add(p1);
//		u1.setPosts(lst);
//		urepo.save(u1);
//		System.out.println(urepo.count());
	}

}
