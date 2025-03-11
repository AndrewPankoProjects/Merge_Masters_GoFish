package ca.sheridancollege.project;

public class GoFishCard extends Card{
    
   private String suit; //clubs, spades, diamonds, hearts
   private String value;//1-13

   public static final String [] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
   public static final String [] VALUES = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
   
   public GoFishCard(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }   
   
   /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
   
    //Created a toString() method for meaningful display
    @Override
    public String toString(){
        return this.value + " of " + this.suit;
    }
}
