import java.util.Random;

public class Deck {

    private Card[] cards = new Card[52];

    public Deck() {
    }

    public void init() {
        int index = 0;

        for (CardValue value: CardValue.values()) {
            for (CardSymbol symbol: CardSymbol.values()) {
                cards[index++] = new Card(symbol, value);
            }
        }
    }

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

    public void display() {
        for (Card card: cards) {
            if (card != null) {
                System.out.println(card.toString());
            }
        }
    }

    public int getNumberOfRemainerCards() {
        int index = 0;

        for (Card card: cards) {
            index += (card != null) ? 1 : 0;
        }

        return index;
    }

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
}
