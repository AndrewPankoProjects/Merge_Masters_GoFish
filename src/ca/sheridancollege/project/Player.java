package ca.sheridancollege.project;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @modified Andrew Panko April 7th, 2025
 * 
 * Player class adopts the Open/Closed Principle as the Player interface allows
 * new types/subclasses of players to be created without modifying any functionality 
 * of GoFishGame
 * 
 * For example: Adding a subclass AI GoFishPlayer subclass that can be used in the GoFishGame instead of real players
 *              being added...
 * 
 * Player interface is adopting Interface Segregation Principle
 * As the class focused on only providing functionality of what a
 * player would NEED in order to play the game of Go Fish
 */

import java.util.List;

public interface Player {
    String getName();
    boolean hasCards();
    int getBooks();
    void drawCard(Deck deck);
    boolean hasValue(String value); 
    List<GoFishCard> giveCards(String value); 
    void addCards(List<GoFishCard> cards);
    void showHand();
}

