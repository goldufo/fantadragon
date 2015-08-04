package com.fantastic.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.MemberFileDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberFileDao;
import com.fantastic.web.vo.Member;
import com.fantastic.web.vo.MemberFile;

/*@WebServlet("/mypage/myinfo")*/
public class MyinfoController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberid = (String)session.getAttribute("mid");
		Member m = memberDao.getMember(memberid);
		request.setAttribute("m", m);
		
		/* if ("gender" == 0)
		{
			int gender = 0;
			m.setGender(gender);
		} */
		//int preferlocation = m.getPreferLocation();

		
		if (request.getMethod().equals("POST"))
		{
			
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			//int gender = Integer.parseInt(request.getParameter("gender"));
			//Date birthday = getParameter("birthday");//

			Member member = new Member();
			member.setId(memberid);
			
			if (password != "" && password2 != "" && password.equals(password2))
			{
				member.setPassword(password);
				memberDao.modMember(member);
				//member.setGender(gender);
				//member.setBirthday(birthday);

				//String code = request.getParameter("code");
				//request.setAttribute("m", m);
				response.sendRedirect("../mypage/myinfo");
			}
			
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();

			String url = "/customer/upload";
			String path = application.getRealPath(url);
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\")+1);
			String fpath = path + "\\" + fname;
			response.getWriter().println(fpath);
			
			InputStream ins = part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
			
			byte[] dl = new byte[1024];
			int len = 0;
			
			while((len = ins.read(dl, 0, 1024)) >= 0)
				outs.write(dl, 0, len);
			
			outs.flush();
			outs.close();
			ins.close();
			
			String file = request.getParameter("file");
	
			//Member member = new Member();
			MemberFile memberfile = new MemberFile();

			memberDao.addMember(member);
			
			MemberFileDao memberfiledao = new MybatisMemberFileDao();
			memberfile.setPicture("picture");
			
			memberfiledao.addMemberFile(memberfile);
			
			response.sendRedirect("myinfo");
		}
		else 
		{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mypage/Myinfo.jsp");
		dispatcher.forward(request, response);
		}
	}
}
