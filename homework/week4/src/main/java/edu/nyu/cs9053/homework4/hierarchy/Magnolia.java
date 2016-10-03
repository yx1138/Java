package edu.nyu.cs9053.homework4.hierarchy;

//Magnolia is Deciduous and eudiduous with a Angiosperms seed
public  class Magnolia extends Tree{
	
	private static final Type type = Type.Deciduous;
	private static final boolean IS_EUDICOT = true;

	// the number of the flowers
	private final int number_of_flowers ;
	public Magnolia(String name, int age,int number_of_flowers){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.number_of_flowers = number_of_flowers;
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
		Magnolia that = (Magnolia) o;
		if (number_of_flowers !=that.number_of_flowers ){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * number_of_flowers;
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}

}