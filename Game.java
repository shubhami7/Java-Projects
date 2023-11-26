import java.util.Scanner;

public class Game {
    Player player;
    Dealer dealer;
    Scanner input;

    /**
     * Constructor for the game
     * 
     * @param player the player object
     * @param dealer the dealer object
     */
    public Game(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
        this.input = new Scanner(System.in);
    }

    /**
     * Runs the flow of a Blackjack game
     * 
     * @return whether or not the player wants to play again
     */
    public boolean gameLoop() {
        System.out.println("What is your bet?");
        int wager = input.nextInt();
        System.out.println();

        Card firstCard = dealer.drawToDealer();
        System.out.println();
        int playerVal = dealer.drawToPlayer();

        if (playerVal == 21) {
            player.updateBalance(true, true, wager);
        }

        System.out.println("Action?");
        System.out.println();
        String action = input.next();
        boolean playerBust = false;
        if (action.equals("d")) {
            Card drawn = player.hit();
            playerVal += dealer.aceHandeler(drawn, playerVal);

            System.out.println("Your one card is " + drawn.face);
            System.out.println("Your hand value: " + playerVal);
            System.out.println();
            wager *= 2;
        }
        while (action.equals("h")) {
            Card drawn = player.hit();
            playerVal += dealer.aceHandeler(drawn, playerVal);
            System.out.println("You drew " + drawn.face);
            System.out.println("Your hand value: " + playerVal);
            System.out.println();

            if (playerVal > 21) {
                System.out.println("You bust");
                playerBust = true;
                player.updateBalance(false, false, wager);
                break;
            }

            action = input.next();
        }

        int dealerVal = dealer.dealerPlay(firstCard, playerBust);

        if (!playerBust) {
            if (dealerVal > 21) {
                System.out.println("Dealer bust, you win");
                System.out.println();
                player.updateBalance(true, false, wager);
            } else {
                if (playerVal > dealerVal) {
                    System.out.println("You win");
                    player.updateBalance(true, false, wager);
                    System.out.println();
                } else if (playerVal == dealerVal) {
                    System.out.println("You push");
                    System.out.println();
                } else {
                    System.out.println("Dealer wins");
                    System.out.println();
                    player.updateBalance(false, false, wager);
                }
            }
        }

        System.out.println("Play another?");
        boolean playGame = input.next().equals("y");
        System.out.println();

        return playGame;
    }
}
