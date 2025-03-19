package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        System.out.println("Welcome to Go Fish!");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            playerNames.add(scanner.nextLine());
        }
        

        GoFishGame game = new GoFishGame(playerNames);
        game.play();
    }
}
