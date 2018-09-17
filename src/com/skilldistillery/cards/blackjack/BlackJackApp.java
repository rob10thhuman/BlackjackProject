package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

import java.util.Iterator;
import java.util.Scanner;

public class BlackJackApp {
//	Deck deck = new Deck();

	public static void main(String[] args) {
		BlackJackApp newGame = new BlackJackApp();
		BlackJackApp player = new BlackJackApp();
		BlackJackApp dealer = new BlackJackApp();
		Hand hand = new Hand();
		int playerScore = 0;
		int dealerScore = 0;
		newGame.warGames();
	}

	public void warGames() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Do you want to play a game? (Y/N) >> ");
		String choice = kb.next();

		if ((choice.equals("Y") || choice.equals("y"))) {
			run();
		} else {
			System.out.println("Okay, then have a great day!");
		}

	}

	public void run() {
		Scanner kb = new Scanner(System.in);

		Deck deck = new Deck();

		// need to clear the decks

		System.out.println("Deck has " + deck.checkDeckSize() + " cards!");

		deck.shuffleDeck();

		System.out.println("Dealing cards!!!");

		System.out.println("");

		Deck.pressEnter();

		Player.add(deck.dealCard());

		Dealer.add(deck.dealCard());

		Player.add(deck.dealCard());

		Dealer.add(deck.dealCard());

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Player has a " + Player.playerHand);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Dealer has one card facedown and a  " + Dealer.dealerHand.get(1));
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");

		Deck.pressEnter();

//		*************** This is where the game play begins 

//		int playerScore = Player.playerHand.get(0).getRank().getValue() + Player.playerHand.get(1).getRank().getValue();
		// I am so proud of this code because it was me figuring out how to get to those values 
		// I can't delete it. 
		int playerScore = Player.playerScore();
//		int dealerScore = Dealer.dealerHand.get(0).getRank().getValue() + Dealer.dealerHand.get(1).getRank().getValue();
		int dealerScore = Dealer.dealerScore();

		System.out.println("Player has a hand value of " + playerScore);
		System.out.println("");

		System.out.println("Dealer has a showing value of " + Dealer.dealerHand.get(1).getRank().getValue());

		boolean dealerStay = false;
		boolean playerStay = false;
		boolean push = false;

		while (!playerStay || !dealerStay) {

			System.out.println("\nWould you like to Hit(H) or Stay(S)? ");
			String userChoice = kb.next();

			if (userChoice.equalsIgnoreCase("h")) {
				Player.add(deck.dealCard());
				System.out.println("Player hand is " + Player.playerHand);
				System.out.println("");
				System.out.println("Player hand value is " + Player.playerScore());
				System.out.println("");
				if (Player.playerScore() == 21 && Dealer.dealerScore() < 21) {
					System.out.println("You win!");
					System.out.println("Dealer's hand value was " + Dealer.dealerScore());
					playAgain();
				}
			}

			if (Player.playerScore() > 21) {
				System.out.println("");
				System.out.println("Player busts w/a hand value of " + Player.playerScore());
				System.out.println("");
				System.out.println("Dealer's hand had a value of " + Dealer.dealerScore());
				playAgain();
			}

			if (userChoice.equalsIgnoreCase("s")) {
				playerStay = true;
				System.out.println("Player hand value is " + Player.playerScore());
			}

			if (Dealer.dealerScore() < 17) {
				Dealer.add(deck.dealCard());
				System.out.println("");
				System.out.println("Dealer hits. ");
				System.out.println("");
			}

			//added the condition below to try to account for a second chance to hit
//			if (Player.playerScore() < 21) {
//				System.out.println("\nWould you like to Hit(H) or Stay(S)? ");
//				String userChoice2 = kb.next();
//
//				if (userChoice2.equalsIgnoreCase("h")) {
//					Player.add(deck.dealCard());
//					System.out.println("Player hand is " + Player.playerHand);
//					System.out.println("");
//					System.out.println("Player hand value is " + Player.playerScore());
//					System.out.println("");
//					if (Player.playerScore() == 21 && Dealer.dealerScore() < 21) {
//						System.out.println("You win!");
//						System.out.println("Dealer's hand was " + Dealer.dealerHand);
//						System.out.println("Dealer's hand value was " + Dealer.dealerScore());
//						playAgain();
//					}
//				}
//			}
			
			if (playerStay == true && Dealer.dealerScore() <= 17) {
				Dealer.add(deck.dealCard());
				System.out.println("");
				System.out.println("Dealer hits. ");
				System.out.println(""); 
//				for (int i = 1; i < Dealer.dealerHand.size(); i++) {
//				System.out.println(Dealer.dealerHand.get(i).getRank());  
//			}
//				System.out.println("Dealer is showing ");
			}

			if (playerStay == true && Dealer.dealerScore() > 17) {
				System.out.println("Dealer stays. ");
				System.out.println("");
				dealerStay = true;
			}

			if (Dealer.dealerScore() > 21) {
				System.out.println("Dealer busts w/a hand value of " + Dealer.dealerScore() + ". You win!");
				System.out.println("Dealer hand was " + Dealer.dealerHand);
				playAgain();
			}
			if (Player.playerScore() == Dealer.dealerScore()) {
				push = true;
				System.out.println("Push!");
				playAgain();
			}
			if (!playerStay && !dealerStay) {
				if (Player.playerScore() > Dealer.dealerScore()) {
					System.out.println("Player wins w/a hand value of " + Player.playerScore());
					playAgain();
				} else {
					System.out.println("Dealer wins w/a hand value of " + Dealer.dealerScore());
					playAgain();
				}
			}
		}
	}

	public void playAgain() {
		Scanner kb2 = new Scanner(System.in);
		System.out.println("");
		System.out.println("Do you want to play again? Y/N >> ");
		String choice = kb2.next();
		if ((choice.equals("Y") || choice.equals("y"))) {
			Player.playerHand.clear();
			Dealer.dealerHand.clear();
			run();
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}

}