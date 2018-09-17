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
		int playerScore = Player.playerScore();
//		int dealerScore = Dealer.dealerHand.get(0).getRank().getValue() + Dealer.dealerHand.get(1).getRank().getValue();
		int dealerScore = Dealer.dealerScore();

		System.out.println("Player has a hand value of " + playerScore);
		System.out.println("");

		System.out.println("Dealer has a showing value of " + Dealer.dealerHand.get(1).getRank().getValue());

		// need to describe the gamepleay here

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
					playAgain();
				}
			}

			if (Player.playerScore() > 21) {
				System.out.println("");
				System.out.println("Player busts w/a hand value of " + Player.playerScore());
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
			if (playerStay == true && Dealer.dealerScore() <= 17) {
				Dealer.add(deck.dealCard());
				System.out.println("");
				System.out.println("Dealer hits. ");
				System.out.println("");
			}

			if (playerStay == true && Dealer.dealerScore() > 17) {
				System.out.println("Dealer stays. ");
				dealerStay = true;
			}

			if (Dealer.dealerScore() > 21) {
				System.out.println("Dealer busts. You win!");
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