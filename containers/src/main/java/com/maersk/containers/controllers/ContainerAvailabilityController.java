package com.maersk.containers.controllers;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.datastax.oss.driver.shaded.guava.common.net.HttpHeaders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maersk.containers.dto.Container;

import lombok.extern.slf4j.Slf4j;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

@RestController
@RequestMapping("api/checkAvailability")
@Slf4j
public class ContainerAvailabilityController {

	@PostMapping(path = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAvailabilityDetails(@RequestBody Container containerDetails)
			throws Exception {
		MockWebServer server = new MockWebServer();
		server.start();
		WebClient.create("https://maersk.com/api/bookings/checkAvailable");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("availableSpace", 6);
		MockResponse response = new MockResponse().setBody(new ObjectMapper().writeValueAsString(containerDetails))
				.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		server.enqueue(response);
		server.shutdown();
		JSONObject jsonObject1 = new JSONObject(Objects.requireNonNull(response.getBody()));
		JSONObject resultJson = new JSONObject();
		if (jsonObject1.get("availableSpace").equals(0)) {
			resultJson.put("available", false);
		} else {
			resultJson.put("available", true);
		}
		return new ResponseEntity<>(resultJson.toString(), HttpStatus.OK);
	}

}
