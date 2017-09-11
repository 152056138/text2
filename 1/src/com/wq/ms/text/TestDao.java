package com.wq.ms.text;

import com.wq.ms.bean.Student;
import com.wq.ms.dao.StudentDao;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StudentDao studentDao=new StudentDao();
        Student student=new Student(null,"ad","123",23);
        studentDao.save(student);
	}

}
