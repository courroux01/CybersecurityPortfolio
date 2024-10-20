package blackjack;

import java.util.ArrayList;

public class BlackjackPlayer extends Player {
    private ArrayList<PlayingCard> hand;
    private int score;
    private boolean isStanding;

    public BlackjackPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
        isStanding = false;
    }

    // Add a card to the player's hand
    public void addCard(PlayingCard card) {
        hand.add(card);
        updateScore();
    }

    // Return the player's hand
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    // Calculate the player's current score
    private void updateScore() {
        score = 0;
        int aceCount = 0;

        for (PlayingCard card : hand) {
            score += card.getBlackjackValue();
            if (card.getValue() == PlayingCard.Value.ACE) {
                aceCount++;
            }
        }

        // Adjust for aces (count them as 1 if the score is over 21)
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
    }

    // Get the player's score
    public int getScore() {
        return score;
    }

    // Set player standing status
    public void stand() {
        isStanding = true;
    }

    public boolean isStanding() {
        return isStanding;
    }

    @Override
    public void play() {
        // Player-specific actions, e.g., hit or stand (handled externally in text-based game)
    }

    @Override
    public String toString() {
        return super.getName() + "'s hand: " + hand.toString() + " | Score: " + score;
    }
}
