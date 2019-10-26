package com.oy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oy.entity.Diary;
import com.oy.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;

	@RequestMapping("writediary")
	public String writediary(Diary diary) throws Exception {
		try {
			Date currentdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String timeDate = sdf.format(currentdate);
			diary.setTime(timeDate);
			diaryService.addDiary(diary);
			return "Dsuccess";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping("selectAllDiary")
	public String selectAllDiary(HttpServletRequest request) {
		try {
			List<Diary> diaries = diaryService.listDiary();
			request.setAttribute("diarys", diaries);
			return "saylist";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("admindiary")
	public String admindiary(HttpServletRequest request) {
		try {
			List<Diary> diaryList = diaryService.listDiary();
			request.setAttribute("diarys", diaryList);
			return "admindiary";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("deleteDiaryById")
	public String deleteDiaryById(HttpServletRequest request) {
		try {
			String idString = request.getParameter("diaryid");
			int diaryid = Integer.parseInt(idString);
			diaryService.deleteDiary(diaryid);
			return "redirect:admindiary";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
