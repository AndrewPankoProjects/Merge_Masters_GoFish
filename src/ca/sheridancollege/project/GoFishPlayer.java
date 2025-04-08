package ca.sheridancollege.project;

/**
 * GoFishPlayer adopts Single Responsibility Principle
 * by only managing a player's hand, books, and interactions
 * 
 * GoFishPlayer also adopts the Liskov Substitution Principle
 * As this class is derived from Player and we can interchangably 
 * change the type of Player for different games.
 * 
 * For example: In GoFishGame ln: 50
 * 
 * Player player = new GoFishPlayer(name); 
 * This demonstrates LSP as we are creating a new player that is specific for Go Fish, 
 * but we can reuse this for other games like new PokerPlayer, WarPlayer, etc.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoFishPlayer implements Player {

    private String name;
    private List<GoFishCard> hand = new ArrayList<>();
    private int books = 0;

    public GoFishPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean hasCards() {
        return !hand.isEmpty();
    }

    @Override
    public int getBooks() {
        return books;
    }

    @Override
    public void drawCard(Deck deck) {
        GoFishCard card = deck.drawCard();
        if (card != null) {
            hand.add(card);
            checkForBook(card.getValue());
        }
    }

    @Override
    public boolean hasValue(String value) {
        return hand.stream().anyMatch(card -> card.getValue().equalsIgnoreCase(value));
    }

    @Override
    public List<GoFishCard> giveCards(String value) {
        List<GoFishCard> matching = new ArrayList<>();
        Iterator<GoFishCard> iterator = hand.iterator();

        while (iterator.hasNext()) {
            GoFishCard card = iterator.next();
            if (card.getValue().equalsIgnoreCase(value)) {
                matching.add(card);
                iterator.remove();
            }
        }

        return matching;
    }

    @Override
    public void addCards(List<GoFishCard> cards) {
        hand.addAll(cards);
        if (!cards.isEmpty()) {
            checkForBook(cards.get(0).getValue());
        }
    }

    @Override
    public void showHand() {
        System.out.print(name + "'s hand: ");
        for (GoFishCard card : hand) {
            System.out.print(card + " | ");
        }
        System.out.println();
    }

    private void checkForBook(String value) {
        long count = hand.stream().filter(card -> card.getValue().equalsIgnoreCase(value)).count();
        if (count == 4) {
            hand.removeIf(card -> card.getValue().equalsIgnoreCase(value)); //Ignore case of player inputs +Durability
            books++;
            System.out.println(name + " completed a book of " + value + "s!");
        }
    }
}
