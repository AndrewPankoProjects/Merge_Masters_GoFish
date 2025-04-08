package ca.sheridancollege.project;
/**
 * GoFishGame adopts Single Responsibility Principle
 * by only controlling the flow of game
 * 
 * GoFishGame and GoFishPlayer are an example of Dependency Inversion Principle
 * This is because GoFishGame doesn't depend on GoFishPlayer but instead depends 
 * on the Player interface abstracted functions.
 * 
 * For example: I can have a player called GoFishPlayer that follows functionality of Go Fish
 *              or a player called PokerPlayer that follows functionality of Poker
 *              This means the relationship is now loosely coupled where I can interchange 
 *              the Go Fish game for Poker as well
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoFishGame extends Game {

    private Deck deck;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    private static GoFishGame instance = null;

    private GoFishGame() {
        super(new ArrayList<>());
        System.out.println("Welcome to Go Fish!");
        collectPlayers();
    }

    public static GoFishGame getInstance() {
        if (instance == null) {
            instance = new GoFishGame();
        }
        return instance;
    }

    public void collectPlayers() {
        deck = new Deck();
        int numPlayers = 0;
        boolean validPlayers = false;

        // Ensures players MUST be between 2-4 players
        do {
            System.out.print("Enter number of players (2-4): ");
            
            if (scanner.hasNextInt()) {
                numPlayers = scanner.nextInt();
                scanner.nextLine();  // Clear the buffer after reading the integer
                
                if (numPlayers >= 2 && numPlayers <= 4) {
                    validPlayers = true;
                } else {
                    System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        } while (!validPlayers);

        // Collecting player names and dealing initial cards
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            Player player = new GoFishPlayer(name);

            // Draw initial 5 cards
            for (int j = 0; j < 5; j++) {
                player.drawCard(deck);
            }

            players.add(player);
        }
    }
    
    @Override
    public void play() {
        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            takeTurn(currentPlayer);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        Player winner = null;
        int maxBooks = 0;
        for (Player player : players) {
            if (player.getBooks() > maxBooks) {
                maxBooks = player.getBooks();
                winner = player;
            }
        }
        System.out.println("\nGame Over! The winner is " + winner.getName() + " with " + maxBooks + " books.");
    }

    private void takeTurn(Player player) {
        System.out.println("\n" + player.getName() + "'s turn.");
        player.showHand();
        boolean invalid = false;
        Player opponent;
        String opponentName;
        
        // Added do-while for durability when it comes to player inputs
        do {
            System.out.print("Choose a player to ask: ");
            opponentName = scanner.nextLine();
            opponent = findPlayerByName(opponentName);
    
            if (opponent == null || opponent == player) {
                System.out.println("Invalid choice. Choose again...");
                invalid = true;
            }
            else{
                invalid = false;
            }
        }while (invalid);
        
        System.out.print("Ask for a value (e.g., 'Ace', 'Queen', 'Seven'): ");
        String value = scanner.nextLine();

        if (opponent.hasValue(value)) {
            List<GoFishCard> receivedCards = opponent.giveCards(value);
            System.out.println(opponent.getName() + " gave you " + receivedCards.size() + " " + value + "(s).");
            player.addCards(receivedCards);
        } else {
            System.out.println(opponentName + " says Go Fish!"); // More semantic
            player.drawCard(deck);
        }
    }

    private Player findPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.hasCards()) {
                return false;
            }
        }
        return true;
    }
}
