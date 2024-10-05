package com.sweettooth.blackjack;

import java.util.Objects;

public class Card {

    public enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
        EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private Value value;
    private Suit suit;

    // Default constructor
    public Card() {}

    // Constructor initializing card with an integer value and string suit
    public Card(int value, String suit) {
        this.value = convertToEnum(value);
        this.suit = convertToEnum(suit);
    }

    // Constructor initializing card with Value and Suit
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    // Gets the current value of the card
    public Value getValue() {
        return this.value;
    }

    // Gets the hand value considering whether it's over ten
    public int getHandValue(boolean isOverTen) {
        int handValue;
        
        switch (this.value) {
            case ACE:
                handValue = isOverTen ? 1 : 11;
                break;
            case KING:
            case QUEEN:
            case JACK:
            case TEN:
                handValue = 10;
                break;
            case NINE:
                handValue = 9;
                break;
            case EIGHT:
                handValue = 8;
                break;
            case SEVEN:
                handValue = 7;
                break;
            case SIX:
                handValue = 6;
                break;
            case FIVE:
                handValue = 5;
                break;
            case FOUR:
                handValue = 4;
                break;
            case THREE:
                handValue = 3;
                break;
            case TWO:
                handValue = 2;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + this.value);
        }
        
        return handValue; // Return the computed hand value
    }

    // Gets the current suit of the card
    public Suit getSuit() {
        return this.suit;
    }

    // Sets the value of the card
    public void setValue(Value value) {
        this.value = value;
    }

    // Sets the suit of the card
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    // Compares cards for equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.suit == other.suit && this.value == other.value;
    }

    // Generates hash code based on value and suit
    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    // Returns string representation of the card
    @Override
    public String toString() {
        return String.format(
            "%s of %s",
            this.value.name(),
            this.suit.name()
        );
    }

    // Converts a String to a Suit enum value
    public static Suit convertToEnum(String suit) {
        System.out.println(suit.toUpperCase());
        switch (suit.toUpperCase()) {
            case "D":
            case "DIAMONDS":
                return Suit.DIAMONDS;
            case "S":
            case "SPADES":
                return Suit.SPADES;
            case "C":
            case "CLUBS":
                return Suit.CLUBS;
            case "H":
            case "HEARTS":
                return Suit.HEARTS;
            default:
                throw new IllegalArgumentException("Bad input: " + suit);
        }
    }

    // Converts an integer to a Value enum value
    public static Value convertToEnum(int value) {
        switch (value) {
            case 1:
            case 14:
                return Value.ACE;
            case 2:
                return Value.TWO;
            case 3:
                return Value.THREE;
            case 4:
                return Value.FOUR;
            case 5:
                return Value.FIVE;
            case 6:
                return Value.SIX;
            case 7:
                return Value.SEVEN;
            case 8:
                return Value.EIGHT;
            case 9:
                return Value.NINE;
            case 10:
                return Value.TEN;
            case 11:
                return Value.JACK;
            case 12:
                return Value.QUEEN;
            case 13:
                return Value.KING;
            default:
                throw new IllegalArgumentException("Bad input: " + Integer.toString(value));
        }
    }
}

