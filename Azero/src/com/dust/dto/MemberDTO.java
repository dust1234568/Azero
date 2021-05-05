package com.dust.dto;

import java.sql.Date;

import lombok.Data;

//@AllArgsConstructor
//@Getter
//@Setter
@Data
public class MemberDTO {

	private String id;
	private String pwd;
	private String repwd;
	private String name;
	private String email;
	private String useyn;
	private Date sysDate;

}
