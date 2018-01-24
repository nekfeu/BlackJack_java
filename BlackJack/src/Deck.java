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
            System.out.println(card.getValue() + " OF " + card.getSymbol());
        }

        System.out.println("cards.length = " + cards.length);
    }
}
