package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;

public class MemUpdateAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/memupdates.jsp";

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String rePwd = request.getParameter("rePwd");

		MemberDAO mDao = MemberDAO.getInstance();

		if (mDao.upMember(pwd, id, rePwd) == 1) {
			url = "member/mypages.jsp";
		}

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
