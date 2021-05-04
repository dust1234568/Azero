package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.BoardDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {

		return instance;
	}

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSesseion();
	SqlSession sqlSession;

	// 목록 취득
	public List<BoardDTO> boardList(Map<String, Object> boardParmMap) {
		sqlSession = sqlSessionFactory.openSession();

		List<BoardDTO> boardList = null;

		try {
			boardList = sqlSession.selectList("selBoardList", boardParmMap);
			// System.out.println("BoardList -> " + boardList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return boardList;
	}

	// 폴더 생성용 articleNO 취득
	public Integer getNewArticleNo() {
		sqlSession = sqlSessionFactory.openSession();

		Integer articleNo = 0;

		try {
			articleNo = sqlSession.selectOne("getNewArticleNo");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return articleNo;
	}

	public int create(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			result = sqlSession.insert("createBoard", bDto);
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	public BoardDTO getNewArticleNo(String articleNo) {

		BoardDTO board = new BoardDTO();

		String sql = "SELECT * FROM board WHERE articleNo = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, articleNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				board.setArticleNo(rs.getInt("articleNo"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setFileName(rs.getString("filename"));
				board.setReg_date(rs.getTimestamp("reg_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return board;
	}

	public BoardDTO selBoardView(int articleNo) {

		BoardDTO selBoard = null;

		sqlSession = sqlSessionFactory.openSession();

		try {
			selBoard = sqlSession.selectOne("selectBoardView", articleNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return selBoard;
	}

	public int modify(BoardDTO bDto) {

		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			result = sqlSession.update("modifyBoard", bDto);
			sqlSession.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return 0;
	}

	public int replyReStepUpDate(BoardDTO bDto) {

		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			int maxOrder = sqlSession.selectOne("selectBoardReplyMaxOrder", bDto);
			System.out.println("maxOrder ==> " + maxOrder);

			if (maxOrder == 0) {
				int selectReStep = sqlSession.selectOne("selectReStep", bDto);
				int re_level = bDto.getRe_level() + 1;

				bDto.setRe_step(selectReStep);
				bDto.setRe_level(re_level);

				result = sqlSession.insert("createBoard", bDto);
				sqlSession.commit();

			} else {
//				maxOrder = sqlSession.selectOne("selectBoardReplyMaxOrder", bDto);
//				bDto.setRe_step(maxOrder);

				sqlSession.update("replyReStepUpdate", bDto);

				bDto.setRe_step(bDto.getRe_step() + 1);

				int re_level = bDto.getRe_level() + 1;

				bDto.setRe_level(re_level);

				result = sqlSession.insert("createBoard", bDto);
				sqlSession.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}
	
	// 총 건수
	public int boardListAllCnt(Map<String, Object> boardParmMap) {
		sqlSession = sqlSessionFactory.openSession();
		
		int boardListAllCnt = 0;
		
		try {
			boardListAllCnt = sqlSession.selectOne("boardListAllCnt", boardParmMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardListAllCnt;
	}

	

}
