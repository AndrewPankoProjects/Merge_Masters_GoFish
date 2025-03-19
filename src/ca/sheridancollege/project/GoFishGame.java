package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoFishGame extends Game{

    private Deck deck;
    private ArrayList<GoFishPlayer> players = new ArrayList<GoFishPlayer>(); // Use Player here
    private int currentPlayerIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    public GoFishGame(List<String> playerNames) {
        super(new ArrayList<>()); // Call the parent constructor
        deck = new Deck(); // Assuming Deck constructor takes size as int

        for (String name : playerNames) {
            GoFishPlayer player = new GoFishPlayer(name);
            for (int i = 0; i < 5; i++) {
                player.drawCard(deck); // Assuming drawCard is a method in Player
            }
            players.add(player);
        }
    }

    @Override
    public void play() {
        while (!isGameOver()) { // Assuming isGameOver() returns true when the game is over
            takeTurn(players.get(currentPlayerIndex)); // Use .get() for ArrayList
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // Use .size() for ArrayList
        }
        declareWinner();
    }

    private void takeTurn(GoFishPlayer player) {
        System.out.println("\n" + player.getName() + "'s turn.");
        player.showHand();

        System.out.print("Choose a player to ask: ");
        String opponentName = scanner.nextLine();
        GoFishPlayer opponent = findPlayerByName(opponentName);
        if (opponent == null || opponent == player) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Ask for a rank (e.g., 'A' for Ace): ");
        String rank = scanner.nextLine();

        if (opponent.hasRank(rank)) {
            List<GoFishCard> receivedCards = opponent.giveCards(rank);
            System.out.println(opponent.getName() + " gave you " + receivedCards.size() + " " + rank + "(s).");
            player.addCards(receivedCards);
        } else {
            System.out.println("Go Fish!");
            player.drawCard(deck);
        }
    }

    private GoFishPlayer findPlayerByName(String name) {
        for (GoFishPlayer player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    private boolean isGameOver() {
        for (GoFishPlayer player : players) {
            if (player.hasCards()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void declareWinner() {
        GoFishPlayer winner = null;
        int maxBooks = 0;
        for (GoFishPlayer player : players) {
            if (player.getBooks() > maxBooks) {
                maxBooks = player.getBooks();
                winner = player;
            }
        }
        System.out.println("\nGame Over! The winner is " + winner.getName() + " with " + maxBooks + " books.");
    }

}
