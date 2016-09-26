package edu.nyu.cs9053.homework3.dance;


public class DanceMove{
	private final String idealMove;
	private final String userMove;

	public DanceMove(String idealMove,String userMove){
		this.idealMove = idealMove;
		this.userMove = userMove;
		
	}
	public String getIdealMove(){
		return idealMove;
	}
	public String getUserMove(){
		return userMove;
	}
	public boolean correctMove(){
		return idealMove.equals(userMove);
	}
}