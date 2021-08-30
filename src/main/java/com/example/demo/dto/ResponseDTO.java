package com.example.demo.dto;

import java.io.Serializable;


public class ResponseDTO<T> implements Serializable{

	private static final long serialVersionUID = 7025993368158557934L;
		
	private T data;
	private int Cve_Error;
	private String Cve_message;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getCve_Error() {
		return Cve_Error;
	}
	public void setCve_Error(int cve_Error) {
		this.Cve_Error = cve_Error;
	}
	public String getCve_message() {
		return Cve_message;
	}
	public void setCve_message(String cve_message) {
		this.Cve_message = cve_message;
	}

}
