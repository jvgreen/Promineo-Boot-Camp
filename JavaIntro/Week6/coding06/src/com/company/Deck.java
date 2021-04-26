package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    public Deck() {
        // Add Diamonds
        makeSuite("Diamonds");

        // Add Hearts
        makeSuite("Hearts");

        // Add Clubs
        makeSuite("Clubs");

        // Add Spades
        makeSuite("Spades");
    }

    private void makeSuite(String suite) {
        for(int i = 2; i <=14; i++) {
            String name = nameCard(i);
            Card card = new Card(name + " of " + suite, i);
            cards.add(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public String nameCard(int value) {
        String name;
        if(value == 11) {
           name = "Jack";
        } else if (value == 12) {
            name = "Queen";
        } else if (value == 13) {
            name = "King";
        } else if (value == 14) {
            name = "Ace";
        } else {
            name = Integer.toString(value);
        }
        return name;
    }

    public Card draw() {
        Card top = new Card(cards.get(0).getName(), cards.get(0).getValue());
        cards.remove(0);
        return top;
    }
}
