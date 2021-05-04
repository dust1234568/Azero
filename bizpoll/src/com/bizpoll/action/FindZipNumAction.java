package com.bizpoll.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.AddressDAO;
import com.bizpoll.dto.AddressDTO;

public class FindZipNumAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/findZipNum.jsp";

		String dong = request.getParameter("dong");

		if (dong != null && dong.trim().equals("") == false) {
			AddressDAO aDao = AddressDAO.getInstance();

			ArrayList<AddressDTO> addressList = aDao.selecetAddressByDong(dong);

			request.setAttribute("addressList", addressList);
		}

		ActionFoward foward = new ActionFoward();
		foward.setPath(url);
		foward.setRedirect(false);

		return foward;
	}

}
