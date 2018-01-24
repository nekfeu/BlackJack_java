public class Card {

    private CardSymbol symbol;
    private CardValue   value;

    public Card(CardSymbol symbol, CardValue value) {
        this.symbol = symbol;
        this.value = value;
    }

    public CardSymbol getSymbol() {
        return symbol;
    }

    public CardValue getValue() {
        return value;
    }
}
