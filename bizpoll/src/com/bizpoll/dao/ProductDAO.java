package com.bizpoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bizpoll.common.DBManager;
import com.bizpoll.dto.MemberDTO;
import com.bizpoll.dto.ProductDTO;

public class ProductDAO {

	private ProductDAO() {

	}

	private static ProductDAO instance = new ProductDAO(); // 싱글턴 패턴 (이른초기화, thread-safe)

	public static ProductDAO getInstance() {
		return instance;
	}

	public ArrayList<ProductDTO> listNewProduct() {
		
		ArrayList<ProductDTO> newProductList = new ArrayList<ProductDTO>();
// 신상품 추출 sql
//	SELECT p_code,
//		   p_name,
//		   p_price2,
//		   p_img
//	FROM (SELECT rownum,
//				 p_code,
//				 p_name,
//				 p_price2,
//				 p_img
//		  FROM porduct
//		  WHERE p_bestyn = 'y'
//		  ORDERBY p_indate desc)
//	WHERE rownum <= 4;
		
		String sql = "SELECT * FROM new_pro_view";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				
				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));
				
				newProductList.add(product);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return newProductList;
	}
	
	public ArrayList<ProductDTO> listBestProduct() {
		ArrayList<ProductDTO> bestProductList = new ArrayList<ProductDTO>();
		
		String sql = "SELECT * FROM best_pro_view";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				
				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));
				
				bestProductList.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return bestProductList;
		
	}
 	
	public ProductDTO newProduct(String p_code) {
		
		ProductDTO product = new ProductDTO();
		
		String sql = "SELECT * FROM product WHERE p_code = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_code);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				product.setP_code(rs.getString("p_code"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price2(rs.getInt("p_price2"));
				product.setP_img(rs.getString("p_img"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return product;
	}

	public MemberDTO memLogin(String id, String pwd) {
		
		MemberDTO mem = new MemberDTO();
		
		String sql = "SELECT * FROM member WHERE id = ? and pwd = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				mem.setId(rs.getString("id"));
				mem.setPwd(rs.getString("pwd"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return mem;
	}
}
