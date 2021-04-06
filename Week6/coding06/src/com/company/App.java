package com.company;

public class App {

    public static void main(String[] args) {

        // Make a deck
        Deck deck = new Deck();

        // Add two players
        Player player1 = new Player("Max");
        Player player2 = new Player("Sam");

        // Shuffle deck
        deck.shuffle();

        // Draw the deck
        for(int i = 0; i < 52; i+=2) {
            player1.draw(deck);
            player2.draw(deck);
        }

        // Flip cards and compare
        for(int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();
            if(card1.getValue() > card2.getValue()) {
                player1.incrementScore();
            } else {
                player2.incrementScore();
            }
        }

        // Compare score and declare a winner
        if(player1.getScore() == player2.getScore()) {
            System.out.println("Draw: " + player1.getName() + " and " + player2.getName());
            System.out.println("Score: " + player1.getScore());
        } else if (player1.getScore() > player2.getScore()) {
            System.out.println("Winner Player 1: " + player1.getName());
            System.out.println(("Score: " + player1.getScore()));
        } else {
            System.out.println("Winner Player 2: " + player2.getName());
            System.out.println("Score: " + player2.getScore());
        }
    }
}
