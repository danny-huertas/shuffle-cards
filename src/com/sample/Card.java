package com.sample;

import com.sample.enums.Rank;
import com.sample.enums.Suit;

/**
 * Created by dhuertas on 12/14/16.
 */
public interface Card extends Comparable<Card> {
    /**
     * Gets a Card Rank
     *
     * @return
     */
    Rank getRank();

    /**
     * Gets a Card Suit
     *
     * @return
     */
    Suit getSuit();
}
