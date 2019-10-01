package com.selenium.project.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TimeDays implements Serializable  {

	private String timeCurrent;
	private String mount;
	private String year;
	private List<Day> days;

}
