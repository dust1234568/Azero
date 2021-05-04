package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardViewAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "board/boardView.jsp";

		int articleNo = Integer.parseInt(request.getParameter("articleNo"));

		BoardDAO bDao = BoardDAO.getInstance();

		BoardDTO selBoardView = bDao.selBoardView(articleNo);
		System.out.println("selBoardView >> " + selBoardView);

		request.setAttribute("selBoardView", selBoardView);

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
