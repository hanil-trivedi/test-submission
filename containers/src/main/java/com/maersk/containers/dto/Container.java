package com.maersk.containers.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Container {
	
	private String containerType;
	@NotNull
    private Integer containerSize;
    
    @NotNull
    @Range(min = 5, max = 20, message = "The Quantity needs to be be Minimum 5 and Maximum 20")
    private String origin;
    @NotNull
    @Range(min = 5, max = 20, message = "The Quantity needs to be be Minimum 5 and Maximum 20")
    private String destination;
    @NotNull
    @Range(min = 1, max = 100, message = "The Quantity needs to be be Minimum 5 and Maximum 100")
    private Integer quantity;
    ZonedDateTime timestamp;
	public Integer getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(Integer containerSize) {
		this.containerSize = containerSize;
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
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Container(String containerType, @NotNull Integer containerSize,
			@NotNull @Range(min = 5, max = 20, message = "The Quantity needs to be be Minimum 5 and Maximum 20") String origin,
			@NotNull @Range(min = 5, max = 20, message = "The Quantity needs to be be Minimum 5 and Maximum 20") String destination,
			@NotNull @Range(min = 1, max = 100, message = "The Quantity needs to be be Minimum 5 and Maximum 100") Integer quantity,
			ZonedDateTime timestamp) {
		super();
		this.containerType = containerType;
		this.containerSize = containerSize;
		this.origin = origin;
		this.destination = destination;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}
	public Container() {
		super();
	}
	
	

}
