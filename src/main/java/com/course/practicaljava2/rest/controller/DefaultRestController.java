package com.course.practicaljava2.rest.controller;

import java.time.LocalTime;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

	private Logger log = LoggerFactory.getLogger(DefaultRestController.class);

	@GetMapping("/welcome")
	public String welcome() {
		log.info(StringUtils.join("Hello ", "This is ", "Sprifng Boot2 ", "REST API!"));
		return ("Welcome to Spring Boot");
	}

	@GetMapping("/time")
	public String time() {
		return LocalTime.now().toString();
	}

	@GetMapping("/header-one")
	public String headerByAnnotation(@RequestHeader(name = "User-agent") String headerUserAgent,
			@RequestHeader(name = "Practical-java", required = false) String headerPracticalJava) {
		var sb = new StringBuilder();
		sb.append("User-agent : " + headerUserAgent);
		sb.append(" || ");
		sb.append("Practical-java : " + headerPracticalJava);

		return sb.toString();
	}

	@GetMapping("/header-two")
	public String headerByServlet(HttpServletRequest request) {
		var sb = new StringBuilder();
		sb.append("User-agent : " + request.getHeader("User-agent"));
		sb.append(" || ");
		sb.append("Practical-java : " + request.getHeader("Practical-java"));

		return sb.toString();
	}

	@GetMapping("/header-three")
	public Map<String, String> headerByAll(@RequestHeader HttpHeaders headers) {
		return headers.toSingleValueMap();
	}

	@GetMapping("/random-error")
	public ResponseEntity<String> randomError() {
		int remainder = new Random().nextInt() % 6;
		var body = "Kibana";

		switch (remainder) {
		case 0:
			return ResponseEntity.ok().body(body);
		case 1:
		case 2:
			return ResponseEntity.badRequest().body(body);
		default:
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
		}
	}

}
