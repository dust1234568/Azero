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

public class BoardAddAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDTO bDto = new BoardDTO();
		BoardDAO bDao = new BoardDAO();

		Map<String, String> boardMap = FileUpLoad.upload(request, response);
		int articleNo = bDao.getNewArticleNo();

		String title = boardMap.get("subject");
		String content = boardMap.get("content");
		String fileName = boardMap.get("filename");
		String savePath = boardMap.get("savePath");
		System.out.println(savePath);
		String id = boardMap.get("id");

		bDto.setId(id);
		bDto.setSubject(title);
		bDto.setContent(content);
		bDto.setFileName(fileName);
		bDto.setRef(articleNo + 1);
		bDto.setRe_step(0);
		bDto.setRe_level(1);

		System.out.println("BoardAddAction bDTO =====> " + bDto.getFileName());

		int result = bDao.create(bDto);

		if (fileName != null && fileName.length() != 0) {
			File srcFile = new File(savePath + "/" + "temp" + "/" + fileName);
			File destDir = new File(savePath + "/" + (articleNo + 1));
			destDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, destDir, true); // 원 폴더에서 새 폴더로 즉시 파일을 (잘라서) 이동해라

		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();

		if (result > 0) {
			pw.print("<script>" + " alert('새글을 추가했습니다');" + " location.href='" + "boardList.bizpoll';" + "</script>");

		} else {
			pw.print("<script>" + " alert('등록에 실패했습니다');" + " history.go(-1);" + "</script>");
		}

		return null;
	}

}
