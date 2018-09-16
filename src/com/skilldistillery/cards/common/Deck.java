package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
//	Deck deck = new Deck();
	private List<Card> deck = new ArrayList<>();
	// this is supposed to be a constructor to initialize the cards

	public Deck() {
		for (Suit suit : Suit.values()) {

			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public int checkDeckSize() {
		// check deck size
		// return number of cards
		return deck.size();
	}

	public Card dealCard() {
		// removes one card from the deck
		return deck.remove(0);
	}

	public void shuffleDeck() {
		// shuffle the deck
		System.out.println("Shuffling the deck!");
		System.out.println("(no one likes a cheat!)");
		pressEnter();
		Collections.shuffle(deck);

	}
	
	public static void pressEnter() {
		System.out.println("");
		System.out.println("Press enter to continue...");
		System.out.println("");
		try {
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//We will be simulating a deck of cards.
//
//Create a class Deck. It will hold a List of Cards.
//In the constructor, initialize the List with all 52 cards.
//Add a method checkDeckSize which returns the number of cards still in the deck.
//Add a method dealCard that removes a Card from the deck.
//Add a method shuffle to shuffle the deck.