package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;
import java.util.Scanner;

public class BlackJackApp {
	Deck deck = new Deck();

	public static void main(String[] args) {
		BlackJackApp newGame = new BlackJackApp();
		BlackJackApp player = new BlackJackApp();
		BlackJackApp dealer = new BlackJackApp();
		Hand hand = new Hand();
		newGame.run();
	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Do you want to play a game? (Y/N) >> ");
		String choice = kb.next();

		if ((choice.equals("Y") || choice.equals("y"))) {

		deck.shuffleDeck();

		System.out.println("Dealing cards!!!");
		System.out.println("");


			System.out.print("Deck has " + deck.checkDeckSize() + "cards!");
			
			Deck.pressEnter(); 

			Player.add(deck.dealCard());
			
			System.out.println("Player has a " + Player.playerHand);
			
			Dealer.add(deck.dealCard());
			
			System.out.println("Dealer has one face down!");
			
			Player.add(deck.dealCard());
			
			System.out.println("Player has a " + Player.playerHand);
			
			Dealer.add(deck.dealCard());
			
			System.out.println("Dealer has a " + Dealer.dealerHand);
			
			
//			int handScore = 0; 
//			for (int i = 0; i < Player.playerHand.size(); i++) {
//				handScore+= Player.playerHand.(); 
//			}
			System.out.println("Player card value is " + (Player.playerHand.get(0).getRank().getValue() + Player.playerHand.get(1).getRank().getValue())); 


		} else {
			System.out.println("Okay, then have a great day!");
		}
		// deal cards
		// display them on screen
		// display total value of all cards
	}
}