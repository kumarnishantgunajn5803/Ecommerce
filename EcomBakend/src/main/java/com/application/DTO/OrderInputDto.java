package com.application.DTO;

import java.util.List;

public class OrderInputDto {
   
	private String fullName;
	private String fullAddress;
	private  String contactNumber;
	private  String alternateContactNumber;
	private List<OrderProductQuantity> orderProductQuantities;
	public OrderInputDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderInputDto(String fullName, String fullAddress, String contactNumber, String alternateContactNumber,
			List<OrderProductQuantity> orderProductQuantities) {
		super();
		this.fullName = fullName;
		this.fullAddress = fullAddress;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.orderProductQuantities = orderProductQuantities;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public List<OrderProductQuantity> getOrderProductQuantities() {
		return orderProductQuantities;
	}
	public void setOrderProductQuantities(List<OrderProductQuantity> orderProductQuantities) {
		this.orderProductQuantities = orderProductQuantities;
	}
	@Override
	public String toString() {
		return "OrderInputDto [fullName=" + fullName + ", fullAddress=" + fullAddress + ", contactNumber="
				+ contactNumber + ", alternateContactNumber=" + alternateContactNumber + ", orderProductQuantities="
				+ orderProductQuantities + "]";
	}
	
	
	
	
}
