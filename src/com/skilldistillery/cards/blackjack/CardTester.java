package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

public class CardTester {

  public static void main(String[] args) {
	  Deck d = new Deck(); 
	  	
	  while(d.checkDeckSize()>0){
		  Card c = d.dealCard(); 
//		  System.out.println(c.getSuit(), c.getRank().getValue());
	  }
    
  }
}
