import java.util.Random;

public class Dealer {

    private Card[] deck = {
        new Card("A", 1), new Card("2", 2), new Card("3", 3), new Card("4", 4), new Card("5", 5),
        new Card("6", 6), new Card("7", 7), new Card("8", 8), new Card("9", 9), new Card("10", 10),
        new Card("J", 10), new Card("Q", 10), new Card("K", 10)
    };

    /**
     * Draws a random card from the deck
     * 
     * @return the object of the card that was drawn
     */
    public Card drawCard() {
        Random rand = new Random();
        int randNum = rand.nextInt(13);
        return deck[randNum];
    }

    /**
     * Handles cases where an ace is drawn to determine which value it should reflect based on the current hand value
     * 
     * @param card the card that will contribute to a hand value
     * @param handVal the current hand value
     * @return either 1 or 11 depending on the current hand value, or the value of the card if it's not an ace
     */
    public int aceHandeler(Card card, int handVal) {
        if (!card.face.equals("A")) {
            return card.value;
        } else if (handVal > 10) {
            return 1;
        }
        return 11;
    }

    /**
     * Draws the first two cards to the player
     * 
     * @return the hand value of the first two cards
     */
    public int drawToPlayer() {
        Card firstCard = drawCard();
        Card secondCard = drawCard();
        int handVal = aceHandeler(firstCard, firstCard.value) + aceHandeler(secondCard, secondCard.value);

        System.out.println("Your cards are " + firstCard.face + " " + secondCard.face);
        System.out.println("Your hand value: " + handVal);
        System.out.println();
        return handVal;
    }

    /**
     * Draws the face up card to the dealer
     * 
     * @return the face up card
     */
    public Card drawToDealer() {
        Card firstCard = drawCard();

        System.out.println("Dealer is showing " + firstCard.face);
        return firstCard;
    }

    /**
     * Plays dealer's turn following the dealer's rules of Blackjack
     * 
     * @param firstCard the face up card of the dealer
     * @param bust boolean value stating whether or not the player bust
     * @return the final hand value of the dealer
     */
    public int dealerPlay(Card firstCard, boolean bust) {
        Card secondCard = drawCard();
        int handVal = aceHandeler(firstCard, firstCard.value) + aceHandeler(secondCard, secondCard.value);
        System.out.println("Dealer has " + firstCard.face + " with " + secondCard.face + " underneath");

        while (handVal < 17 && !bust) {
            Card drawnCard = drawCard();
            handVal += aceHandeler(drawnCard, handVal);
            System.out.println("Dealer drew " + drawnCard.face);
        }

        System.out.println("Dealer's hand value: " + handVal);
        System.out.println();
        return handVal;
    }
}