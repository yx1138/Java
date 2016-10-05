package edu.nyu.cs9053.homework4.hierarchy;

// Gymnosperm is a seed not enclosed.
public class Gymnosperm extends Seed{
	private static final boolean SEED_ENCLOSED = false;
	public Gymnosperm(){
		super(SEED_ENCLOSED);
	}
	public boolean equals(Object o){
		if (this == o){
			return true;
		}
		if(o == null || getClass() != o.getClass()){
			return false;
		}
		if ( !super.equals(o)){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		return result;
	}
}