public class Card {
    String face;
    int value;

    /**
     * Constructor for a card
     * 
     * @param face the face of a card, ie. Ace, 2, King, etc
     * @param value the hand value the card contributes in Blackjack
     */
    public Card(String face, int value) {
        this.face = face;
        this.value = value;
    }
}
