package io.payrollmanagement.dto;

import lombok.Data;

@Data
public class Request {
	
	private String did;
	private String department_name;
	private String department_HOD;
	private String department_timeStamp;
	private int deleted;
	
}
