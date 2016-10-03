package edu.nyu.cs9053.homework4.hierarchy;

// Gymnosperm is a seed not enclosed.
public class Gymnosperm extends Seed{
	private static final boolean SEED_ENCLOSED = false;
	public Gymnosperm(){
		super(SEED_ENCLOSED);
	}
}