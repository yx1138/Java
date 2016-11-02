package edu.nyu.cs9053.homework7.inventory;

public class CameraCase<T extends Camera> implements Item{
	private Double price;
	private T camera;

	public CameraCase(Double price , T camera){
		this.price = price;
		this.camera = camera;
	}

	public Double getPrice(){
		return price;
	}

}