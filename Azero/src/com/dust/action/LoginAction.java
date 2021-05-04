package com.dust.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dust.dao.MemberDAO;
import com.dust.dto.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/login_fail.jsp";

		HttpSession session = request.getSession();

		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");

		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.getMember(userId);

		if (mDto != null) {

			if (mDto.getPwd().equals(userPwd)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", mDto);
				url = "index.Azero";
			}
		}

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
