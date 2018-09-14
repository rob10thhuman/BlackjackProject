package com.skilldistillery.cards.common;

public enum Rank {
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), 
	SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
	JACK(10), QUEEN(10), KING(10),
	ACE(11); 
	//creates enums with an integer value 
	//important to recall these can be comparedTo
	
	private int value;

	private Rank(int value) {
		this.value = value;
	} //constructor 

	public int getValue() {
		return value;
	} //getter for getting this rank 

	
}
