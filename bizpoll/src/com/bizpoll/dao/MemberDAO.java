package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class MemberDAO {

	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {

		return instance;
	}

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSesseion();
	SqlSession sqlSession;

	// 회원 정보 조회
	public MemberDTO getMember(String userId) {

		MemberDTO mDto = null;

		String sql = "SELECT * FROM member WHERE id= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mDto = new MemberDTO();

				mDto.setId(rs.getString("id"));
				mDto.setPwd(rs.getString("pwd"));
				mDto.setName(rs.getString("name"));
				mDto.setEmail(rs.getString("email"));
				mDto.setZip_num(rs.getString("zip_num"));
				mDto.setAddress(rs.getString("address"));
				mDto.setPhone(rs.getString("phone"));
				mDto.setUseyn(rs.getString("useyn"));
				mDto.setIndate(rs.getDate("indate"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return mDto;
	}
	
	// mybatis 회원 정보 조회
	public MemberDTO getMember(MemberDTO mDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		
		
		return null;
	}
	

	// jdbc 회원가입 유무 확인 
	public int confirmID(String userId) {

		// 회원 가입 유무 판별 하는 변수
		int result = -1;

		String sql = "SELECT * FROM member WHERE id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = 1;
			} else {
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println(result);
		return result;
	}
	
	// jdbc 회원가입
	public int joinMembers(MemberDTO mDto) {

		String sql = "INSERT INTO member(id, pwd, name, email, address, phone, zip_num) VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPwd());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getEmail());
			pstmt.setString(5, mDto.getAddress());
			pstmt.setString(6, mDto.getPhone());
			pstmt.setString(7, mDto.getZip_num());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// my batis 회원가입
	public int joinMember(MemberDTO mDto) {

		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			result = sqlSession.insert("joinMember", mDto);

			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	// jdbc 회원 탈퇴
	public int delMembers(MemberDTO mDto) {

		String sql = "DELETE FROM member WHERE id = ? AND pwd = ?;";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPwd());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}
	
	// mybatis 회원 탈퇴
	public int delMember(MemberDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		
		try {
			result = sqlSession.delete("delMember", mDto);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}

	// jdbc 회원 정보 수정
	public int upMember(String pwd, String id, String rePwd) {

		String sql = "UPDATE member SET pwd = ? WHERE id = ? AND pwd = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rePwd);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	// my batis 회원 정보 수정
	public int upMember(MemberDTO mDto) {
		
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		
		try {
			result = sqlSession.update("upMember", mDto);
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
}
