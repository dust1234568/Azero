package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login_fail.jsp";

		HttpSession session = request.getSession();

		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");

		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.getMember(userId);

		if (mDto != null) {

			if (mDto.getPwd().equals(userPwd)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", mDto);
				url = "index.bizpoll";
			}
		}

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;

//		MemberDTO mDto = null;
//
//		String sql = "SELECT * FROM member WHERE id= ? AND pwd= ?";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			pstmt.setString(2, userPwd);
//
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				mDto = new MemberDTO();
//				
//				mDto.setId(rs.getString("id"));
//				mDto.setPwd(rs.getString("pwd"));
//				mDto.setName(rs.getString("name"));
//				mDto.setEmail(rs.getString("email"));
//				mDto.setZip_num(rs.getString("zip_num"));
//				mDto.setAddress(rs.getString("address"));
//				mDto.setPhone(rs.getString("phone"));
//				mDto.setUseyn(rs.getString("useyn"));
//				mDto.setIndate(rs.getDate("indate"));
//				
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
	}

}
