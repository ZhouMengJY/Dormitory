package com.hnsic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnsic.dao.SysadminDao;
import com.hnsic.daoimpl.SysadminDaoimpl;
import com.hnsic.entity.Admin;

public class Sysadmin_modifyadmin extends HttpServlet {
	//修改宿舍管理员
	
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
		//接受表单提交过来的数据
		String adminID=request.getParameter("adminID");
		String dormID=request.getParameter("dormID");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String remarks=request.getParameter("remarks");
		
		System.out.println(adminID);
		
		//创建JavaBean对象
		Admin admin=new Admin();
		//将数据装载到JavaBean
		admin.setAdminID(adminID);
		admin.setDormID(dormID);
		admin.setPassword(password);
		admin.setName(name);
		admin.setSex(sex);
		admin.setPhone(phone);
		admin.setRemarks(remarks);
		//调用数据Dao层
		SysadminDao sysadminDao=new SysadminDaoimpl();
		boolean flag=sysadminDao.modifyadmin(admin);
		
		if(flag){
			out.print("<script language='javascript'>alert('修改宿舍管理员信息成功!!!');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_modifysuccess.jsp';</script>");
		  }else{
			out.print("<script language='javascript'>alert('修改宿舍管理员信息失败，请重新修改!!!');" +
							"window.location.href='/dormitory/Sysadmin/sysadmin_modifyfail.jsp';</script>");
				}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
