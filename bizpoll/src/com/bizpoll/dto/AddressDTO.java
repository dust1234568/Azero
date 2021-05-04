package com.bizpoll.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String zipNum;
	private String sido;
	private String gugun;
	private String dong;
	private String zipCode;
	private String bungi;

	public AddressDTO() {
		super();
	}

	public AddressDTO(String zipNum, String sido, String gugun, String dong, String zipCode, String bungi) {
		super();
		this.zipNum = zipNum;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.zipCode = zipCode;
		this.bungi = bungi;
	}

	public String getZipNum() {
		return zipNum;
	}

	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBungi() {
		return bungi;
	}

	public void setBungi(String bungi) {
		this.bungi = bungi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AddressDTO [zipNum=" + zipNum + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", zipCode="
				+ zipCode + ", bungi=" + bungi + "]";
	}

}
