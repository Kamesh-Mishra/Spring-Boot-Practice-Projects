package com.order.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomProblemDetail {

	private String type;
	private String title;
	private int status;
	private String detail;
	private String instance;
	private String errorCode;
	private Long CustomerId;
	
}
