package edu.nyu.cs9053.homework4.hierarchy;

// Palm is Deciduous and monocot with an Angiosperms seed 
public  class Palm extends Tree{
	
	private static final Type type = Type.Deciduous;
	private static final boolean IS_EUDICOT = false;

	// the description of the tree
	private final String description ;
	
	public Palm(String name, int age,String description){
		super(name,type,age,new Angiosperms(IS_EUDICOT));
		this.description = description;
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
		Palm that = (Palm) o;
		if (description != null ? !description.equals(that.description) : that.description != null){
			return false;
		}
		return true;
	}
	public  int hashCode(){
		int result = super.hashCode();
		result = result + 7 * description.hashCode();
		return result;
	}
	public boolean isEudicot(){
		return IS_EUDICOT;
	}
}