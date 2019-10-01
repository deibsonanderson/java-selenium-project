package com.selenium.project.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Day implements Serializable {
	
	private Integer day;
	private String name;
	private String date;
	private String fistHour;
	private String secondHour;
	private String thirdHour;
	private String fourtHour;
	private boolean weekEnd;

}
