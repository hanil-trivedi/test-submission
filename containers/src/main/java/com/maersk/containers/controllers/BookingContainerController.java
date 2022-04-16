package com.maersk.containers.controllers;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.containers.dto.Container;
import com.maersk.containers.entity.BookingEntity;
import com.maersk.containers.repository.ContainerBookingRepository;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("api/book")
@Slf4j
public class BookingContainerController {
	
	 @Autowired
	    ContainerBookingRepository bookRepository;

	    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> bookContainer(@RequestBody Container containerDetails) throws IOException, JSONException {
	        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz").format(ZonedDateTime.now());
	        BookingEntity bookings = bookRepository.save(new BookingEntity(UUID.randomUUID(), containerDetails.getContainerType() , containerDetails.getOrigin(), containerDetails.getDestination(), containerDetails.getQuantity(), timeStamp));
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("“bookingRef”", bookings.getBookingRef());
	        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
	    }

}
