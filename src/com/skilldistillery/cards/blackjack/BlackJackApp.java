package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

import java.util.Iterator;
import java.util.Scanner;

public class BlackJackApp {

	public static void main(String[] args) {
		BlackJackApp newGame = new BlackJackApp();
		newGame.warGames();
	}

	public void warGames() {
		Scanner kb = new Scanner(System.in);
		playGame();
		System.out.println("Do you want to play a game? (Y/N) >> ");
		String choice = kb.next();

		if ((choice.equals("Y") || choice.equals("y"))) {
			run();
		} else {
			System.out.println("Okay, then have a great day!");
		}

	}

	Player player = new Player();
	Dealer dealer = new Dealer();

	public void run() {
		Scanner kb = new Scanner(System.in);
		Deck deck = new Deck();
		player.getPlayerHand().removeAll(player.getPlayerHand());
		dealer.getDealerHand().removeAll(dealer.getDealerHand());

		System.out.println("Deck has " + deck.checkDeckSize() + " cards!");

		deck.shuffleDeck();

		System.out.println("Dealing cards!!!");

		Deck.pressEnter();

		player.add(deck.dealCard());
		dealer.add(deck.dealCard());
		player.add(deck.dealCard());
		dealer.add(deck.dealCard());

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Player has a " + player.getPlayerHand());
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Dealer has one card facedown and a  " + dealer.getDealerHand().get(1));
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");

		Deck.pressEnter();

//		*************** This is where the game play begins 

		System.out.println("Player has a hand value of " + player.playerScore());
		// playerHand
		System.out.println("");

		System.out.println("Dealer has a showing value of " + dealer.getDealerHand().get(1).getRank().getValue());
		showDealerHand();
		System.out.println("");

		boolean dealerStay = false;
		boolean playerStay = false;

		System.out.println("\nWould you like to Hit(H) or Stay(S)? ");
		String userChoice = kb.next();

		while (!playerStay || !dealerStay) {

			while (userChoice.equalsIgnoreCase("h")) {
				if (userChoice.equalsIgnoreCase("s")) {
					playerStay = true;
					System.out.println("Player hand value is " + player.playerScore());
					// player is showing
					break;
				}
				player.add(deck.dealCard());
				System.out.println("Player hand is " + player.getPlayerHand());
				System.out.println("Player hand value is " + player.playerScore());
				System.out.println("");
				if (player.playerScore() == 21 && dealer.dealerScore() < 21) {
					System.out.println("21!!!!!! You win!");
					playersHands();
					playAgain();
				}
				if (player.playerScore() > 21) {
					System.out.println("");
					System.out.println("Player busts w/a hand value of " + player.playerScore());
					System.out.println("Dealer wins!");
					System.out.println("");
					playersHands();
					playAgain();
				}
				System.out.println("---------------------------------------");
				System.out.println("\nWould you like to Hit(H) or Stay(S)? ");
				System.out.println("---------------------------------------");
				userChoice = kb.next();
			}

			if (dealer.dealerScore() <= 17) {
				dealer.add(deck.dealCard());
				System.out.println("");
				System.out.println("Dealer hits. ");
				showDealerHand();
				System.out.println("");
			} else {
				System.out.println("Dealer stays. ");
				showDealerHand();
				System.out.println("");
				dealerStay = true;
			}

			if (dealer.dealerScore() > 21) {
				System.out.println("Dealer busts w/a hand value of " + dealer.dealerScore() + ". You win!");
				playersHands();
				playAgain();
			}
			if (player.playerScore() == dealer.dealerScore()) {
				System.out.println("Push!");
				playersHands();
				playAgain();
			}

			if (playerStay == true || dealerStay == true) {

				if (player.playerScore() > dealer.dealerScore()) {
					System.out.println("Player wins!");
					playersHands();
//					System.out.println("Player wins w/a hand value of " + player.playerScore());
//					System.out.println("Dealer hand was " + dealer.getDealerHand());
//					System.out.println("Dealer hand value of " + dealer.dealerScore());
					playAgain();
				} else {
					System.out.println("Dealer wins!");
					playersHands();
//					System.out.println("Dealer wins w/a hand value of " + dealer.dealerScore());
//					System.out.println("Dealer hand was " + dealer.getDealerHand());
//					System.out.println("Player hand value was " + player.playerScore());
//					System.out.println("Player hand was " + player.getPlayerHand());
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
			run();
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}

	public void playersHands() {
		// can't access outside the run method right now
		// fixed - had to move the player/dealer instantiation outside the method run()
		// doing so caused me to have to reconsider the resets of the hands
		// moving the deck outside causes it to not be a new deck
		// ? at what point does the deck per the rules have to be renewed?
		// might be able to do some kind of "new deck if x #" ?
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("FINAL HANDS: ");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Dealer hand value was " + dealer.dealerScore());
		System.out.println("Dealer hand was " + dealer.getDealerHand());
		System.out.println("Player hand value was " + player.playerScore());
		System.out.println("Player hand was " + player.getPlayerHand());
		System.out.println("------------------------------------------------------------------------------");

	}

	public void showDealerHand() {
		for (int i = 1; i < dealer.getDealerHand().size(); i++) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Dealer is showing: " + dealer.getDealerHand().get(i));
			System.out.println("------------------------------------------------------------------------------");
		}
	}

	public void playGame() {
		System.out.println("----------------------------");
		System.out.println("-                          -");
		System.out.println("-   ----          ----     -");
		System.out.println("-          ----            -");
		System.out.println("-                          -");
		System.out.println("-   --              --     -");
		System.out.println("-     --------------       -");
		System.out.println("----------------------------");
	}

}