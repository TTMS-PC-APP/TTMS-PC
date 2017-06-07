package com.ttms.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttms.model.Play;
import com.ttms.model.Schedule;
import com.ttms.model.Studio;
import com.ttms.service.PlayService;
import com.ttms.service.ScheduleService;
import com.ttms.service.StudioService;

@Controller
@RequestMapping(path="/schedule")
public class ScheduleController {
	@Resource(name="scheduleService")
	private ScheduleService scheduleService;
	@Resource(name="studioService")
	private StudioService studioService;
	@Resource(name="playService")
	private PlayService playService;
	@RequestMapping(path="/insert.do")
	@ResponseBody
	public int insertSched(Schedule schedule)
	{
		int count=scheduleService.InsertSched(schedule);
		return count;
	}
	@RequestMapping(path="/get.do")
	@ResponseBody
	public Schedule getSchedById(Schedule schedule)
	{
			if(schedule==null)
			{
				return null;
			}
			return scheduleService.getScheduleById(schedule);
	}
	@RequestMapping(path="/query.do")
	@ResponseBody
	public String getAllSchedule(Model model)
	{	
		List<Schedule> scheds=scheduleService.getAllSchedule();
		model.addAttribute("scheds", scheds);
		return "/performancePlan";
	}
	@RequestMapping(path="/delete.do")
	public String deleteById(Schedule schedule)
	{
		if(schedule.getSched_id()==0)
		{
			return null;
		}
		scheduleService.deleteScheduleById(schedule);
		return "redirect:/schedule/enter.do";
	}
	@RequestMapping(path="/update.do")
	@ResponseBody
	public int updateById(Schedule schedule)
	{
		return scheduleService.updateScheduleById(schedule);
	}
	@RequestMapping(path="/date.do")
	@ResponseBody
	public List<Schedule> updateByDate(Schedule schedule)
	{
		if(schedule.getSched_time()==null)
		{
			return null;
		}
		return scheduleService.getScheduleByDate(schedule);
	}
	@RequestMapping(path="/enter.do")
	public String getAll(Model model)
	{
		List<Schedule> scheds=scheduleService.getSchedule();
		model.addAttribute("scheds", scheds);
		return "/performancePlan";
	}
	@RequestMapping("/stuname.do")
	@ResponseBody
	public List<Studio> getStuidoName(Studio studio)
	{
		studio.setStudio_name("");
		List<Studio> list = studioService.getAllStudio(studio);
		return list;
	}
	@RequestMapping("/plname.do")
	@ResponseBody
	public List<Play> getPlayName(Play play)
	{
		play.setPlay_name("");
		List<Play> list = playService.getAllData(play);
		return list;
	}
	@RequestMapping(path="/find.do")
	@ResponseBody
	public List<Schedule> getAllSchedById(Schedule schedule)
	{
		return scheduleService.findScheduleById(schedule);
	}
	@RequestMapping(path="/gdate.do")
	@ResponseBody
	public List<Schedule> getDateSched()
	{
		return scheduleService.getScheduleDate();
	}
}
