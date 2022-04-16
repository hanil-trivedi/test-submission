package com.maersk.containers.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

	@PrimaryKey
	@Column("BOOKING_REF")
	private UUID bookingRef;
	@Column("CONTAINER_TYPE")
	private String containerType;
	@Column("ORIGIN")
	private String origin;
	@Column("DESTINATION")
	private String destination;
	@Column("QUANTITY")
	private Integer quantity;
	@Column("TIMESTAMP")
	private String timestamp;

	public BookingEntity(UUID bookingRef, String containerType, String origin, String destination, Integer quantity,
			String timestamp) {
		super();
		this.bookingRef = bookingRef;
		this.containerType = containerType;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}

	public UUID getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(UUID bookingRef) {
		this.bookingRef = bookingRef;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
