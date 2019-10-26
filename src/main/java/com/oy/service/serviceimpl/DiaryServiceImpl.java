package com.oy.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oy.dao.DiaryMapper;
import com.oy.entity.Diary;
import com.oy.service.DiaryService;

@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	private DiaryMapper diaryMapper;

	@Override
	public List<Diary> listDiary() {

		return diaryMapper.listDiary();
	}

	@Override
	public List<Diary> findById(int diaryid) {
		// TODO Auto-generated method stub
		return diaryMapper.findById(diaryid);
	}

	@Override
	public void addDiary(Diary diary) {
		// TODO Auto-generated method stub
		diaryMapper.addDiary(diary);
	}

	@Override
	public void deleteDiary(int diaryid) {
		// TODO Auto-generated method stub
		diaryMapper.deleteDiary(diaryid);
	}

}
