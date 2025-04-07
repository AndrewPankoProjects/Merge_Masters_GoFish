/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @modified Andrew Panko
 */
package ca.sheridancollege.project;

import java.util.List;

public interface Player {
    String getName();
    boolean hasCards();
    int getBooks();
    void drawCard(Deck deck);
    boolean hasValue(String value); // instead of hasRank
    List<GoFishCard> giveCards(String value); // return GoFishCards
    void addCards(List<GoFishCard> cards);
    void showHand();
}

