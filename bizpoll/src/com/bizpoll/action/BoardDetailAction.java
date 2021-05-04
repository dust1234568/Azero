package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardDetailAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "board/boardView.jsp";

		BoardDAO bDao = BoardDAO.getInstance();

		String articleNo = request.getParameter("articleNo");

		BoardDTO bDto = bDao.getNewArticleNo(articleNo);
		request.setAttribute("boardView", bDto);

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
