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

		System.out.println("How many cards do you want? >>");
		int numberOfCards = kb.nextInt();
		// handle case of non integer or greater than 52 -- print an error message
		if (numberOfCards >= 1 && numberOfCards <= 5) {

			// should have another method for the mechanics of each game itself?

			System.out.println("");

			if (numberOfCards == 1) {
				Hand.add(deck.dealCard());
			} else if (numberOfCards == 2){
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
			} else if (numberOfCards == 3) {
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
			} else if (numberOfCards == 4) {
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
				Hand.add(deck.dealCard());
 			} else if (numberOfCards == 5) {
 				Hand.add(deck.dealCard());
 				Hand.add(deck.dealCard());
 				Hand.add(deck.dealCard());
 				Hand.add(deck.dealCard());
 				Hand.add(deck.dealCard());
 			}

			System.out.print(deck.checkDeckSize());

			System.out.println("");
			
			Hand.printHand();


		} else {
			System.out.println("You can't draw that many cards! ");
			//return to the deal?
			
		}

		} else {
			System.out.println("Okay, then have a great day!");
		}
		// deal cards
		// display them on screen
		// display total value of all cards
	}

}

//
//Deal the cards and display them on the screen. Also display the total value of all cards.