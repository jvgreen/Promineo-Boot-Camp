package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<Card>();

    private int score;
    private String name;

    public Player (String name) {
        score = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void describe() {
        System.out.println("Name: " + name);
        System.out.println("Score: " + score);
        for(int i = 0; i < hand.size(); i++) {
            hand.get(i).describe();
        }
    }

    public Card flip() {
        Card top = new Card(hand.get(0).getName(), hand.get(0).getValue());
        hand.remove(0);
        return top;
    }

    public void draw(Deck deck) {
        Card card = deck.draw();
        hand.add(card);
    }

    public void incrementScore() {
        score++;
    }

}
