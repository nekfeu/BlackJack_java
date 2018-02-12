/**
 * Card class
 *
 * @author Kevin Empociello
 * @version 1.0
 */

public class Card {

    /**
     * Card Symbol (Spade, Heart...)
     * @see CardSymbol
     */
    private CardSymbol symbol;

    /**
     * Card Value (1, 2...)
     * @see CardValue
     */
    private CardValue value;

    public Card(CardSymbol symbol, CardValue value) {
        this.symbol = symbol;
        this.value = value;
    }

    /**
     * Card Symbol getter
     * @return The card symbol
     */
    public CardSymbol getSymbol() {
        return symbol;
    }

    /**
     * Card Value getter
     * @return The card value
     */
    public CardValue getValue() {
        return value;
    }

    /**
     * toString override in order to be able to directly print the object card
     * @return the card's description (value, symbol) formatted
     */
    @Override
    public String toString() {
        return value.getName() + " of " + symbol.toString().substring(0, 1).toUpperCase() + symbol.toString().substring(1).toLowerCase();
    }
}
