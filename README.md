# Blackjack Game

This repository contains all the files I created to implement a Blackjack game in Java. The program is designed with a modular approach, using separate classes for different aspects of the game, such as the **Player**, **Dealer**, **Cards**, and **Game State**.

## Features

### Modular Design:
Each class handles specific responsibilities:
- **Player**: Tracks player-specific data and actions.
- **Dealer**: Manages dealer logic and decision-making.
- **Cards**: Represents the deck and individual cards, including shuffling and dealing.
- **Game State**: Manages the overall flow of the game, including rounds and results.

### Efficient Memory Usage:
At the end of each game round, the current game state data is cleared to reduce memory usage and prepare for a new round.

### Dynamic Hand Evaluation:
Utilized the **List** library to store the player and dealer hands in **ArrayLists** for seamless hand evaluation and game logic.
