package edu.nyu.cs9053.homework4.hierarchy;

//Larch is a sub-type of Conifer and it is  Deciduous 
public  class Larch extends Conifer{
	
	private static final Type type = Type.Deciduous;

	// the location of the tree
	private final String location ;
	public Larch(String name, int age,String location){
		super(name,type,age);
		this.location = location;
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
		Larch that = (Larch) o;
		if (location != null ? !location.equals(that.location) : that.location != null){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * location.hashCode();
		return result;
	}

}