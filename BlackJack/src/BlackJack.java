import java.lang.reflect.Array;
import java.util.Scanner;

public class BlackJack {

    Deck deck = new Deck();
    Player player = new Player(false);
    Player dealer = new Player(true);
    int currentBet = 0;

    public BlackJack() {
        System.out.println("\nWelcome in NekBlackJack!\n");

        deck.init();
        deck.shuffle();
        deck.shuffle();

        play();
    }

    private void firstDistribute() {
        player.receiveCard(deck.pop());
        player.receiveCard(deck.pop());
        player.displayHand();

        dealer.receiveCard(deck.pop());
        dealer.displayHand();
    }

    private void checkWinner() {
        if ((player.getHandSum() > dealer.getHandSum() || dealer.getHandSum() > 21) && player.getHandSum() <= 21) {
            System.out.println("You won");

            player.earn(currentBet);
        } else if ((player.getHandSum() <= dealer.getHandSum() || player.getHandSum() > 21) && dealer.getHandSum() <= 21) {
            System.out.println("Dealer won");
        }
    }

    private void play() {
        while (player.getMoney() > 0) {

            player.displayPortfolio();
            currentBet = player.chooseBet();
            player.displayPortfolio();

            firstDistribute();

            while (player.getHandSum() < 21 && player.askedCard()) {
                player.receiveCard(deck.pop());
                player.displayHand();
            }

            dealer.displayHand();
            while (dealer.getHandSum() < 17 && player.getHandSum() < 21) {
                System.out.println("Dealer is receiving a card ...");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                dealer.receiveCard(deck.pop());
                dealer.displayHand();
            }

            checkWinner();
            player.clearHand();
            dealer.clearHand();
        }

    }
}
