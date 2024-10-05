package com.sweettooth.blackjack;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

// Record to hold remaining cards in the deck and the hand
record HandAndDeck(Card[] remainingDeck, Card[] hand) {}

public class HandGenerator {
    // Method to generate a hand of random cards
    public static HandAndDeck generateHand(int numCards, Card[] currentDeck) {
        // Create a Random object for picking cards
        Random random = new Random(); 
        // List to store the randomly picked hand
        ArrayList<Card> hand = new ArrayList<>(); 
        // Copy of the current deck
        ArrayList<Card> tempDeck = new ArrayList<>(Arrays.asList(currentDeck)); 

        // Ensure we don't pick more cards than available in the deck
        if (numCards > currentDeck.length) {
            throw new IllegalArgumentException(
                "Cannot pick more cards than the deck size."
            );
        }

        // Randomly pick cards until we have the desired number
        while (hand.size() < numCards) {
            // Generate a random index
            int index = random.nextInt(tempDeck.size()); 
            // Add the card at that index to the hand
            hand.add(tempDeck.get(index)); 
            // Remove that card from the temporary deck
            tempDeck.remove(index); 
        }

        // Return the remaining deck and the selected hand
        return new HandAndDeck(
                // Convert remaining deck to array
                tempDeck.toArray(new Card[tempDeck.size()]), 
                // Convert hand to array
                hand.toArray(new Card[hand.size()]) 
        );
    }
}
