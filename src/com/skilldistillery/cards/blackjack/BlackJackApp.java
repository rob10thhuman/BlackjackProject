package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;
import java.util.Scanner;

public class BlackJackApp {
	Deck deck = new Deck();
	
	public static void main(String[] args) {
		BlackJackApp dealer = new BlackJackApp();
		dealer.run();
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
		while (numberOfCards >= 1 && numberOfCards <= 52) {

			// should have another method for the mechanics of each game itself?


			System.out.println("");

			System.out.print(deck.checkDeckSize());

//			deck.dealCard();

			System.out.println("");

//			System.out.print(deck.getDeck());

		}

		} else {
			System.out.println("Okay, then have a great day!");
		}
		// deal cards
		// display them on screen
		// display total value of all cards
	}

}

//Write a program to ask a user how many cards they want.
//
//Handle the case where users enter a non-integer or a number greater than 52: print an error message.
//Deal the cards and display them on the screen. Also display the total value of all cards.