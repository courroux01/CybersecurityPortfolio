package com.sweettooth.blackjack;

import java.util.Scanner;

// Some of the code here is for future project reference
public class Blackjack {
    
    // Create an array to hold all 52 cards (a standard deck)
    public static Card[] fullDeck = Blackjack.initializeDeck();
    
    // Holds the current deck of cards
    private Card[] currentDeck; 
    
    // Constructor for Blackjack
    public Blackjack() {
        // Initialize currentDeck to fullDeck
        this.currentDeck = Blackjack.fullDeck; 
    }
    
    public static void main(String[] args) {
        // Initialize the full deck of cards
        Card[] mainDeck = initializeDeck();
        
        System.out.println("Amanjit was here");
        
        // Number of cards to draw
        int numCards = 7; 
        
        // Generate a hand of cards and get the remaining deck
        HandAndDeck handAndDeck = HandGenerator.generateHand(
            numCards, mainDeck
        );
        
        // Get the remaining deck after drawing cards
        mainDeck = handAndDeck.remainingDeck(); 
        
        // Get the drawn hand of cards
        Card[] randomHand = handAndDeck.hand(); 
        
        // Scanner for user input
        Scanner sc = new Scanner(System.in); 
        
        // Prompt user for card value
        System.out.print("Enter Value: "); 
        
        // Read user input for card value
        int value = sc.nextInt(); 
        
        // Clear the buffer
        sc.nextLine(); 
        
        // Prompt user for card suit
        System.out.print("Enter Suit: "); 
        
        // Read user input for card suit
        String suit = sc.nextLine(); 
        
        // Create a Card object from user input
        Card userCard = new Card(value, suit);
        
        // Print userCard
        System.out.println(userCard.toString());
        
        // Flag to check if there is a match
        boolean match = false; 
        
        // Print number of drawn cards
        System.out.printf("Randomly selected %d cards:\n", numCards); 
        
        for (int i = 0; i < numCards; i++) {
            // Get each card from the random hand
            Card card = randomHand[i]; 

            // Print the card's details
            System.out.printf("Card %d: %s\n", i+1, card.toString());
            
            // Check if the userCard matches the drawn card
            match = card.equals(userCard); 
        }
        
        // Print result based on whether the userCard was found
        if (match) {
            System.out.println("Card found in random hand.");
        } else {
            System.out.println("Card not found in random hand.");
        }
    }

    // Method to initialize the deck of 52 cards
    private static Card[] initializeDeck() {
        // Index to fill the deck
        int index = 0; 
        
        // Total number of cards
        int fullDeckCount = 52; 
        
        // Create an array for the deck
        Card[] deck = new Card[fullDeckCount]; 
        
        // Loop through all values and suits to create each card
        for (Card.Value value : Card.Value.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                // Create a card and add it to the deck
                deck[index] = new Card(value, suit); 
                
                // Increment the index
                index++; 
            }
        }
        
        // Return the completed deck
        return deck; 
    }
}