package com.sample.impl.deck;

import com.sample.Card;
import com.sample.Deck;
import com.sample.enums.Rank;
import com.sample.enums.Suit;
import com.sample.impl.card.RegularCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Created by dhuertas on 12/14/16.
 */
public class RegularDeck extends Stack<Card> implements Deck {
    public static final int FULL_DECK_CARD_COUNT = 52;
    public static final int TOP_CARD = 0;
    private Stack<Card> cards;

    public RegularDeck() {
        cards = new Stack<>();

        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new RegularCard(s, r));
            }
        }
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#shuffle()
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#cut(int)
     */
    public void cut(int splitPoint) {
        List<Card> cards = new ArrayList<>();

        cards.addAll(getCards().subList(splitPoint, getCards().size()));
        cards.addAll(getCards().subList(TOP_CARD, splitPoint));

        //clear original list of cards
        getCards().clear();
        //add all the new cards
        getCards().addAll(cards);
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#dealCard()
     */
    public Card dealCard() {
        try {
            Card card = cards.pop();
            return card;
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#deal()
     */
    public void deal() {
        //reverse the order before running the while loop
        reverse();
        while (!isEmpty()) {
            dealCard();
        }
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#turnOver()
     */
    public Card turnOver() {
        return cards.get(TOP_CARD);
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#search(Card)
     */
    public int search(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).equals(card)) {
                return i;
            }
        }

        return -1;
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#sort()
     */
    public void sort() {
        Collections.sort(cards);
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#reverse()
     */
    public void reverse() {
        // sort the list
        Collections.reverse(cards);
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#getCards()
     */
    public List<Card> getCards() {
        return cards;
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#isEmpty()
     */
    public boolean isEmpty() {
        return cards.empty();
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#isOrdered()
     */
    public boolean isOrdered() {
        int previousRank = 0;
        int currentSuit = 1;

        //reverse the order before running the while loop
        reverse();
        while (!isEmpty()) {
            Card card = dealCard();

            //if the current Rank is less than the previous Rank
            // or the Card Suit's don't match, return false
            if (!(card.getRank().value() > previousRank && currentSuit == card.getSuit().value())) {
                return false;
            }

            //set previous Rank
            previousRank = card.getRank().value();

            //increment current Suit when rank equals 13 and reinitialize previous Rank
            if (card.getRank().value() == 13) {
                previousRank = 0;
                currentSuit++;
            }
        }

        return true;
    }

    /* (non-Javadoc)
     *  @see com.sample.Deck#getCard()
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    @Override
    public String toString() {
        return "RegularDeck{" + "cards=" + cards + '}';
    }
}
