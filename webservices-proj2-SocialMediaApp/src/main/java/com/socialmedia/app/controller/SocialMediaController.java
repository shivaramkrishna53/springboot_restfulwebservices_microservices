package com.socialmedia.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.socialmedia.app.dto.DemoDto;
import com.socialmedia.app.dtos.FullName;
import com.socialmedia.app.dtos.Person;
import com.socialmedia.app.dtos.PersonSplit;
import com.socialmedia.app.dtos.PostComments;
import com.socialmedia.app.dtos.Posts;
import com.socialmedia.app.dtos.ResultDtoQuerySample;
import com.socialmedia.app.dtos.ResultDtoSample;
import com.socialmedia.app.dtos.Users;
import com.socialmedia.app.exceptionhandler.UserNotFoundException;
import com.socialmedia.app.repo.JpaDemo;
import com.socialmedia.app.repo.PersonRepo;
import com.socialmedia.app.service.SocialMediaService;

@RestController
public class SocialMediaController {
	
	@Autowired
	private PersonRepo repo;
	
	@Autowired
	SocialMediaService ser;
	
	@Autowired
	MessageSource messagesource;
	
	@Autowired
	JpaDemo jpademo;
	
	@PostMapping("/user/save")
	public ResponseEntity<Object> saveUser(@RequestBody @Valid Users user)
	{
		Users saveduser=jpademo.saveUser(user);
		//Users saveduser=ser.saveuser(user);
		//int res=repo.insertAUser(user);
		//    /user/save/{id} 101
//		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getUid()).toUri();
//	    
	return ResponseEntity.status(HttpStatus.OK).body(saveduser);
		//return res>0? ResponseEntity.status(HttpStatus.OK).body(res):ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	@PostMapping("/users/save/bulk")
	public EntityModel<ResponseEntity> saveinbulk(@RequestBody List<Users> lstusers)
	{
		
		
	    List<Users> insertedUsersLst=ser.saveAllInBulk(lstusers);
	    List<Integer> lstuserids=new ArrayList<Integer>();
	    
	    insertedUsersLst.forEach(x->{lstuserids.add(x.getUid());});
	   // Integer[] arr=(Integer[]) lstuserids.toArray();
	    System.out.println(lstuserids);
	    String url[] = new String[lstuserids.size()];
	    for(int i=0;i<lstuserids.size();i++)
	    {
	    url[i]=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lstuserids.get(i)).toUri().toString();
	    System.out.println(url[i]);
	    }
	    
	    ResponseEntity rs=new ResponseEntity(url,HttpStatus.CREATED);
		EntityModel<ResponseEntity> model=EntityModel.of(rs);
	    
	    
	    WebMvcLinkBuilder linkstovarioussavedusers=linkTo(methodOn(this.getClass()).getAllUsersInSocialMedia());
	    model.add(linkstovarioussavedusers.withRel("Links_to_view_all_users"));
	   return model;
	}
	
	@GetMapping("/users")
	public List<Users> getAllUsersInSocialMedia()
	{
	  return ser.getAllUsers();
		
	}
	
	@GetMapping("/finduserbyid/{id}")
	public Users findByUserId(@PathVariable String id) throws Exception
	{
		
		//Users user=ser.findByUserId(Integer.parseInt(id));
		
		//Users user=repo.getAllUsers(Integer.parseInt(id));
		
		Users user=jpademo.findUserById(Integer.parseInt(id));
		
		System.out.println(user);
		if(user!=null)
			return user;
		else
			 throw new UserNotFoundException("not found with the user with id: "+id);
		
		
	
	}
	
	@DeleteMapping("/deleteuser/{userid}")
	public EntityModel<ResponseEntity> deleteResource(@PathVariable(name = "userid") String userid) throws UserNotFoundException
	{
		Users u=ser.deleteResourceById(userid);
		
		if(u==null)
			throw new UserNotFoundException("user with id:"+userid+" dosent exist");
		else
		{
			ResponseEntity re=new ResponseEntity(HttpStatus.OK);
			EntityModel<ResponseEntity> model=EntityModel.of(re);
			WebMvcLinkBuilder linktousers=linkTo(methodOn(this.getClass()).getAllUsersInSocialMedia());
			model.add(linktousers.withRel("link-to-all-users"));
			
			return model;
		}
	}
	
