package edu.nyu.cs9053.homework5;


public class DoublyDecayTimeTraveler extends BasicTimeTraveler{
	public DoublyDecayTimeTraveler (String name){
		super(name);
	}
	@Override public double decayCalculator(double leapedTime){
		return super.getRemainingYearsOfTravel()-leapedTime*2;
	}
}