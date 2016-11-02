package edu.nyu.cs9053.homework7.inventory;

public class Bookcover<T extends Book> implements Item{
	private Double price;
	private T book;

	public Book(Double price , T book){
		this.price = price;
		this.book = book;
	}

	public Double getPrice(){
		return price;
	}

}