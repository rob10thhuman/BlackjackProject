package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.skilldistillery.cards.common.*;

public class Hand {
	public static List<Card> hand = new ArrayList<>();
	
	public Hand() {
		
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public static void add(Card card) {
		card.add(card);
		
	}
	
	public static void printHand() {
		System.out.println(hand.size());
		}
	}

	

