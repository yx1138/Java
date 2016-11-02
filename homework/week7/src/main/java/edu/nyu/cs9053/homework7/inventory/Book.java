package edu.nyu.cs9053.homework7.inventory;

public class Book implements Item{
	private Double price;
	private String title;

	public Book(Double price , String title){
		this.price = price;
		this.title = title;
	}

	public Double getPrice(){
		return price;
	}

}