package edu.nyu.cs9053.homework7.inventory;

public class ComputerDesk<T extends Computer> implements Item{
	private Double price;
	private T computer;

	public ComputerDesk(Double price , T computer){
		this.price = price;
		this.computer = computer;
	}

	public Double getPrice(){
		return price;
	}

}