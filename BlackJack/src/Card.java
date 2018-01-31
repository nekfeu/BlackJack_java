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

    @Override
    public String toString() {
        return value.getName() + " of " + symbol.toString().substring(0, 1).toUpperCase() + symbol.toString().substring(1).toLowerCase();
    }
}
