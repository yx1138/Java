#include <iostream>
#include <stdlib.h>
#include <string>
#include <sstream>

#define MAX_HEAP_SIZE 7
#define HUMANS_TURN 1
#define COMPUTERS_TURN 2

using namespace std;
//symbol of the turn
int whos_turn;
//the toal heap number
int heapnum;
//the number of objects remain in the heap
int remain_object_num=0;
//array record the number of the objects in the heaps
int heap[MAX_HEAP_SIZE];
//the input of the heap of the human player 
int human_input_heap_num;
//the input of the number of the object he wants to take
int human_input_take_num;
int init_whos_turn_to_play(){
	int Whoisfirst=rand() % 2 +	1;
	whos_turn=Whoisfirst;
	if (Whoisfirst==1){
		std::cout << "Player human goes first " << std::endl;
	}
 	else {
  		std::cout << "Player computer goes first " << std::endl;
  	}
	return 0;
}
// initial the heap and start the game 
int initial(){
	srand(time(NULL));
  	heapnum=(rand() % 3 +	1)*2+1;
  	std::cout << "Created " << heapnum << " heaps of sizes";
 	int heapsize=0;

 	for (int index=0;index<heapnum;index++){
  		heapsize=(rand() % 3 +	1)*2+7;
  		remain_object_num=remain_object_num+heapsize;
  		heap[index]=heapsize;
  		std::cout<< " "<<heapsize;
	}
	std::cout <<std::endl;
	init_whos_turn_to_play();
}
// method of display the heaps
int print_heap(){
	for (int index=0;index<heapnum-1;index++){
  		std::cout<< heap[index]<<" ";
	}
	std::cout << heap[heapnum-1]<<std::endl;
	return 0;
}
//check the input whether its type is valid or not.
int input_check(){
	int input_mount=0;
	string word;
  	string str;// string that hold the input
  	std::cout << "Player human enter the number of objects (Y) to take from what heap (X)- in order: Y X" << std::endl;
  	getline(std::cin,str);
  	stringstream ss (str);//split the input 
  	while(ss>>word)
    {
    	input_mount++;
    	if (input_mount==1){
    		//assign the first string to human_input_take_num which means the number of the object the palyer wants to take if the string is a number or it will assign 0 which is invalid 
    		human_input_take_num=atoi(word.c_str());
    	}
    	else if (input_mount==2){
    		//assign the first string to human_input_heap_num which means the heap the palyer wants to take if the string is a number or it will assign 0 which is invalid 
    		human_input_heap_num=atoi(word.c_str());
    	}
    	else {
    		//the input contain more data than we expect ,tell the user the input is invalid
    		std::cout << "Player human that is an invalid move, try again" << std::endl;
    		input_check();
    	}
    }
	return 0;
}
// the function deal with the human input . 
int player_human_process(){
	input_check();//check the input type correctness
	
	//check the heap number is correct or not
	if(human_input_heap_num<1 || human_input_heap_num > heapnum){
	std::cout << "Player human that is an invalid move, try again" << std::endl;
	player_human_process();
	}
	else {
		// check the number of the object the player wants to take is valid or not
		if(human_input_take_num<=0 || human_input_take_num>heap[human_input_heap_num-1]){
			std::cout << "Player human that is an invalid move, try again" << std::endl;
			player_human_process();
		}
		else {
			heap[human_input_heap_num-1]=heap[human_input_heap_num-1]-human_input_take_num;
			remain_object_num=remain_object_num-human_input_take_num;
			print_heap();
		}
	}
	return 0;
}
//simple AI of the player computer.Take 1 object from the first nonempty heap 
int player_computer_process(){
	int index=0;
	for (int index=0;index<heapnum;index++){
		if(heap[index]>0){
			remain_object_num=remain_object_num-1;//reduce the number of the remaining object by 1
			heap[index]--;
			std::cout << "Player computer took "<<1<<" objects from heap "<<(index+1) << std::endl;
			break;
		}
	}
	print_heap();
	return 0;
}
//swicth the turn of the palyer .
int switch_turn(){
	whos_turn=whos_turn*-1+3;
	return 0;
}
int main()
{

  	initial();
	// the end symbol
  	while(remain_object_num>0){
  		if(whos_turn==HUMANS_TURN){
  			player_human_process();
  			switch_turn();
  		}
  		else {
  			player_computer_process();
  			switch_turn();
  		}
  			
  	}
  	// when the last one was taken ,the loser will get the turn .So the winner is the other one.
  	if(whos_turn==HUMANS_TURN){
  		std::cout << "Player computer has won"<< std::endl;
  	}else 
  		std::cout << "Player human has won"<< std::endl;

  return 0;
}