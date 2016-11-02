package edu.nyu.cs9053.homework7.inventory;

public class Electronic implements Item{
	private Double price;

	public Electronic(Double price){
		this.price = price;
	}

	public Double getPrice(){
		return price;
	}

}