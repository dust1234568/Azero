package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.bizpoll.dao.MemberDAO;

public class IdCheckFormAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/idcheck.jsp";

		String userId = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getInstance();

		int message = mDao.confirmID(userId);
		System.out.println(userId);
		// json
		JSONObject jObj = new JSONObject();
		
		jObj.put("message", message);
		jObj.put("id", userId);
		
		response.setContentType("application/x-json; charset=UTF-8"); // 오타 x
		response.getWriter().print(jObj);
		
//		request.setAttribute("message", message);
//		request.setAttribute("id", userId);
		
		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		//return foward
		return null;
	}

}
