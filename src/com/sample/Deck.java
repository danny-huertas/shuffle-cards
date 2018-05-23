package com.sample;

import java.util.List;

/**
 * Created by dhuertas on 12/14/16.
 */
public interface Deck {

    /**
     * Randomizes the order of the cards.
     */
    void shuffle();

    /**
     * Splits the deck at a point chosen by the player; cards above the split point are placed on
     * the bottom of the deck (without reordering). The first card below the split becomes the top
     * of the deck.  The first card above the split becomes the bottom of the deck.
     *
     * @param splitPoint
     */
    void cut(int splitPoint);

    /**
     * Retrieves the top card and removes it from the deck.
     *
     * @return a Card
     */
    Card dealCard();

    /**
     * Retrieves the top card and removes it from the deck until the whole deck is empty.
     */
    void deal();

    /**
     * Retrieves the top card but does not remove it from the deck.
     *
     * @return a Card
     */
    Card turnOver();

    /**
     * Finds the position of a given card in the deck (top of the deck is the first card, next card
     * is the second, etc.).
     *
     * @param card
     * @return card position
     */
    int search(Card card);

    /**
     * Places the remaining cards in the deck in the order of a new deck of cards (top to bottom:  
     * hearts A-K, clubs A-K, diamonds K-A, spades K-A).
     */
    void sort();

    /**
     * Reverses the order of cards in a deck
     */
    void reverse();

    /**
     * Gets all the Cards in a Deck
     *
     * @return a list of Cards
     */
    List<Card> getCards();

    /**
     * Is Deck out of Cards
     *
     * @return true if the Deck has no Cards
     */
    boolean isEmpty();

    /**
     * Verifies if a Decks Cards are in order
     *
     * @return true if the Decks Cards are in order
     */
    boolean isOrdered();

    /**
     * Get aCard from the Deck
     *
     * @param index
     * @return a Card
     */
    Card getCard(int index);
}
