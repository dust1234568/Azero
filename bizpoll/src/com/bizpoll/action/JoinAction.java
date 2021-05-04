package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class JoinAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/login.jsp";

		MemberDTO mDto = new MemberDTO();

		mDto.setId(request.getParameter("id"));
		mDto.setPwd(request.getParameter("pwd"));
		mDto.setName(request.getParameter("name"));
		mDto.setEmail(request.getParameter("email"));
		mDto.setZip_num(request.getParameter("zipNum"));
		mDto.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		mDto.setPhone(request.getParameter("phone"));

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.joinMember(mDto);
		
		if (result < 0) {
			url = "member/login_fail.jsp";
		}
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);

		return forward;
	}

}
