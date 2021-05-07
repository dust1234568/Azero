package com.dust.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dust.dao.MemberDAO;

public class IdCheckFormAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "member/idcheck.jsp";

		String userId = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getInstance();

		int message = mDao.confirmID(userId);
		System.out.println("userId : "  + userId);
		System.out.println("message : "  + message);
		// json
		JSONObject jObj = new JSONObject();

		jObj.put("message", message);
		jObj.put("id", userId);

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return null;
	}

}
