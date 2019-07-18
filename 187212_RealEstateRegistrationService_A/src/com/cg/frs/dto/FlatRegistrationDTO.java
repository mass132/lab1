package com.cg.frs.dto;

public class FlatRegistrationDTO {

	private int regId;

	private int ownerId;
	private String flatType;
	private double area;
	private double rent;
	private double deposit;

	public FlatRegistrationDTO(int ownerId, String flatType, double area, double rent, double deposit) {
		super();
		this.ownerId = ownerId;
		this.flatType = flatType;
		this.area = area;
		this.rent = rent;
		this.deposit = deposit;
	}

	@Override
	public String toString() {
		return "====================================\nFlat Registration Id : " + regId + "\nOwner Id : " + ownerId
				+ "\nFlat Type : " + flatType + "\nFlatArea : " + area + " sq. ft.\nRent Amount : Rs." + rent
				+ "\nDeposit Amount : Rs." + deposit + "\n";
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

}
