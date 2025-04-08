<div align="center">

  <h1>🎣 Go Fish! 🎣</h1>

  <p>
    A digital console-based version of the classic card game built using object-oriented design principles.
  </p>

  <p>
    <a href="https://bicyclecards.com/how-to-play/go-fish" target="_blank">
      <img src="https://img.shields.io/badge/Rules-Learn%20How%20to%20Play-blue?style=for-the-badge" alt="Go Fish Rules">
    </a>
  </p>

  <br/>

  <p>
    ✅ <strong>Project Completed!</strong> ✅
  </p>

</div>

---

## ✨ About the Project

This project brings the traditional *Go Fish* card game to life through a text-based console application. Developed using strong object-oriented programming principles, the game allows 2–4 players to enjoy a full playthrough of Go Fish in a Java environment.

---

## 🧠 Object-Oriented Design Principles Used

We designed this project with industry-standard coding principles in mind:

- *Single Responsibility Principle (SRP):* Each class handles one job only (e.g., Deck manages cards, GoFishGame runs the game flow).
- *Open/Closed Principle (OCP):* Interfaces like Player allow us to introduce new player types (e.g., AI) without modifying existing game logic.
- *Liskov Substitution Principle (LSP):* The Player interface allows any implementation to be used polymorphically within the game.
- *Interface Segregation Principle (ISP):* The Player interface only includes essential game-related behaviors.
- *Dependency Inversion Principle (DIP):* GoFishGame depends on the Player abstraction, not on specific implementations.

---

## 🛠 Tools & Technologies

- *Java (JDK 17)*
- *NetBeans* – Primary IDE for development
- *Visual Paradigm* – UML diagram creation
- *GitHub* – Source control and collaboration

---

## 📂 Project Structure

- App.java – Launches the game using the Singleton GoFishGame instance  
- GoFishGame.java – Controls the game logic, player turns, input handling, and winner declaration  
- GoFishPlayer.java – Implements the Player interface and manages hand operations, book tracking  
- Deck.java – Handles creation and shuffling of the Go Fish card deck  
- GoFishCard.java – Represents individual cards (suit and value)  
- Card.java – Abstract base class for card representation  
- Game.java – Abstract parent for games like Go Fish  
- Player.java – Interface defining essential methods for all player types

---

## 🎮 Features

- Play Go Fish in a 2–4 player mode through the console
- Randomized deck generation using Collections.shuffle()
- Automatic book detection (four-of-a-kind)
- Input prompts for asking cards and drawing
- Winner is declared at the end based on number of books collected
- Clean and readable game flow

---

## 🕹 How to Play

1. Run the project from the App.java file.
2. Enter the number of players (2–4).
3. Enter player names when prompted.
4. On each player's turn:
   - Choose another player to ask for a specific card value.
   - If the player has any matching cards, they are transferred to your hand.
   - If not, “Go Fish!” — draw a card from the deck.
5. If you collect four cards of the same value, a “book” is completed.
6. The game continues until the deck is empty or no more moves are possible.
7. The player with the most books wins!

> All actions are handled via the console with clear prompts and responses.

---

## 🤝 Contributions

This is a completed academic project, but feedback is always welcome!

If you'd like to explore or extend the project:

1. Fork the repository  
2. Create a new branch  
3. Commit your changes  
4. Open a pull request with a description  

---

## 📬 Contact

For any feedback, collaboration, or questions:

- Andrew Panko (Project Leader)  
- Vanshdeep Singh  
- Komalpreet Kaur  
- Eiknoor Kaur Batra  

📫 Feel free to reach out via GitHub!

---

<div align="center">
  <sub>🎓 Successfully built with ❤ by the Merge_Masters_GoFish team – Winter 2025</sub>
</div>
