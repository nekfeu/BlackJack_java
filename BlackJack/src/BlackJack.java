import java.lang.reflect.Array;
import java.util.Scanner;

public class BlackJack {

    Deck deck = new Deck();
    Player player = new Player(false);
    Player dealer = new Player(true);

    public BlackJack() {
        System.out.println("Creation du Black Jack");

        deck.init();

        deck.shuffle();
        deck.shuffle();

        deck.display();

        System.out.println("");
        play();
    }

    private int chooseBet() {
        System.out.println("How much do you want to bet ?");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int bet = 0;

        try {
            bet = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid number");

            return chooseBet();
        }

        return bet;
    }

    public void play() {
        int currentBet = 0;

        while (player.getMoney() > 0) {

            if (!player.isDealer()) {
                player.displayPortfolio();

                currentBet = chooseBet();
                System.out.println("currentBet = " + currentBet);

            } else {
                // dealer's turn;
            }
        }

    }
}
