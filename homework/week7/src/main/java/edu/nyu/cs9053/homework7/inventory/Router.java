package edu.nyu.cs9053.homework7.inventory;

public class Router<T extends Computer> implements Item{
	private Double price;
	private T[] computers;

	public Router(Double price , T[] computers){
		this.price = price;
		this.computers = computers;
	}

	public Double getPrice(){
		return price;
	}

}