	@GetMapping("/hellowworld-interlized")
	public String getMessageI18n(//@RequestHeader(name = "Accept-Language") Locale locale)
			)
	{
		return messagesource.getMessage("good.morning", null,"default message as the key is not present", LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/downloadcsv/alluserdata")
	public void getcsvfiledownload(HttpServletResponse res) throws Exception
	{
		
		DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentdatetime=dateformat.format(new Date());
		
		res.setHeader("Content-Disposition","attachment;filename=users_"+currentdatetime+".csv");
		res.setContentType("text/csv");
		//Users u=ser.findByUserId(Integer.parseInt(id));
		List<Users> lstusers=ser.getAllUsers();
		ICsvBeanWriter csvwriter=new CsvBeanWriter(res.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvheader= {"userid","username","useremailid","userpass","userstatus","postid","postdesc","postlikescnt","postcmntid","postcmnt"};
		String[] namemapping= {"uid","uname","uemailid","upass","ustatus","postid","postdesc","postlikescnt","postcmntid","postcmnt"};
		
		
//		csvwriter.writeHeader(csvheader);
//		ResultDtoSample sam=new ResultDtoSample();
//		BeanUtils.copyProperties(u,sam);
//		Posts p=u.getPosts().get(0);
//		PostComments pc=p.getPostcmnts().get(0);
//		sam.setPostid(p.getPostid());
//		sam.setPostdesc(p.getPostdesc());
//		sam.setPostlikescnt(p.getPostlikescnt());
//		sam.setPostcmntid(pc.getPostcmntid());
//		sam.setPostcmnt(pc.getPostcmnt());
//		csvwriter.write(sam,namemapping);
		
		csvwriter.writeHeader(csvheader);
		for(Users u:lstusers)
		{
		ResultDtoSample sam=new ResultDtoSample();
		BeanUtils.copyProperties(u,sam);
		List<Posts> lstpsts=u.getPosts();
		List<PostComments> lstpc=null;
		for(Posts p:lstpsts)
		{
		 lstpc=p.getPostcmnts();
		
		for(PostComments pc:lstpc) {
		sam.setPostid(p.getPostid());
		sam.setPostdesc(p.getPostdesc());
		sam.setPostlikescnt(p.getPostlikescnt());
		sam.setPostcmntid(pc.getPostcmntid());
		sam.setPostcmnt(pc.getPostcmnt());
		csvwriter.write(sam,namemapping);
		
		}
		}
		if(lstpsts==null || lstpc==null)
			csvwriter.write(sam,namemapping);
		
		}
		
		csvwriter.close();
	}
	
	@GetMapping("/getallusers/querydata")
	public void getalldatausingquery(HttpServletResponse res) throws IOException
	{
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		String currentdate=df.format(new Date());
		
		List<ResultDtoQuerySample> lst=ser.getalldataquery();
		lst.forEach(System.out::println);
		
		res.setContentType("text/csv");
		res.setHeader("Content-Disposition","attachement;filename=users"+currentdate+".csv");
		String[] headers= {"uid","uname","uemailid","ustatus","postid","postdesc","postlikescnt","postcmntid","postcmnt","posteddate"};
		String[] mappers=  {"uid","uname","uemailid","ustatus","postid","postdesc","postlikescnt","postcmntid","postcmnt","posteddate"};
		ICsvBeanWriter csvwriter=new CsvBeanWriter(res.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		csvwriter.writeHeader(headers);
		for(ResultDtoQuerySample dto:lst)
			csvwriter.write(dto,mappers);
		
			csvwriter.close();
	}
	
	
		
	
	
//	@PostMapping("/users/{uid}/addpost")
//	public ResponseEntity addpost(@PathVariable String uid,@RequestBody Posts)
//	{
//		
//	}
	
	
//	@GetMapping("/user/{username}")
//	public List<Users> findByUser(@PathVariable String username)
//	{
//	  return ser.findUserByName(username);
//	}
	
//	@GetMapping("/user/{username}/{userid}")
//	public List<Users> findByUsernameandUserid(@PathVariable String username,@PathVariable String userid)
//	{
//		ser.findbyuidanduname(username,Integer.parseInt(userid));
//	}
	
	
	@GetMapping("/getlinktoallusers")
	public EntityModel<Users> getTheLinkOfAllUsers()
	{
		Users user=ser.findByUserId(1);
		EntityModel<Users> model=EntityModel.of(user);
		
		WebMvcLinkBuilder linktoallusers=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsersInSocialMedia());
		model.add(linktoallusers.withRel("link_for_all_users_viewing"));
		return model;
		
	}
	
	@GetMapping("/internationalization")
	public String internationalization(//@RequestHeader(name = "Accept-Language",required = false) Locale loc)
	)
	{
		return messagesource.getMessage("sendoff", null, "locale not found", LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/dynamic-filtering-NormalObject")
	public MappingJacksonValue DynamicFiltering()
	{
		DemoDto demo=new DemoDto("fld1", "fld2", "fld3");
		
		MappingJacksonValue mapping=new MappingJacksonValue(demo);
	    SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("somefilter", filter);
	    
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/dynamic-filtering-ArrayList")
	public MappingJacksonValue DynamicFilteringForArrayList()
	{
		DemoDto dto1=new DemoDto("a", "b", "c");
		DemoDto dto2=new DemoDto("d", "e", "f");
		List<DemoDto> lst=Arrays.asList(dto1,dto2);
		MappingJacksonValue mappingjacksonval=new MappingJacksonValue(lst);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("somefilter", filter);
		mappingjacksonval.setFilters(filters);
		return mappingjacksonval;
	}
	
	//versioning
	
	@GetMapping("/getperson/v1")
	public Person getPersonBasedOnVersion1UsingUri()
	{
		return new Person("shiva ram krishna durgi");
	}
	
	@GetMapping("/getperson/v2")
	public List<PersonSplit> getPersonBasedOnVersion2UsingUri()
	{
		return Arrays.asList(new PersonSplit(new FullName("Sai", "Ram Krishna", "Durgi")),new PersonSplit(new FullName("Shiva", "Ram Krishna", "Durgi")));
	}
	
	
	@GetMapping(path = "/getperson",params = "version=1")
	public Person getPersonBasedOnVersion1UsingRequestParam()
	{
		return new Person("shiva ram krishna durgi");
	}
	
	@GetMapping(path="/getperson",params = "version=2")
	public PersonSplit getPersonBasedOnVersion2UsingRequestParams()
	{
		return new PersonSplit(new FullName("Shiva", "Ram Krishna", "Durgi"));
	}
	
	
	@GetMapping(path="/getperson",headers ="version=1")
	public Person getPersonBasedOnVersion1UsingHeaders()
	{
		return new Person("shiva ram krishna durgi");
	}
	
	@GetMapping(path="/getperson",headers = "version=2")
	public PersonSplit getPersonBasedOnVersion2UsingHeaders()
	{
		return new PersonSplit(new FullName("Shiva", "Ram Krishna", "Durgi"));
	}
	
	@GetMapping(path="/getperson",produces = "application/vnd.api+v1+json")
	public Person getPersonBasedOnVersion1UsingAcceptHeaderV1()
	{
		return new Person("shiva ram krishna durgi");
	}
	
	@GetMapping(path = "/getperson", produces = "application/vnd.api+v2+json")
	public PersonSplit getPersonBasedOnVersion2UsingAcceptHeaderV2()
	{
		return new PersonSplit(new FullName("Shiva", "Ram Krishna", "Durgi"));
	}
	
	@GetMapping(path = "/getpersonusinghateos")
	public EntityModel<PersonSplit> getLinkForFullNameOfAPersonUsingHateosConcept()
	{
		//Here we use the EntityModel class in which we can store the bean along with the link.
		EntityModel<PersonSplit> entitymodel=EntityModel.of(new PersonSplit(new FullName("Shiva", "Ram Krishna", "Durgi")));
		//in order to provide the link for a method of the mvc controller method we can use the webmvclinkbuilder class
		WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getPersonBasedOnVersion1UsingUri());
		entitymodel.add(link.withRel("Link to version1 of person"));
		return entitymodel;
		
	}
	
	@GetMapping("/getpersondetailsdynamicfilteringforremovingmiddlename")
	public MappingJacksonValue getpersondetailsusingdynamicfiltering()
	{
		PersonSplit person=new PersonSplit(new FullName("shiva","ramkrishna","durgi"));
	    MappingJacksonValue mapper=new MappingJacksonValue(person);
	    SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("firstname","lastname");
		FilterProvider filters=new SimpleFilterProvider().addFilter("simplefilter",filter);
		mapper.setFilters(filters);
		return mapper;
	}
	
	@GetMapping("/getpersondetailsdynamicfilteringforremovinglastname")
	public MappingJacksonValue getpersondetailsusingdynamicfiltering2()
	{
		PersonSplit person=new PersonSplit(new FullName("shiva","ram krishna","durgi"));
		MappingJacksonValue mapper=new MappingJacksonValue(person);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("firstname","middlename");
		FilterProvider filters=new SimpleFilterProvider().addFilter("simplefilter",filter);
		mapper.setFilters(filters);
		return mapper;
	}
	
	
	

}
