package edu.nyu.cs9053.homework7.inventory;

public class DigitalCameraCase<T extends DigitalCamera> implements Item{
	private Double price;
	private T digitalcamera;

	public CameraCase(Double price , T digitalcamera){
		this.price = price;
		this.digitalcamera = digitalcamera;
	}

	public Double getPrice(){
		return price;
	}

}