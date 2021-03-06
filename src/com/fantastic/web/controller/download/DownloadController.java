package com.fantastic.web.controller.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@WebServlet("/mypage/download")
public class DownloadController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fname = request.getParameter("f");
		
		response.setHeader("Content-Disposition", "attachment;filename=" + fname);
		response.setContentType("application/octet-stream");
		
		ServletContext application = request.getServletContext();
		
		
		
		String url = "/customer/upload";
		String path = application.getRealPath(url);
		String fpath = path + "\\" + fname;
		
		

		OutputStream outs = response.getOutputStream();
		InputStream ins = new FileInputStream(fpath);
		
		byte[] dl = new byte[1024];
		int len = 0;
		
		while((len = ins.read(dl, 0, 1024)) >= 0)
			outs.write(dl, 0, len);
		
		outs.flush();
		outs.close();
		ins.close();
	}
}
