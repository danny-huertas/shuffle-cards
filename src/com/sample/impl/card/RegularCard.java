package com.sample.impl.card;

import com.sample.Card;
import com.sample.enums.Rank;
import com.sample.enums.Suit;

/**
 * Created by dhuertas on 12/14/16.
 */
public class RegularCard implements Card {
    private Suit suit;
    private Rank rank;

    public RegularCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /* (non-Javadoc)
     *  @see com.sample.Card#getRank()
     */
    public Rank getRank() {
        return rank;
    }

    /* (non-Javadoc)
     *  @see com.sample.Card#getSuit()
     */
    public Suit getSuit() {
        return suit;
    }

    public int compareTo(Card o) {
        if (this.suit.value() < o.getSuit().value()) {
            return -1;
        } else if (this.suit.value() > o.getSuit().value()) {
            return 1;
        } else {
            // suit is identical: compare number
            if (this.getRank().value() < o.getRank().value()) {
                return -1;
            } else if (this.getRank().value() > o.getRank().value()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RegularCard that = (RegularCard) o;

        if (suit != that.suit)
            return false;
        return rank == that.rank;

    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegularCard{" + "suit=" + suit + ", rank=" + rank + '}';
    }
}
