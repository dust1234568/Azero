package com.bizpoll.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.bizpoll.common.FileUpLoad;
import com.bizpoll.dao.BoardDAO;
import com.bizpoll.dto.BoardDTO;

public class BoardModifyAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "board/boardList.jsp";
		
		BoardDTO bDto = new BoardDTO();
		
		BoardDAO bDao = new BoardDAO();
		
		Map<String, String> boardMap = FileUpLoad.upload(request, response);
		
		int articleNo = Integer.parseInt(boardMap.get("articleNo"));

		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String originalFileName = boardMap.get("originalFileName");
		String fileName = boardMap.get("fileName");
		String savePath = boardMap.get("savePath");

		bDto.setArticleNo(articleNo);
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFileName(fileName);

		int result = bDao.modify(bDto);
		
		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "/" + "temp" + "/" + fileName);
			File destDir = new File(savePath + "/" + articleNo);
			destDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, destDir, true); // 원 폴더에서 새 폴더로 즉시 파일을 (잘라서) 이동해라
			
			File oldFile = new File(savePath + "/" + articleNo + "/" + originalFileName);
			oldFile.delete();

		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();

		if (result > 0) {
			pw.print("<script>" + " alert('정상 처리 되었습니다.');" + " location.href='" + "boardList.bizpoll';" + "</script>");

		} else {
			pw.print("<script>" + " alert('비 정상 처리 되었습니다.');" + " history.go(-1);" + "</script>");
		}
		
		return null;
	}

}
