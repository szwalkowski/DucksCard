package pl.boardgame.duckburg.deck.cards;

import pl.boardgame.duckburg.deck.cards.types.CardFunctionType;
import pl.boardgame.duckburg.deck.cards.types.CardType;

public abstract class Card {

	private final int id;

	private final String name;

	public Card(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public abstract CardType getCardType();

	public abstract CardFunctionType geCardFunctionType();

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
