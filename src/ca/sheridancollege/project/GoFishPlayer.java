package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoFishPlayer extends Player{

    
    private List<GoFishCard> hand = new ArrayList<>();
    private int books = 0; // Completed sets of four cards

    public GoFishPlayer(String name) {
        super(name);
    }
    
    @Override
    public void play() {
       
    }

    public void drawCard(Deck deck) {
        GoFishCard card = deck.drawCard();
        
        if (card != null) {
            hand.add(card);
        }
    }

    public boolean hasRank(String rank) {
        return hand.stream().anyMatch(card -> card.getValue().equals(rank));
    }

    public List<GoFishCard> giveCards(String rank) {
        List<GoFishCard> givenCards = new ArrayList<>();
        hand.removeIf(card -> {
            if (card.getValue().equals(rank)) {
                givenCards.add(card);
                return true;
            }
            return false;
        });
        return givenCards;
    }

    public void addCards(List<GoFishCard> newCards) {
        hand.addAll(newCards);
        checkForBooks();
    }

    public void checkForBooks() {
        Map<String, Long> rankCount = new HashMap<>();
        for (GoFishCard card : hand) {
            rankCount.put(card.getValue(), rankCount.getOrDefault(card.getValue(), 0L) + 1);
        }
        rankCount.forEach((rank, count) -> {
            if (count == 4) {
                books++;
                hand.removeIf(card -> card.getValue().equals(rank));
                System.out.println(getName() + " completed a book of " + rank + "s!");
            }
        });
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getBooks() {
        return books;
    }

    public void showHand() {
        System.out.println(getName() + "'s Hand: " + hand);
    }
}

