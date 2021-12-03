package model;

public class Customer {
	
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	private String zipCode;
	private int discount;
	
	/**
	 * @param name
	 * @param phoneNumber
	 * @param address
	 * @param city
	 * @param zipCode
	 * @param discount
	 */
	public Customer(String name, String phoneNumber, String address, String city, String zipCode, int discount) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.discount = discount;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return
	 */
	public int getDiscount() {
		return discount;
	}
	/**
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
