import java.util.Random;

/**
 * Deck class
 *
 * @author Kevin Empociello
 * @version 1.0
 */

public class Deck {

    private Card[] cards = new Card[52];

    /**
     * Init deck by creating the cards
     */
    public void init() {
        int index = 0;

        for (CardValue value: CardValue.values()) {
            for (CardSymbol symbol: CardSymbol.values()) {
                cards[index++] = new Card(symbol, value);
            }
        }
    }

    /**
     * Shuffle cards
     */
    public void shuffle() {
        int index;
        Card switchTmp;

        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);

            switchTmp = cards[index];
            cards[index] = cards[i];
            cards[i] = switchTmp;
        }
    }

    /**
     * Display the entire deck
     */
    public void display() {
        for (Card card: cards) {
            if (card != null) {
                System.out.println(card.toString());
            }
        }
    }

    /**
     * Get the number of remaining cards in the deck
     * @return the number of remaining cards
     */
    public int getNumberOfRemainerCards() {
        int index = 0;

        for (Card card: cards) {
            index += (card != null) ? 1 : 0;
        }

        return index;
    }

    /**
     * Deal a card
     * @return the Card dealed
     */
    public Card pop() {
        int index = getNumberOfRemainerCards() - 1;

        if (index < 0) {
            System.out.println("Can't get cards anymore, please create a new deck");
            return null;
        }

        while (cards[index] == null) {
            index--;
        }

        Card card = cards[index];
        cards[index] = null;

        return card;
    }

    /**
     * Check the deck to renew it when it's needed
     */
    public void check() {
        if (getNumberOfRemainerCards() < 20) {
            init();
        }
    }
}
