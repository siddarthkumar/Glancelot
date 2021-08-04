package com.glancelot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meetingSchedular")
public class MeetingSchedular {
	@Id
	private int id;
	private String createNewRoom;
	private String setDate;
	private String setTime;
	private String mailPassword;
	private String addMails;
	private String meetingStatus;
	private String meetingSchedularemail;
	@Column(nullable=true)
	@ElementCollection(fetch = FetchType.EAGER)
	List<String> allowedStarters;
	
	
	public MeetingSchedular(int id, String createNewRoom, String setDate, String setTime, String mailPassword,
			String addMails,String meetingStatus, String meetingSchedularemail, List<String> allowedStarters) {
		super();
		this.id = id;
		this.createNewRoom = createNewRoom;
		this.setDate = setDate;
		this.setTime = setTime;
		this.mailPassword = mailPassword;
		this.addMails = addMails;
		this.meetingStatus=meetingStatus;
		this.meetingSchedularemail = meetingSchedularemail;
		this.allowedStarters = allowedStarters;
	}


	public MeetingSchedular() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCreateNewRoom() {
		return createNewRoom;
	}


	public void setCreateNewRoom(String createNewRoom) {
		this.createNewRoom = createNewRoom;
	}


	public String getSetDate() {
		return setDate;
	}


	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}


	public String getSetTime() {
		return setTime;
	}


	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}


	public String getMailPassword() {
		return mailPassword;
	}


	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}


	public String getAddMails() {
		return addMails;
	}


	public void setAddMails(String addMails) {
		this.addMails = addMails;
	}


	public String getMeetingSchedularemail() {
		return meetingSchedularemail;
	}


	public void setMeetingSchedularemail(String meetingSchedularemail) {
		this.meetingSchedularemail = meetingSchedularemail;
	}


	public List<String> getAllowedStarters() {
		return allowedStarters;
	}


	public void setAllowedStarters(List<String> allowedStarters) {
		this.allowedStarters = allowedStarters;
	}


	public String getMeetingStatus() {
		return meetingStatus;
	}


	public void setMeetingStatus(String meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	
	
	
	
}
