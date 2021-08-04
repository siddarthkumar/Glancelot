package com.glancelot.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glancelot.models.LoginForm;
import com.glancelot.models.MeetingSchedular;
import com.glancelot.models.User;
import com.glancelot.service.MeetingSchedulService;
import com.glancelot.service.UserService;

@Controller
public class HomeController {

	static int otps=0;
	public static String emailId; 
	@Autowired
	private UserService service;
	
	@Autowired
	MeetingSchedulService meetingSchedulservice;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("inside home hontroller");
		return "index.jsp";
	}
	
	@GetMapping("/signin")
	public String loginPage()
	{
		System.out.println("inside Login");
		
		return "signins.jsp";
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard(HttpSession session)
	{    
		ModelAndView mv = new ModelAndView();
	    User user = (User)session.getAttribute("user");
	    if(Objects.isNull(user))
	    {
	    	mv.setViewName("ErrorPage.jsp");
			return mv;
	    }
	    else {
		
		mv.setViewName("glancer.jsp");
		mv.addObject("user", user);
		return mv;
	    }
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		String meetingId= (String)session.getAttribute("meetingId");
		if(StringUtils.isNotBlank(meetingId))
		{
		
			MeetingSchedular meeting =  meetingSchedulservice.getMeetingSchedularByMeetingId(new Integer(meetingId));
			if(meeting.getMeetingStatus().equalsIgnoreCase("NOT_STARTED")!=true) {
			meeting.setMeetingStatus("ENDED");
			meetingSchedulservice.save(meeting);
			}
		}
		session.invalidate();
		System.out.println("user is logged out");
		return "signins.jsp";
	}

	@PostMapping("/dostuff")
	public ModelAndView qualify(@ModelAttribute LoginForm form, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		String meetingId= (String)session.getAttribute("meetingId");
		
		
		emailId = form.getEmail();
		String password= form.getPassword();
		System.out.println("Inside Signed in");
		
		User logger = service.view(emailId);
		
		if(Objects.nonNull(logger))
		{
			if(logger.getPassword().equalsIgnoreCase(password)){
			  	  
				System.out.println("Login successfull!");
				
				if(StringUtils.isNotBlank(meetingId))
				{
					session.setAttribute("attendee", logger);
				 mv.setViewName("redirect:/linkId?meetingId="+meetingId);
				 return mv;
				}
				
			  	  mv.addObject("user", logger);
			  	  mv.setViewName("glancer.jsp");
			  	  session.setAttribute("user", logger);
			  	 return mv;
			     }
			     else {
			  	  System.out.println("Invalid Credentials");
			  	  mv.setViewName("ErrorPage.jsp");
			  	  return mv;
			     }
			
		}
		else {
			System.out.println("User not available");
			mv.setViewName("ErrorPage.jsp");
			return mv;
		}
		
	}
	
	
	
	@RequestMapping("/registered")
	public ModelAndView addUser(User user , @RequestParam("phone") String s )
	{   
		user.setMobile(s);
		if(service.save(user)==1) {
		System.out.println("Registration successfull");}
		else{
			System.out.println("Registration unsuccessfull");
			
		}
		ModelAndView mv = new ModelAndView();
	mv.addObject("userobject",user);
	mv.setViewName("signins.jsp");
	System.out.println("User name is"+ user.getName()+"  User email is "+user.getEmail());
			
		return mv;
	}
	
	
	@GetMapping("/call")
	public ModelAndView call(@RequestParam("roomname") String s ,HttpSession session)
	{     
	User currenttuser=	(User)session.getAttribute("user");
	
	ModelAndView mv = new ModelAndView();
	
	if(Objects.nonNull(currenttuser))
	{
		
	try {
		List<String> roomList =  currenttuser.getChatroomstillnow();  
		roomList.add(s);
		currenttuser.setChatroomstillnow(roomList);
		service.update(currenttuser);
		}
		catch(Exception e)
		{
			System.err.println("Error while updating rooms List"+ e.getMessage());
		}
		
		mv.addObject("currentuser",currenttuser);
		mv.addObject("roomname",s);
		mv.setViewName("call.jsp");
		return mv;
	}
	
	else{
		mv.setViewName("redirect:/signins.jsp");
		return mv;
	}
	
	}
	
	@RequestMapping("/sendsms")
	public ModelAndView sms(@RequestParam("mobile") String s ,HttpSession session)
	{     
             String otp=generatorOTP(5)+"";
             System.out.println("garbage is "+otp);
            int a= Integer.parseInt(otp);
            otps=a;
            
		sendSms("Dear Customer your OTP for phone validation at Glancelot is "+otps ,"TXTLCL",s,"qdHHbTS+kcM-H2pbTzHX2ruBjvvVe1HjPfDSWI83TJ");//9682885936
		ModelAndView mv = new ModelAndView();
		//mv.addObject("",currenttuser);
		//mv.addObject("roomname",s);
		mv.setViewName("loggedup.html");
		return mv;
	}
	
	
	public static String sendSms(String message_param , String sender_param , String number_param ,String apiKeyParam ) {
		try {
			// Construct data
			String apiKey = "apikey=" + apiKeyParam;

			String message = "&message=" + message_param +"\n"+getCurrentTime();
			String sender = "&sender=" + sender_param;
			String numbers = "&numbers=" + number_param;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + sender + message ;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
				
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}

	}

	
	


public static String getCurrentTime()
{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date d1 = new Date();
	String date = dateFormat.format(d1);
//	System.out.println(date); //2016/11/16 12:08:43
	return date;
}


public static String generatorOTP(int length) 
{ 
	 int randomPin   =(int) (Math.random()*100000);
     String otp  = String.valueOf(randomPin); 
      //returning value of otp 

  return otp; 
} 

@RequestMapping("/verifyotp")
@ResponseBody
public String checkOtp(@RequestParam("enteredOtp") String otp)
{
	System.out.println("Otp recieved from user is "+otp);
	
	if(Integer.parseInt(otp)==otps) {return "verified";}
	else {
return "not_verified";
	}
}
	


@RequestMapping("/loginwithotp")
public ModelAndView addUser (@RequestParam("phone") String s )
{   
	User logger = service.viewByMobile(s);
	String view;
	if(logger!=null) {
	System.out.println("Login successfull");
	view="glancer.jsp";
	}
	else{
		System.out.println("Login unsuccessfull");
		view="signins.jsp";
		
	}
	ModelAndView mv = new ModelAndView();
mv.addObject("userobject",logger);
mv.setViewName(view);
System.out.println("User name is"+ logger.getName()+"  User email is "+logger.getEmail());
		
	return mv;
}


}
