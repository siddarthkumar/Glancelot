package com.glancelot.controllers;


import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.glancelot.models.MeetingSchedular;
import com.glancelot.models.User;
import com.glancelot.service.MeetingSchedulService;
import com.glancelot.service.UserService;

import edu.emory.mathcs.backport.java.util.Arrays;


@Controller
public class MeetingSchedulController {

	@Autowired
	MeetingSchedulService meetingSchedulservice;
	@Autowired
	private UserService service;

	@RequestMapping(value = "/schedularMeeting", method = RequestMethod.POST)
	public ModelAndView  schedularMeeting(MeetingSchedular meetingSchedular,@RequestParam(name = "admins" ,required =false )String  admins, HttpSession ession) {
		
		User user = (User)ession.getAttribute("user");
	
		ModelAndView view = new ModelAndView();
		
		
		if(Objects.nonNull(user))
		{
			String senderMailId = HomeController.emailId;
			meetingSchedular.setMeetingSchedularemail(senderMailId);
			int meetingId   =(int) (Math.random()*100000);
		     String id  = String.valueOf(meetingId); 
		     meetingSchedular.setId(meetingId);
		     meetingSchedular.setMeetingStatus("NOT_STARTED");
		     System.out.println("Allowed starter got from frontend :"+ Arrays.asList(admins.split(" ")));
		     meetingSchedular.setAllowedStarters(Arrays.asList(admins.split(" ")));
			meetingSchedulservice.save(meetingSchedular);
			meetingSchedular.setMeetingSchedularemail(senderMailId);
			meetingSchedulservice.sendMails(senderMailId, meetingSchedular);
			
			view.addObject("user", user);
			view.setViewName("glancer.jsp");
			return view;	
		}
		
		else {
			
			view.setViewName("ErrorPage.jsp");
			return view;
		}
		
		
		
	}
	
	@GetMapping("/linkId")
	public ModelAndView generateLink(@RequestParam(name = "meetingId")String smeetingId , HttpSession session) {  
	    ModelAndView mv = new ModelAndView();   
		
		session.setAttribute("meetingId", smeetingId);
		User attendee = (User)session.getAttribute("attendee");
	int meetingId=Integer.parseInt(smeetingId);
		if(Objects.nonNull(attendee))
		{     
             
			MeetingSchedular meeting= meetingSchedulservice.getMeetingSchedularByMeetingId(meetingId);
		
			if((meeting.getAllowedStarters().contains(attendee.getEmail()) || meeting.getMeetingSchedularemail().equalsIgnoreCase(attendee.getEmail())) && StringUtils.equalsIgnoreCase(meeting.getMeetingStatus(),"ENDED")!= true)
			{
				meeting.setMeetingStatus("STARTED");
				meetingSchedulservice.save(meeting);
				mv.addObject("currentuser",attendee);
				mv.addObject("roomname",meeting.getCreateNewRoom());
				mv.setViewName("call.jsp");
			
			}
			else if(!meeting.getAllowedStarters().contains(attendee.getEmail()) && StringUtils.equalsIgnoreCase(meeting.getMeetingStatus(),"NOT_STARTED")== true){
				mv.addObject("currentuser",attendee);
				mv.addObject("message", "Hey !"+attendee.getName() +"  your meeting Hasnt started Yet , Or may be it will start late ");
				mv.setViewName("TestMeeting.jsp");
				
			}
			else if((!meeting.getAllowedStarters().contains(attendee.getEmail()) || meeting.getAllowedStarters().contains(attendee.getEmail())) && StringUtils.equalsIgnoreCase(meeting.getMeetingStatus(),"ENDED")== true)
			{
				mv.addObject("currentuser",attendee);
				mv.addObject("message", "Hey !"+attendee.getName() +"your meeting Has ended for this meetingID");
				mv.setViewName("TestMeeting.jsp");
				
			}else if(meeting.getAllowedStarters().contains(attendee.getEmail()) && StringUtils.equalsIgnoreCase(meeting.getMeetingStatus(),"STARTED")== true )
			{
				mv.addObject("currentuser",attendee);
				mv.addObject("roomname",meeting.getCreateNewRoom());
				mv.setViewName("call.jsp");
				
			}
			else {
				mv.addObject("currentuser",attendee);
				mv.setViewName("ErrorPage.jsp");
			}
			
			return mv;
			
		}else {
			mv.setViewName("redirect:/signin");
            return mv;			
		}
		
		/*
		boolean isPresent = meetingSchedulservice.existsMeetingSchedularByMeetingSchedularemail(meetingSchedular.getMeetingSchedularemail());
		if (meetingSchedular.getMeetingSchedularemail() == null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("TestMeeting.jsp");
			return mv;
		} else if (isPresent) {
			MeetingSchedular meetingSchedular1 = meetingSchedulservice.getMeetingSchedularByMeetingSchedularemail(meetingSchedular.getMeetingSchedularemail());
			User user = service.view(meetingSchedular.getMeetingSchedularemail());
			user.getChatroomstillnow().add(meetingSchedular1.getCreateNewRoom());
			service.update(user);
		ModelAndView mv = new ModelAndView();
			mv.addObject("currentuser",user);
			mv.addObject("roomname",meetingSchedular1.getCreateNewRoom());
			mv.setViewName("call.jsp");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("accessDenied.jsp");
			return mv;
		}*/
	}
}
