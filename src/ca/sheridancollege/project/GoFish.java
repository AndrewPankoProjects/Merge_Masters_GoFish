package ca.sheridancollege.project;

public class GoFish extends Game{

    public GoFish(){
        super("GoFish");
    }

    @Override
    public void play() {
        GroupOfCards deck = new GroupOfCards(52);
        System.out.println(deck.getCards());
    }

    @Override
    public void declareWinner() {
        
    }

}
