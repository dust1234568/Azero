package com.dust.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return mDto;
	}

	// mybatis id로 회원가입 유무 확인
	public int confirmID(String userId) {

		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			result = sqlSession.selectOne("confirmId", userId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

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
