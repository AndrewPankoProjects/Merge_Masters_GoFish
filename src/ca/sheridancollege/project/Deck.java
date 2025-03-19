/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @modified Andrew Panko
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifed Andrew Panko March 2025
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    private ArrayList<GoFishCard> cards;
    private int size;//the size of the grouping

    public Deck() {
        this.cards = new ArrayList<GoFishCard>();

        for (String suit : GoFishCard.SUITS) {
            for (String rank : GoFishCard.VALUES) {
                this.cards.add(new GoFishCard(rank, suit));
            }
        }
        Collections.shuffle(this.cards);
    }

    //Draw function
    public GoFishCard drawCard() {
        return this.cards.isEmpty() ? null : this.cards.remove(0);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
