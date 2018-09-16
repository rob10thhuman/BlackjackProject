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

			System.out.println("Deck has " + deck.checkDeckSize() + " cards!");

			deck.shuffleDeck();

			System.out.println("Dealing cards!!!");
			
			System.out.println("");

			Deck.pressEnter();

			Player.add(deck.dealCard());

			System.out.println("Player has a " + Player.playerHand);
			System.out.println("");

			Dealer.add(deck.dealCard());

			System.out.println("Dealer has one face down!");
			System.out.println("");

			Player.add(deck.dealCard());

			System.out.println("Player has a " + Player.playerHand);
			System.out.println("");

			Dealer.add(deck.dealCard());

			System.out.println("Dealer has one card facedown and a  " + Dealer.dealerHand.get(1));
			System.out.println("");

			int playerScore = Player.playerHand.get(0).getRank().getValue()
					+ Player.playerHand.get(1).getRank().getValue();
			int dealerScore = Dealer.dealerHand.get(0).getRank().getValue()
					+ Dealer.dealerHand.get(1).getRank().getValue();

			System.out.println("Player has a hand value of " + playerScore);
			System.out.println("");
			
			System.out.println("Dealer has a showing value of " + Dealer.dealerHand.get(1).getRank().getValue());
			
			if (playerScore == 21 && dealerScore ==21) {
				System.out.println("Both player and dealer have 21! (What are the odds!");
				System.out.println("Game is a push!");
//				System.out.println("Do you want to play again? Y/N >> ");
//				String choice2 = kb.next();
//					if ((choice2.equals("Y") || choice2.equals("y"))) {
//					run(); 
//					} else {
//						System.out.println("Goodbye!");
//						System.exit(0);
//					}
				playAgain(); 
			} else if (playerScore == 21) {
				System.out.println("Player has 21! You win!");
			} else if (dealerScore == 21){
				System.out.println("Dealer has 21! You lose!");
			}
			
			System.out.println("Neither player has 21.");
			
			System.out.println("");
			
			System.out.println("Player, do you want to hit (H) or stand (S)? >>");
			String action = kb.next(); 
			
			if ((action.equals("h") || choice.equals("H"))) {
				Player.add(deck.dealCard());
				playerScore = Player.playerHand.get(0).getRank().getValue()
						+ Player.playerHand.get(1).getRank().getValue();
				System.out.println("Player has a hand value of " + playerScore);
				System.out.println("");
					if (playerScore > 21) {
						System.out.println("Player busts :( ");
						playAgain();
//						System.out.println("Do you want to play again? >>");
//						String choice3 = kb.next();
//							if ((choice3.equals("Y") || choice3.equals("y"))) {
//								run(); 
//							} else {
//								System.out.println("Goodbye!");
//								System.exit(0);
//							}
					} 
			} else {
				
				if (dealerScore == 21) {
					System.out.println("Dealer wins!");
					
				}
			}

		} else {
			System.out.println("Okay, then have a great day!");
		}
	}
	
	public void playAgain () {
		Scanner kb2 = new Scanner(System.in); 
		System.out.println("Do you want to play again? Y/N >> ");
		String choice = kb2.next();
			if ((choice.equals("Y") || choice.equals("y"))) {
			run(); 
			} else {
				System.out.println("Goodbye!");
				System.exit(0);
			}
	}
}