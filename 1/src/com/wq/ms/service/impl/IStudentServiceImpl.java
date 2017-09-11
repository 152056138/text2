package com.wq.ms.service.impl;

import java.util.List;

import com.wq.ms.bean.Student;
import com.wq.ms.dao.StudentDao;
import com.wq.ms.service.IStudentService;

public class IStudentServiceImpl implements IStudentService {
	StudentDao studentDao=new StudentDao();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(Student student) throws Exception {
		//��֤�û���Ψһ
		Student db_student= studentDao.FindByName(student.getUsername());
		if(db_student==null){
			studentDao.save(db_student);
		}
		else{
			throw new Exception("�û����Ѵ��ڣ�");
		}
	}

	@Override
	public Student login(String username, String password) throws Exception {
		Student student=null;
		Student db_student=studentDao.FindByName(username);
		if(db_student!=null){
			if(password.equals(db_student.getPassword())){
				student=db_student;
			}else{
				throw new Exception("�������");
			}
		}else{
			throw new Exception("�û��������ڣ�");
		}
		//��¼�ɹ�������ѧ����Ϣ����Ҫ���û���ʾ����Ϣ��
		return student;
		
		
	}

	@Override
	public void leave(Long id) throws Exception {
		Long Id=studentDao.deleteByid(id);
		if(Id==null){
			throw new Exception("ID�����ڣ�");
		}
	}

	@Override
	public List<Student> listAll(List<Student> list) throws Exception {
		studentDao.FindAll(list);
		return list;
	}

}
