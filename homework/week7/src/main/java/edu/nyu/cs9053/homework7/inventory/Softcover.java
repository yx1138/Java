package edu.nyu.cs9053.homework7.inventory;

public class Softcover extends Book{
	public Softcover(Double price,String title){
		super( price, title);
	}
	public Double getPrice(){
		return super.getPrice();
	}
}