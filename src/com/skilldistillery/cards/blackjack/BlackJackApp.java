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

		boolean playerStand = false;
		boolean dealerStand = false;
		String answer;

		while (!playerStand || !dealerStand) {
			if (!playerStand) {
				System.out.println("Player, do you want to hit (H) or stand (S)? >>");
				String answer1 = kb.next();
				System.out.println("");

//				if (answer1.compareToIgnoreCase("H") == 0) {
				if (answer1.equals("H") || answer1.equals("h")) {
//					playerStand = !Player.playerHand.add(deck.dealCard());
					Player.playerHand.add(deck.dealCard());
					System.out.println("");
					System.out.println("Player hand is " + Player.playerHand);
					System.out.println("Player hand value is " + Player.playerScore());
					System.out.println("");
						if (Player.playerScore() > 21 || Dealer.dealerScore() < 21) {
							System.out.println("");
							System.out.println("Player busts! Dealer wins! ");
							playAgain();
						}
				} else {
					playerStand = true;
				}
			}
			if (!dealerStand) {
				if (Dealer.dealerScore() < 17) {
					System.out.println("");
					System.out.println("Dealer hits! ");
					System.out.println("");
					dealerStand = !Dealer.dealerHand.add(deck.dealCard());
//					Dealer.dealerHand.add(deck.dealCard());
					System.out.println("");
					System.out.println("Dealer hand is " + Dealer.dealerHand);
					System.out.println("");
				} else {
					System.out.println("");
					System.out.println("Dealer stays. ");
					System.out.println("Dealer hand is " + Dealer.dealerHand);
					System.out.println("");
					dealerStand = true;
				}
			}
		}
		
		int x = Player.playerScore();
		int y = Dealer.dealerScore();
		
		if (x > y && x <=21 || y > 21) {
			System.out.println("You win!");
		} else {
			System.out.println("Dealer wins!");
			playAgain(); 
		}

	}

//		if (playerScore == 21 && dealerScore == 21) {
//			System.out.println("Both player and dealer have 21! (What are the odds!");
//			System.out.println("Game is a push!");
//
//			playAgain();
//		}
//
//		if (playerScore == 21) {
//			System.out.println("Player has 21! You win!");
//			playAgain();
//		}
//
//		if (dealerScore == 21) {
//			System.out.println("Dealer has 21! You lose!");
//			playAgain();
//		}
//
//		System.out.println("");

//		while (playerScore != 21 && dealerScore != 21) {

//		System.out.println("Neither player has 21.");
//
//		System.out.println("");
//
//		System.out.println("Player, do you want to hit (H) or stand (S)? >>");
//		String action = kb.next();
//
//		if ((action.equals("h") || action.equals("H"))) {
//
//			Player.add(deck.dealCard());
//
//			System.out.println("Player is dealt a " + Player.playerHand.get(2));
//
//			System.out.println("");
//
//			System.out.println("Player has " + Player.playerHand.size() + " cards.");
//
//			Deck.pressEnter();
//
//			System.out.println("");
//			System.out.println("Player has a hand value of " + Player.playerScore());
//			System.out.println("");
//
//			if (playerScore == 21 && dealerScore == 21) {
//				System.out.println("Both player and dealer have 21! (What are the odds!");
//				System.out.println("Game is a push!");
//
//				playAgain();
//			}
//
//			if (playerScore == 21) {
//				System.out.println("Player has 21! You win!");
//				playAgain();
//			}
//
//			if (dealerScore == 21) {
//				System.out.println("Dealer has 21! You lose!");
//				playAgain();
//			}
//
//			if (playerScore > 21) {
//				System.out.println("Player busts :( ");
//				playAgain();
//			}
//		}
//
//		if (dealerScore > 17) {
//			Dealer.add(deck.dealCard());
//
//			System.out.println("Dealer has a hand value of " + dealerScore);
//			System.out.println("");
//
//			if (dealerScore == 21) {
//				System.out.println("Dealer wins!");
//				playAgain();
//			}
//			if (dealerScore > 21) {
//				System.out.println("Dealer busts! Player wins!");
//				playAgain();
//			}
//		} else {
//			System.out.println("Dealer stands! ");
//		}
//
//		System.out.println("Player, do you want to hit (H) or stand (S)? >>");
//		String action2 = kb.next();
//
//		if ((action2.equals("h") || action2.equals("H"))) {
//
//			Player.add(deck.dealCard());
//
//			System.out.println("Player is dealt a " + Player.playerHand.get(2));
//
//			Deck.pressEnter();
//
//			System.out.println("Player has a hand value of " + playerScore);
//			System.out.println("");
//
//			if (playerScore == 21 && dealerScore == 21) {
//				System.out.println("Both player and dealer have 21! (What are the odds!");
//				System.out.println("Game is a push!");
//
//				playAgain();
//			}
//
//			if (playerScore == 21) {
//				System.out.println("Player has 21! You win!");
//				playAgain();
//			}
//
//			if (dealerScore == 21) {
//				System.out.println("Dealer has 21! You lose!");
//				playAgain();
//			}
//
//			if (playerScore > 21) {
//				System.out.println("Player busts :( ");
//				playAgain();
//			}
//		}
//
//		if (dealerScore < 17) {
//
//			System.out.println("Dealer hits!");
//			System.out.println("");
//
//			Dealer.add(deck.dealCard());
//
//			System.out.println("");
//
//			if (dealerScore == 21) {
//				System.out.println("Dealer wins!");
//				playAgain();
//			}
//			if (dealerScore > 21) {
//				System.out.println("Dealer busts! Player wins!");
//				playAgain();
//			}
//			if (action2.equals("s") || action2.equals("S") && dealerScore > 17) {
	// scenario here for evaluating the hands and declaring a winner if both are
	// standing
//			}
//		} else {
//			System.out.println("Dealer stands! ");
//		}
//	}

//	}

	public void playAgain() {
		Scanner kb2 = new Scanner(System.in);
		System.out.println("");
		System.out.println("Do you want to play again? Y/N >> ");
		String choice = kb2.next();
		if ((choice.equals("Y") || choice.equals("y"))) {
//			Player.playerHand = null;
//			Dealer.dealerHand = null;
			run();
		} else {
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}

}