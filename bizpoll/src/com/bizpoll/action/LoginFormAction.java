package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 처리하고 보내줘야할 주소, 호출.  메인메소드와 비슷
		String uri = "member/login.jsp";
		
//		ProductDAO pDao = ProductDAO.getInstance(); // 싱글턴 패턴 방식
//		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		System.out.println("> " + id + "," + pwd);
//		MemberDTO pDto = pDao.memLogin(id, pwd);
//		request.setAttribute("memLogin", pDto);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		
		return forward;
	}
	
}
