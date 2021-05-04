package com.dust.dto;

import java.sql.Date;

public class MemberDTO {
	
	private String id;
	private String pwd;
	private String repwd;
	private String name;
	private String email;
	private String useyn;
	private Date sysDate;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String id, String pwd, String repwd, String name, String email, String useyn, Date sysDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.repwd = repwd;
		this.name = name;
		this.email = email;
		this.useyn = useyn;
		this.sysDate = sysDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", repwd=" + repwd + ", name=" + name + ", email=" + email
				+ ", useyn=" + useyn + ", sysDate=" + sysDate + "]";
	}

}
