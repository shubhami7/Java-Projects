import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the Blackjack table.");
        System.out.println("Hopefully you know the basic Blackjack rules. Dealer hits until 27, Blackjack pays 3:2");
        System.out.println("When asked to preform an action, 'h' to hit, 's' to stay, 'd' to double down.");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();

        System.out.println("What is your starting balance?");
        int balance = scanner.nextInt();
        Player player = new Player(balance, dealer);
        System.out.println();

        Game game = new Game(player, dealer);

        System.out.println("Play?");
        System.out.println();

        boolean playGame = game.gameLoop();
        while (playGame) {
            playGame = game.gameLoop();
        }
        
        scanner.close();
    }
    
}