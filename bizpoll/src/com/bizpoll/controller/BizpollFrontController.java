package com.bizpoll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.action.Action;
import com.bizpoll.action.ActionFoward;
import com.bizpoll.action.BoardAddAction;
import com.bizpoll.action.BoardFormAction;
import com.bizpoll.action.BoardListAction;
import com.bizpoll.action.BoardModifyAction;
import com.bizpoll.action.BoardReplyAction;
import com.bizpoll.action.BoardReplyFormAction;
import com.bizpoll.action.BoardViewAction;
import com.bizpoll.action.ContractAction;
import com.bizpoll.action.DetailAction;
import com.bizpoll.action.FindZipNumAction;
import com.bizpoll.action.IdCheckFormAction;
import com.bizpoll.action.ImagePreViewAction;
import com.bizpoll.action.IndexAction;
import com.bizpoll.action.JoinAction;
import com.bizpoll.action.JoinFormAction;
import com.bizpoll.action.LoginAction;
import com.bizpoll.action.LoginFormAction;
import com.bizpoll.action.LogoutAction;
import com.bizpoll.action.MemDeleteAction;
import com.bizpoll.action.MemUpdateAction;
import com.bizpoll.action.MyPageAction;

/**
 * Servlet implementation class BizpollFrontController
 */
@WebServlet("/BizpollFrontController")
public class BizpollFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BizpollFrontController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 깨짐 방지 (post방식)
		request.setCharacterEncoding("UTF-8");

		Action action = null;
		DetailAction dAction = null; // 상품 상세 -> Action 으로 변경할 것
		ActionFoward forward = null;

		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());

		System.out.println("uri ==> " + uri);
		System.out.println("ctx ==> " + ctx);
		System.out.println("command ==> " + command);

		// --------------- 액션 맵핑 ---------------
		if (command.equals("/index.bizpoll")) { // 메인
			action = new IndexAction();
			
			forward = action.excute(request, response);
		} else if (command.equals("/login_form.bizpoll")) { // 로그인 창
			action = new LoginFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/login.bizpoll")) { // 로그인
			action = new LoginAction();
			forward = action.excute(request, response);
		} else if (command.equals("/logout.bizpoll")) { // 로그아웃
			action = new LogoutAction();
			forward = action.excute(request, response);
		} else if (command.equals("/contract.bizpoll")) { // 약관
			action = new ContractAction();
			forward = action.excute(request, response);
		} else if (command.equals("/join_form.bizpoll")) { // 회원 가입 창
			action = new JoinFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/id_check_form.bizpoll")) { // 아이디 확인 (중복 체크)
			action = new IdCheckFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/find_zip_num.bizpoll")) { // 주소 검색
			action = new FindZipNumAction();
			forward = action.excute(request, response);
		} else if (command.equals("/join.bizpoll")) { // 회원 가입
			action = new JoinAction();
			forward = action.excute(request, response);
		} else if (command.equals("/mypages.bizpoll")) { // 마이 페이지
			action = new MyPageAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memupdates.bizpoll")) { // 회원 정보 수정
			action = new MemUpdateAction();
			
			forward = action.excute(request, response);
		} else if (command.equals("/memdeletes.bizpoll")) { // 회원 탈퇴
			action = new MemDeleteAction();
			forward = action.excute(request, response);
		}
		
		// ---------------------게시판 액션 맵핑 ---------------------
		
		if (command.equals("/boardList.bizpoll")) { // 게시판 
			action = new BoardListAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardForm.bizpoll")) { // 게시판 글쓰기
			action = new BoardFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardAdd.bizpoll")) { // 게시판 글 등록
			action = new BoardAddAction();
			forward = action.excute(request, response);
		} else if (command.equals("/imagePreView.bizpoll")) { // 사진 원본 상세
			action = new ImagePreViewAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardView.bizpoll")) { // 게시글 상세
			action = new BoardViewAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardModify.bizpoll")) {
			action = new BoardModifyAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardReplyForm.bizpoll")) {
			action = new BoardReplyFormAction();
			forward = action.excute(request, response);
		} else if (command.equals("/boardReply.bizpoll")) {
			action = new BoardReplyAction();
			forward = action.excute(request, response);
		}
		
//		else if (command.equals("/boardDetail.bizpoll")) { // 게시글 상세 (my)
//			action = new BoardDetailAction();
//			forward = action.excute(request, response);
//		}
		
		// --------------------- 상세 --------------------------

		if (command.equals("/product_detail.bizpoll")) { // 상품 상세
			dAction = new DetailAction();
			forward = dAction.excute(request, response);
		}

//		if (command.equals("/member.bizpoll")) {
//			lAction = new LoginFormAction();
//			forward = lAction.excute(request, response);
//		}

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
