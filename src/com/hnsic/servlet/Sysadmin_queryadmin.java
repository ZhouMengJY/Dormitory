package com.hnsic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Admin;

public class Sysadmin_queryadmin extends HttpServlet {
	//查询宿舍管理员

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			//新建操作对象
			SysadminDao sysadminDao=new SysadminDaoimpl();
			//调用查询方法
			List<Admin> list=sysadminDao.queryadmin();
			
			System.out.println(list);
			
			//把数组放入会话中
			HttpSession session=request.getSession();
			session.setAttribute("listc", list);
			response.sendRedirect("/dormitory/Sysadmin/sysadmin_adminmessage.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
