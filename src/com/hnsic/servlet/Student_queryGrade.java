package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hnsic.dao.StudentDao;
import com.hnsic.daoimpl.StudentDaoimpl;
import com.hnsic.entity.Grade;

public class Student_queryGrade extends HttpServlet {
	//学生查询寝室扣分
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");			
		//获取表单传过来的数据
		String dormID=request.getParameter("dormID");
		String roomID=request.getParameter("roomID");
		
//		String dormID="59栋";
//		String roomID="117";
		
		System.out.println(dormID);
		System.out.println(roomID);
		
		try{
			//新建操作对象
			StudentDao studenDao=new StudentDaoimpl();
			
			//调用查询方法
			List<Grade> list=studenDao.getgrade(dormID,roomID);
			
			request.setAttribute("list1", list);
			//System.out.println(list);
			request.getRequestDispatcher("student/Student_queryGrade.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
