public class Player {
    private int balance;
    private Dealer dealer;

    /**
     * Constructor for the player
     * 
     * @param balance the initial balance of the player
     * @param dealer the dealer
     */
    public Player(int balance, Dealer dealer) {
        this.balance = balance;
        this.dealer = dealer;
    }

    /**
     * Draws a random card to the player
     * 
     * @return the card that was drawn
     */
    public Card hit() {
        return dealer.drawCard();
    }

    /**
     * Updates the balance of the player reflecting the most recent game played
     * 
     * @param win boolean value stating whether or not the player won
     * @param blackJack boolean value stating whether or not the player got Blackjack
     * @param wager the amount bet by the player for the game
     */
    public void updateBalance(boolean win, boolean blackJack, int wager) {
        if (win) {
            if (blackJack) {
                balance += (wager * 1.5);
            } else {
                balance += wager;
            }
        } else {
            balance -= wager;
        }
        
        System.out.println("You have $" + balance + " remaining");
        System.out.println();
    }
}
