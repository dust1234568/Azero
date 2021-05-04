package com.bizpoll.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.ProductDAO;
import com.bizpoll.dto.ProductDTO;

public class IndexAction implements Action{

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 처리하고 보내줘야할 주소, 호출.  메인메소드와 비슷
		String uri = "index.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance(); // 싱글턴 패턴 방식
		
		ArrayList<ProductDTO> newProductList = pDao.listNewProduct();
		ArrayList<ProductDTO> bestProductList = pDao.listBestProduct();
		
		request.setAttribute("newProductList", newProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(uri);
		forward.setRedirect(false);
		
		return forward;
	}
	
	

}
