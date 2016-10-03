package edu.nyu.cs9053.homework4.hierarchy;


//Camphor is Evergreen and eudicot with a Angiosperms seed
public  class Camphor extends Tree{
	
	private static final Type type = Type.Evergreen;
	private static final boolean IS_EUDICOT = true;

	//the diamter of the tree
	private final double diameter;
	public Camphor(String name, int age,double diameter){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.diameter = diameter;
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
		Camphor that = (Camphor) o;
		if (diameter != that.diameter){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		Double box_diameter = diameter;
		result = result + 7 * box_diameter.hashCode();
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}
}