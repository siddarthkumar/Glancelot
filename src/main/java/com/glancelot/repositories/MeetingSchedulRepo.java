package com.glancelot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glancelot.models.MeetingSchedular;

public interface MeetingSchedulRepo extends JpaRepository<MeetingSchedular,Integer>{
	boolean existsMeetingSchedularByMeetingSchedularemail(String meetingSchedularemail);
	public MeetingSchedular getMeetingSchedularByMeetingSchedularemail(String meetingSchedularemail);
	public MeetingSchedular findById(int id);
}
