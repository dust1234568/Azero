package com.dust.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
//@Getter
//@Setter
@Data
@AllArgsConstructor
public class MemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pwd;
	private String repwd;
	private String email;
	private String useyn;
	private Date sysDate;
	private String fileName;

	public MemberDTO() {
		super();
	}

}
