package com.maersk.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maersk.containers.controllers.ContainerBookingController;
import com.maersk.containers.dto.Container;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContainerBookingController.class)
public class ContainerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	Container container;

	@Test
	public void get_allContainers_returnsOkWithListOfContainers() throws Exception {

		//Container container1 = new Container("DRY",20 , "Southampton", "Singapore", 5, null);

		String container1 = "{\"containerType\":\"DRY\",\"containerSize\":20\",\"origin\":\\\"Southampton\\\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/api/bookings/").accept(
				MediaType.APPLICATION_JSON).content(container1)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
