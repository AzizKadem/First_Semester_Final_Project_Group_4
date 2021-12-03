package model;

public class Customer {
	
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	private String zipCode;
	private int discount;
	
	public Customer(String name, String phoneNumber, String address, String city, String zipCode, int discount) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.discount = discount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
