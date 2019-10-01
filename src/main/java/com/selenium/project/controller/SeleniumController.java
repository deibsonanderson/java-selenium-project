package com.selenium.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selenium.project.service.FormSeleniumService;
import com.selenium.project.service.TimeSeleniumService;

@RestController
public class SeleniumController {

	@Autowired
	private FormSeleniumService formService;

	@Autowired
	private TimeSeleniumService timeService;

	private static final String MSG = "processed...";

	
	@GetMapping(path = "/form", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> form() {
		formService.process();
		return ResponseEntity.status(HttpStatus.OK).body(MSG);
	}

	@GetMapping(path = "/time", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> time() {
		timeService.process();
		return ResponseEntity.status(HttpStatus.OK).body(MSG);
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<String> html() {
		StringBuilder html = new StringBuilder();
		html.append("<html><body>");
		html.append("<a href='http://localhost:8080/form'>example selenium form</a>");
		html.append("<br/><br/>");
		html.append("<a href='http://localhost:8080/time'>example selenium time</a>");
		html.append("</body></html>");
		return ResponseEntity.status(HttpStatus.OK).body(html.toString());
	}


}
