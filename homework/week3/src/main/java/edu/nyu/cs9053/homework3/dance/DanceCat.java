package edu.nyu.cs9053.homework3.dance;
import java.util.Random;
import java.util.Arrays;
public class DanceCat{
	private static final int ARRAY_LENGTH=18;
	private static final String DEFAULT_NAME="Yu's Cat";
	private static final Random RANDOM = new Random();
	private final String name;
	private final DanceMove[] danceMoves;
	//return the value between 0 - 100 which controls the competitor cat's skill level
	public static int getComputerLevel(){
		int result = RANDOM.nextInt(100);
		return result;
	}
	// form a DanceMove list by two argument moves,idealMoves
	private static DanceMove[] form_DanceMove_list(String[] moves,String[] idealMoves){
		int length = moves.length;
		DanceMove[] result = new DanceMove[length];
		for(int index=0;index<length;index++){
			result[index] = new DanceMove(idealMoves[index],moves[index]);
		}
		return result;
	}
	//split the string into single letter .
	private static String[] parse_moves(String unparsedMoves){
		String[] result = new String[ARRAY_LENGTH];
		//fill the array with ""
		Arrays.fill(result,"");
		for(int index=0;index<ARRAY_LENGTH && index < unparsedMoves.length();index++){
			result[index] = unparsedMoves.substring(index,index+1);
		}
		return result;
	}
	//the first constructor
	public DanceCat(String unparsedMoves,String[] idealMoves){

		this(parse_moves(unparsedMoves),idealMoves);
	}
	//the second constructor
	public DanceCat(String[] moves,String[] idealMoves){

		this(form_DanceMove_list(moves,idealMoves));
	}
	//the third constructor
	public DanceCat(DanceMove[] danceMoves){
		this(DEFAULT_NAME,danceMoves);
	}
	//the forth constructor
	public DanceCat(String name,DanceMove[] danceMoves){
		this.name = name;
		this.danceMoves = danceMoves;
	}
	public String getName(){
		return name;
	}
	public DanceMove[] getDanceMoves(){
		return danceMoves;
	}
	//counts the number of correct moves
	public int getNumberOfCorrectMoves(){
		int length = danceMoves.length;
		int result = 0;
		for(int index=0;index<length;index++){
			if(danceMoves[index].correctMove()){
				result++;
			}
		}
		return result;
	}

}