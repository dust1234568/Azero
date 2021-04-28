package com.dust.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dust.action.Action;
import com.dust.action.ActionFoward;
import com.dust.action.IndexAction;

@WebServlet("/AzeroFrontController")
public class AzeroFrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AzeroFrontController() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Action action = null;
		ActionFoward forward = null;

		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());

		System.out.println("uri ==> " + uri);
		System.out.println("ctx ==> " + ctx);
		System.out.println("command ==> " + command);

		// --------------- 액션 맵핑 ---------------
		if (command.equals("/index.Azero")) { // 메인
			action = new IndexAction();
			forward = action.excute(request, response);
		}

		
		// --------------- 공통 분기 작업 ---------------
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response); // 공통 분기 작업 들어가는 곳

			}
		}
	}
}
