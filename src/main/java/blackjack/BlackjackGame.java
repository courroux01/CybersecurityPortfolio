package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame extends Game {
    private GroupOfCards deck;
    private BlackjackPlayer dealer;
    private BlackjackPlayer player;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards();
        dealer = new BlackjackPlayer("Dealer");
        player = new BlackjackPlayer("Player");
    }

    @Override
    public void play() {
        deck.shuffle();
        System.out.println("Starting Blackjack game!");

        // Initial deal (2 cards to player, 2 to dealer)
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        System.out.println(player);
        System.out.println("Dealer shows: " + dealer.getHand().get(0));

        // Player's turn
        Scanner scanner = new Scanner(System.in);
        while (player.getScore() < 21 && !player.isStanding()) {
            System.out.println("Hit or stand? (h/s)");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("h")) {
                player.addCard(deck.dealCard());
                System.out.println(player);
            } else if (action.equalsIgnoreCase("s")) {
                player.stand();
            }
        }

        // Dealer's turn (must hit until reaching 17 or higher)
        while (dealer.getScore() < 17) {
            dealer.addCard(deck.dealCard());
        }
        System.out.println("Dealer's hand: " + dealer);

        // Determine the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (playerScore > 21) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("Player wins!");
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
