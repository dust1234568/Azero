package com.dust.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dust.common.DBManager;
import com.dust.dto.MemberDTO;
import com.dust.mybatis.SqlMapConfig;

public class MemberDAO {

	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {

		return instance;
	}

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSesseion();
	SqlSession sqlSession;

	// mybatis 회원 정보 조회
	public MemberDTO getMember(String userId) {
		sqlSession = sqlSessionFactory.openSession();

		MemberDTO mDto = null;

		try {
			mDto = sqlSession.selectOne("getMember", userId);
			System.out.println("mDto = " + mDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return mDto;
	}

	// mybatis id로 회원가입 유무 확인
	public int confirmID(String userId) {

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

	// mybatis 회원가입
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

	// mybatis 회원 정보 수정
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
