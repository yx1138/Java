package edu.nyu.cs9053.homework4.hierarchy;

// Nutmeg is Evergreen and eudicot with a Angiosperms seed
public  class Nutmeg extends Tree{
	
	private static final Type type = Type.Evergreen;
	private static final boolean IS_EUDICOT = true;

	// the number of the seeds of the tree.
	private final int number_of_seeds;
	
	public Nutmeg(String name, int age,int number_of_seeds){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.number_of_seeds = number_of_seeds;
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
		Nutmeg that = (Nutmeg) o;
		if (number_of_seeds != that.number_of_seeds){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * number_of_seeds;
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}
}