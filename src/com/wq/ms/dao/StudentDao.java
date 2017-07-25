package com.wq.ms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wq.ms.bean.Student;
import com.wq.ms.common.ConnectionFactory;

public class StudentDao {
	Student Student =  
	//��
	public void save(Student student){
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="insert into tbl_student values(null,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, student.getUsername());
				pstmt.setString(2, student.getPassword());
				pstmt.setInt(3, student.getAge());
				int num=pstmt.executeUpdate();
				System.out.println("�ɹ�����"+num+"��");
			} finally {
				ConnectionFactory.close(null, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ
	public Long deleteByid(Long id){
		Long Id=null;
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="delete from tbl_student where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, id);
				int num=pstmt.executeUpdate();
				System.out.println("�ɹ�ɾ��"+num+"��");
				rs=pstmt.executeQuery();
				Id=rs.getLong("id");
			} finally {
				ConnectionFactory.close(null, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Id;
	}
	//��
	public void update(Student stu){
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="update tbl_student set username=?,password=?,age=? where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,stu.getUsername());
				pstmt.setString(2, stu.getPassword());
				pstmt.setInt(3, stu.getAge());
				pstmt.setLong(4, stu.getId());
				int num=pstmt.executeUpdate();
				System.out.println("�ɹ��޸�"+num+"��");
			} finally {
				ConnectionFactory.close(null, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��
	public List<Student> FindAll(List<Student> list){
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Student student=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="select * from tbl_student";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String username=rs.getString("username");
					String password=rs.getString("password");
					Integer age=rs.getInt("age");
					student=new Student(null,username,password,age);
					list.add(student);
				}
			} finally {
				ConnectionFactory.close(rs, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//==========================
	public List<Student> query(Long id,String username,String password,Integer age){
		List<Student> list=new ArrayList<Student>();
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="select * from tbl_student where 1=1";
				if(id!=null){sql+=" and id="+id;}
				if(username!=null){sql+=" and username='"+username+"'";}
				if(password!=null){sql=" and password='"+password+"'";}
				if(age!=null){sql+=" and age"+age;}
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long db_id=rs.getLong("id");
					String db_username=rs.getString("username");
					String db_password=rs.getString("password");
					Integer db_age=rs.getInt("age");
					Student student=new Student(db_id,db_username,db_password,db_age);
					list.add(student);
				}
			} finally {
				ConnectionFactory.close(rs, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public Student FindByName(String name){
		Student student=null;
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="select * from tbl_student where username=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, name);
				rs=pstmt.executeQuery();
					Long id=rs.getLong("id");
					String username=rs.getString("username");
					String password=rs.getString("password");
					Integer age=rs.getInt("age");
					student=new Student(id,username,password,age);
			} finally {
				ConnectionFactory.close(rs, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
/*
	public Student FindById(Long Id){
		Student student=null;
		try {
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				conn=ConnectionFactory.getconn();
				String sql="select * from tbl_student where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1,Id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					Long id=rs.getLong("id");
					String username=rs.getString("username");
					String password=rs.getString("password");
					Integer age=rs.getInt("age");
					student=new Student(id, username, password, age);
				}
			} finally {
				ConnectionFactory.close(rs, conn, pstmt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
*/
}
