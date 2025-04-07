package ca.sheridancollege.project;

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
        int numPlayers;
        boolean validPlayers = false;

        do {
            System.out.print("Enter number of players (2-4): ");
            numPlayers = scanner.nextInt();
            scanner.nextLine();
            if (numPlayers > 1 && numPlayers <= 4) {
                validPlayers = true;
            }
        } while (!validPlayers);

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

        System.out.print("Choose a player to ask: ");
        String opponentName = scanner.nextLine();
        Player opponent = findPlayerByName(opponentName);

        if (opponent == null || opponent == player) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Ask for a value (e.g., 'Ace', 'Queen', 'Seven'): ");
        String value = scanner.nextLine();

        if (opponent.hasValue(value)) {
            List<GoFishCard> receivedCards = opponent.giveCards(value);
            System.out.println(opponent.getName() + " gave you " + receivedCards.size() + " " + value + "(s).");
            player.addCards(receivedCards);
        } else {
            System.out.println(opponentName + " says Go Fish!");
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
