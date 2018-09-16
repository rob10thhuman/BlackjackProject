package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public static List<Card> playerHand = new ArrayList<>();

	public static void add(Card dealCard) {
		playerHand.add(dealCard);
	}

}
