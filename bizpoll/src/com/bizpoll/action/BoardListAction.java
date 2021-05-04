package com.bizpoll.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardListAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url ="board/boardList.jsp";
		
		BoardDAO bDao = new BoardDAO();
		
		String _section = request.getParameter("section");
		String _pageNum = request.getParameter("pageNum");
		
		// select box 선택 
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		int section = Integer.parseInt((_section == null) ? "1" : _section);
		int pageNum = Integer.parseInt((_pageNum == null) ? "1" : _pageNum);
		
		Map<String, Object> pagingMap = new HashMap<>();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		pagingMap.put("searchType", searchType);
		pagingMap.put("searchKeyword", searchKeyword);
		
		List<BoardDTO> boardList = bDao.boardList(pagingMap);
		
		int boardListAllCnt = bDao.boardListAllCnt(pagingMap);
		
		
		Map<String, Object> boardInfo = new HashMap<>();
		
		boardInfo.put("selAllBoardList", boardList);
		boardInfo.put("boardListAllCnt", boardListAllCnt);
		boardInfo.put("section", section);
		boardInfo.put("pageNum", pageNum);
		boardInfo.put("searchType", searchType);
		boardInfo.put("searchKeyword", searchKeyword);
		
		request.setAttribute("boardInfo", boardInfo);
		
		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
