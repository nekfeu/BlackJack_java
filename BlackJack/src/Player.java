import java.util.Scanner;

/**
 * Player class
 *
 * @author Kevin Empociello
 * @version 1.0
 */


public class Player {

    /**
     * Representing the user's money
     */
    private int money = 100;

    /**
     * If autoPlay is true, the player play automatically (IA)
     */
    private boolean autoPlay;

    /**
     * Player's hand
     */
    private Card[] hand = new Card[0];

    /**
     * Player's constructor
     * @param autoPlay, set to true if the player is an IA.
     */
    public Player(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    /**
     * Reset the hand to an empty hand
     */
    public void clearHand() {
        hand = new Card[0];
    }

    /**
     * Display the player's hand
     */
    public void displayHand() {
        System.out.println("");
        System.out.println(autoPlay ? "-- Dealer hand --" : "-- Your hand --");

        for (Card card: hand) {
            System.out.println(card.toString());
        }

        System.out.println("--  TOTAL " + this.getHandSum() + "  --\n" );
    }

    /**
     * Get the sum of the player's hand
     * @return sum of the cards in the player's hand
     */
    public int getHandSum() {
        int sum = 0;

        for (Card card: hand) {
            sum += (card.getValue() == CardValue.ACE) ? 0 : card.getValue().value;
        }

        for (Card card: hand) {
            if (card.getValue() == CardValue.ACE && sum + 11 <= 21) {
                sum += 11;
            } else if (card.getValue() == CardValue.ACE) {
                sum += 1;
            }
        }

        return sum;
    }

    /**
     * Get the user input to choose how much he wants to bet
     * @return the bet chosen
     */
    public int chooseBet() {
        System.out.println("How much do you want to bet ?");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int bet = 0;

        try {
            bet = Integer.parseInt(str);

            if (money - bet < 0) {
                System.out.println("You don't have enough money");

                return chooseBet();
            }
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid number");

            return chooseBet();
        }

        loose(bet);
        return bet;
    }

    /**
     * Get the sum of the player's hand
     * @return sum of the cards in the player's hand
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Player earned money
     * @param money the money earned
     */
    public void earn(int money) {
        this.money += (money * 2);
    }

    /**
     * Player lost money
     * @param money the money lost
     */
    public void loose(int money) {
        this.money -= money;
    }

    /**
     * Display player's portfolio
     */
    public void displayPortfolio() {
        System.out.println("Your wallet: " + this.money + "$");
    }

    /**
     * Check if the player is a dealer (IA)
     * @return true if it's the case
     */
    public boolean isDealer() {
        return this.autoPlay;
    }

    /**
     * Player receive a card
     * @param card the card given by the dealer
     */
    public void receiveCard(Card card) {
        Card[] newHand = new Card[hand.length + 1];
        int index = 0;

        for (Card oneCard: hand) {
            newHand[index++] = oneCard;
        }

        newHand[index] = card;
        hand = newHand;
    }

    /**
     * Ask the player if he wants a card or just stand
     * @return true if he wants a card, false if he wants to stand
     */
    public boolean askedCard() {
        System.out.println("Do you want a card [y/n] ?");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equalsIgnoreCase("y")) {
            return true;
        } else if (str.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("Please answer with y or n, let me ask you again");

            return askedCard();
        }
    }
}
