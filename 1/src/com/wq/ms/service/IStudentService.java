package com.wq.ms.service;

import java.util.List;

import com.wq.ms.bean.Student;

public interface IStudentService {
	//×¢²á
	void register(Student student) throws Exception;
	//µÇÂ¼
	Student login(String username,String password) throws Exception;
	//ÍËÑ§
	void leave(Long id) throws Exception;
	//ÏÔÊ¾
	List<Student> listAll(List<Student> list) throws Exception;
	
}
