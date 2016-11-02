package edu.nyu.cs9053.homework7.inventory;

public class BookCase<T extends Book> implements Item{
	private Double price;
	private T[] books;

	public BookCase(Double price , T[] books){
		this.price = price;
		this.books = books;
	}

	public Double getPrice(){
		return price;
	}

}