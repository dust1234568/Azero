package com.dust.dto;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class NoticeDTO {

	private int noticeNo;
	private String gubun;
	private String subject;
	private DATE indate;
}
