package com.fantastic.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fantastic.web.dao.MemberDao;
import com.fantastic.web.dao.mybatis.MybatisMemberDao;
import com.fantastic.web.vo.Member;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@RequestMapping("intro/intro")
	public String intro() {
		return "/WEB-INF/view/intro/Intro.jsp";
	}
/*	@RequestMapping(value = "intro/intro", method = RequestMethod.GET)
	public String intro(Member m) {

		return "/WEB-INF/view/intro/Intro.jsp";
	}

	@RequestMapping(value = "intro/intro", method = RequestMethod.POST)
	public String intro(Member m, HttpServletRequest request) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberDao memberDao = new MybatisMemberDao();
		Member member = memberDao.getMember(id);

		if (member == null) {
			return "redirect:../intro/intro";

		}

		else if (!member.getPassword().equals(pw)) {
			return "redirect:../intro/intro";

		}

		else {
			HttpSession session = request.getSession();
			session.setAttribute("mid", id);
			session.setMaxInactiveInterval(60 * 60);

			response.getWriter().println("success"); 
			return "redirect:../mypage/myinfo";
		}
	}
*/
	@RequestMapping(value = "mypage/myinfo", method = RequestMethod.GET)
	public String myinfo(Member member, HttpServletRequest request) {

		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberid = (String) session.getAttribute("mid");
		Member m = memberDao.getMember(memberid);
		request.setAttribute("m", m);
		return "/WEB-INF/view/mypage/Myinfo.jsp";
	}

	@RequestMapping(value = "mypage/myinfo", method = RequestMethod.POST)
	public String myinfo(Model model, HttpServletRequest request,
			MultipartFile file) {

		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberid = (String) session.getAttribute("mid");
		Member m = memberDao.getMember(memberid);
		request.setAttribute("m", m);

		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		// int gender = Integer.parseInt(request.getParameter("gender"));
		// Date birthday = getParameter("birthday");//

		if (password != "" && password2 != "" && password.equals(password2)) {
			m.setPassword(password);
			memberDao.modMember(m);
			// member.setGender(gender);
			// member.setBirthday(birthday);

			// String code = request.getParameter("code");
			// request.setAttribute("m", m);
		}
		return "redirect:../mypage/myinfo";

		/*
		 * if (!file.isEmpty()) { ServletContext application =
		 * request.getServletContext();
		 * 
		 * String url = "/customer/upload"; String path =
		 * application.getRealPath(url); String temp =
		 * file.getOriginalFilename(); String fname =
		 * temp.substring(temp.lastIndexOf("\\")+1); String fpath = path + "\\"
		 * + fname;
		 * 
		 * InputStream ins = file.getInputStream(); OutputStream outs = new
		 * FileOutputStream(fpath);
		 * 
		 * byte[] dl = new byte[1024]; int len = 0;
		 * 
		 * while((len = ins.read(dl, 0, 1024)) >= 0) outs.write(dl, 0, len);
		 * 
		 * outs.flush(); outs.close(); ins.close(); }
		 */
	}

	@RequestMapping("mypage/mypage")
	public String mypage() {

		return "/WEB-INF/view/mypage/Mypage.jsp";
	}

	@RequestMapping("mypage/scrapinfo")
	public String scrapinfo() {

		return "/WEB-INF/view/mypage/Scrapinfo.jsp";
	}

	@RequestMapping(value = "selectpreferlocation/selectpreferlocation", method = RequestMethod.GET)
	public String selectPreferLocation(HttpServletRequest request) {

		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String) session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);

		return "/WEB-INF/view/selectpreferlocation/selectpreferlocation.jsp";
	}

	@RequestMapping(value = "selectpreferlocation/selectpreferlocation", method = RequestMethod.POST)
	public String selectPreferLocation(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		MemberDao memberDao = new MybatisMemberDao();
		String memberId = (String) session.getAttribute("mid");
		Member m = memberDao.getMember(memberId);
		request.setAttribute("m", m);

		int preferLocation = Integer.parseInt(request
				.getParameter("preferLocation"));
		/* response.getWriter().println(preferLocation); */

		/* Member member = new Member(); */
		m.setPreferLocation(preferLocation);

		MemberDao mymemberDao = new MybatisMemberDao();
		mymemberDao.preferLocaMember(m);

		/*
		 * String preferLocation =
		 * request.getParameter("select-prefer-location");
		 * response.getWriter().println(preferLocation);
		 * 
		 * MemberDao memberDao = new MybatisMemberDao(); Member member =
		 * memberDao.getMember(id);
		 */
		return "redirect:../mypage/myinfo";

	}
}
