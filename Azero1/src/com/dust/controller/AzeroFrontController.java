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
import com.dust.action.ContractAction;
import com.dust.action.FindIdFormAction;
import com.dust.action.IdCheckFormAction;
import com.dust.action.IndexAction;
import com.dust.action.JoinAction;
import com.dust.action.JoinFormAction;
import com.dust.action.LoginAction;
import com.dust.action.LoginFormAction;
import com.dust.action.LogoutAction;
import com.dust.action.MyPageAction;
import com.dust.action.boardNoticeAction;
import com.dust.action.boardQsAction;
import com.dust.action.tabBoardAction;

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

		// --------------- 메인, 회원가입, 프로필 맵핑 ---------------
		if (command.equals("/index.Azero")) { // 메인
			action = new IndexAction();
			forward = action.excute(request, response);
		} else if (command.equals("/loginform.Azero")) { // 로그인 창
			action = new LoginFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/login.Azero")) { // 로그인
			action = new LoginAction();
			forward = action.excute(request, response);
		} else if (command.equals("/logout.Azero")) { // 로그아웃
			action = new LogoutAction();
			forward = action.excute(request, response);
		} else if (command.equals("/contract.Azero")) { // 이용 약관
			action = new ContractAction();
			forward = action.excute(request, response);
		} else if (command.equals("/joinform.Azero")) { // 회원가입 창
			action = new JoinFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/id_check_form.Azero")) { // 아이디 중복 체크
			action = new IdCheckFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/join.Azero")) { // 회원가입
			action = new JoinAction();
			forward = action.excute(request, response);
		} else if (command.equals("/mypages.Azero")) { // 마이페이지, 프로필
			action = new MyPageAction();
			forward = action.excute(request, response);
		} else if (command.equals("/findidform.Azero")) { // 아이디 찾기
			action = new FindIdFormAction();
			forward = action.excute(request, response);
		}
		
		// -------------게시판 맵핑 -------------------
		
		if (command.equals("/tabboard.Azero")) { // 탭 보드
			action = new tabBoardAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardnotice.Azero")) { // 공지사항 탭
			action = new boardNoticeAction();
			forward = action.excute(request, response);
		}	else if (command.equals("/boardqs.Azero")) { // 게시판 글쓰기
			action = new boardQsAction();
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
