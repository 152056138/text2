package com.wq.ms.service;

import java.util.List;

import com.wq.ms.bean.Student;

public interface IStudentService {
	//ע��
	void register(Student student) throws Exception;
	//��¼
	Student login(String username,String password) throws Exception;
	//��ѧ
	void leave(Long id) throws Exception;
	//��ʾ
	List<Student> listAll(List<Student> list) throws Exception;
	
}
