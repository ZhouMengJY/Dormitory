package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Instructor;

public class Sysadmin_deleteinstructor extends HttpServlet {
	//删除辅导员信息
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		//使用ALTER弹出提示信息，防止乱码。
		String CONTENT_TYPE = "text/html; charset=GBK";
		response.setContentType(CONTENT_TYPE);			
		PrintWriter out=response.getWriter();     //初始化out对象
		//获取表单提交过来的要删除的商品编号
		String instructorID=request.getParameter("instructor.instructorID");
		//新建操作对象
		Instructor instructor=new Instructor();
		instructor.setInstructorID(instructorID);
		//调用Dao层
		try{
			SysadminDao sysadminDao=new SysadminDaoimpl();
			boolean flag=sysadminDao.deleteinstructor(instructor);
			
			if(flag){
				out.print("<script language='javascript'>alert('删除辅导员信息成功!!!');" +
						"window.location.href='/dormitory/Sysadmin/sysadmin_deletesuccess.jsp';</script>");
			}else{
				out.print("<script language='javascript'>alert('发生未知错误，删除辅导员信息失败!!!');" +
						"window.location.href='/dormitory/Sysadmin/sysadmin_deleteinstructor.jsp';</script>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
