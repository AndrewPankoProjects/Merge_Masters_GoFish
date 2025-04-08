package ca.sheridancollege.project;
/**
 * @author Andrew Panko 2025
 * This class is utilizing the Singleton Pattern and Single Responsibility Principle
 * 1. The only responsibility App.java has is to run the GoFishGame Instance
 * 2. Singleton Pattern has been applied to make the GoFishGame constructor private
 *    As well as restrict the number of game instances to 1.
 */
public class App {
    public static void main(String[] args) {
        Game game = GoFishGame.getInstance();
        game.play();
    }
}
