import java.util.Scanner;

public class Player {

    private int money = 100;
    private boolean autoPlay;
    private Card[] hand = new Card[0];

    public Player(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public void clearHand() {
        hand = new Card[0];
    }

    public void displayHand() {
        System.out.println("");
        System.out.println(autoPlay ? "-- Dealer hand --" : "-- Your hand --");

        for (Card card: hand) {
            System.out.println(card.toString());
        }

        System.out.println("--  TOTAL " + this.getHandSum() + "  --\n" );
    }

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

    public int getMoney() {
        return this.money;
    }

    public void earn(int money) {
        this.money += (money * 2);
    }

    public void loose(int money) {
        this.money -= money;
    }

    public void displayPortfolio() {
        System.out.println("Your wallet: " + this.money + "$");
    }

    public boolean isDealer() {
        return this.autoPlay;
    }

    public void receiveCard(Card card) {
        Card[] newHand = new Card[hand.length + 1];
        int index = 0;

        for (Card oneCard: hand) {
            newHand[index++] = oneCard;
        }

        newHand[index] = card;
        hand = newHand;
    }

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
