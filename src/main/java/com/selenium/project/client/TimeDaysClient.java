package com.selenium.project.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.selenium.project.dto.TimeDays;


@FeignClient(name = "pontos-api", url = "${client-url}")
public interface TimeDaysClient {

	@GetMapping(value="/pontos/api/", consumes = "application/json")
    TimeDays getDateTimes();

}