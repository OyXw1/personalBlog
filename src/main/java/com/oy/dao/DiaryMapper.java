package com.oy.dao;

import java.util.List;

import com.oy.entity.Diary;

public interface DiaryMapper {
	public List<Diary> listDiary();

	public List<Diary> findById(int diaryid);

	public void addDiary(Diary diary);

	public void deleteDiary(int diaryid);

}
