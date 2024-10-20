package blackjack;

public class PlayingCard extends Card {

    public enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private final Suit suit;
    private final Value value;

    public PlayingCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    // Override toString() to print the card nicely
    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
    // Method to get the Blackjack value of the card
    public int getBlackjackValue() {
        switch (value) {
            case ACE:
                return 11; // Default to 11, handled later if necessary
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                return 0;
        }
    }
}
