package com.dust.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpLoad {

	// 신규 회원 생성, 회원 수정 에서 호출
	public static Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) {

		String savePath = "/Users/dust/Desktop/Azero/Azero/WebContent/img/member";
		Map<String, String> boardMap = new HashMap<String, String>();

		String encodeing = "UTF-8";

		File currentDirPath = new File(savePath);

		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setRepository(currentDirPath);

		factory.setSizeThreshold(10 * 1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List<FileItem> items = upload.parseRequest(request);

			for (int i = 0; i < items.size(); i++) {

				FileItem fileItem = (FileItem) items.get(i);

				System.out.println("fileUpLoad.savePath : " + savePath);
				if (fileItem.isFormField()) {

					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encodeing));
					boardMap.put(fileItem.getFieldName(), fileItem.getString(encodeing));
				} else {
					System.out.println("파라미터명 : " + fileItem.getFieldName());
					System.out.println("파일 크기 : " + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");

						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}

						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명 : " + fileName);

						boardMap.put(fileItem.getFieldName(), fileName);

						File uploadFile = new File(currentDirPath + "/temp/" + fileName);
						System.out.println("uploadFile : " + uploadFile);
						fileItem.write(uploadFile);
					}
				}
			}

			boardMap.put("savePath", savePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardMap;
	}
}
