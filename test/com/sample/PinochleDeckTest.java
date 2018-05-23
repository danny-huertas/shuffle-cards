package com.sample;

import com.sample.impl.deck.PinochleDeck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by dhuertas on 12/14/16.
 */
public class PinochleDeckTest {
    private PinochleDeck deck;

    @Before
    public void setup() {
        deck = new PinochleDeck();
    }

    @Test
    //Deck contains 52 cards
    public void deckEquals48Cards() {
        Assert.assertEquals(deck.getCards().size(), PinochleDeck.FULL_DECK_CARD_COUNT);
    }

    @Test
    //Deck is ordered
    public void deckInNewOrder() {
        deck.shuffle();
        deck.sort();
        Assert.assertTrue(deck.isOrdered());
    }

    @Test
    //Randomizes the order of the cards.
    public void deckIsShuffled() {
        deck.shuffle();
        Assert.assertFalse(deck.isOrdered());

    }

    //Splits the deck at a point chosen by the player; cards above the split point are placed on
    //the bottom of the deck (without reordering). The first card below the split becomes the top
    //of the deck.  The first card above the split becomes the bottom of the deck.
    @Test
    public void deckIsCut() {
        Random random = new Random();
        //use 4 random numbers between 22 and 28 to cut the deck and verify the split
        for (int i = 0; i < 4; i++) {
            int splitPoint = 22 + random.nextInt(6);
            Card card = deck.getCard(splitPoint);
            deck.cut(splitPoint);
            Assert.assertEquals(card, deck.turnOver());
        }
    }

    @Test
    //Retrieves the top card and removes it from the deck.
    public void deckIsDealt() {
        deck.shuffle();
        deck.deal();
        Assert.assertTrue(deck.isEmpty());
    }

    @Test
    //Finds the position of a given card in the deck (top of the deck is the first card, next card is the second, etc.).
    public void deckCardPosition() {
        //TODO find the card
    }
}
