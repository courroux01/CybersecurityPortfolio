package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<PlayingCard> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
        // Initialize deck with 52 cards
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Value value : PlayingCard.Value.values()) {
                cards.add(new PlayingCard(suit, value));
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deal a card from the deck
    public PlayingCard dealCard() {
        return cards.remove(0); // Remove and return the top card
    }

    // Get the remaining cards in the deck
    public int remainingCards() {
        return cards.size();
    }
}
