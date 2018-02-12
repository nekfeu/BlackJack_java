/**
 * BlackJack class managing the entire game
 *
 * @author Kevin Empociello
 * @version 1.0
 */


public class BlackJack {

    /**
     * The deck containing the cards to play BlackJack
     * @see Deck
     */
    public Deck deck = new Deck();

    /**
     * The player which represent the user who is playing
     * @see Player
     */
    Player player = new Player(false);

    /**
     * The player which represent the IA (computer)
     * @see Player
     */
    Player dealer = new Player(true);

    /**
     * Current bet chosen by the player
     */
    int currentBet = 0;

    /**
     * Initialize the game (init deck, shuffle and start the game)
     */
    public BlackJack() {
        System.out.println("\nWelcome in NekBlackJack!\n");

        deck.init();
        deck.shuffle();
        deck.shuffle();

        play();
    }

    /**
     * Initialize the player's hand and the IA's hand
     */
    private void firstDistribute() {
        player.receiveCard(deck.pop());
        player.receiveCard(deck.pop());
        player.displayHand();

        dealer.receiveCard(deck.pop());
        dealer.displayHand();
    }

    /**
     * Check if the computer won or if the player won and display
     */
    private void checkWinner() {
        if ((player.getHandSum() > dealer.getHandSum() || dealer.getHandSum() > 21) && player.getHandSum() <= 21) {
            System.out.println("You won");

            player.earn(currentBet);
        } else if ((player.getHandSum() <= dealer.getHandSum() || player.getHandSum() > 21) && dealer.getHandSum() <= 21) {
            System.out.println("Dealer won");
        }
    }

    /**
     * Play loop
     * Display porfolio, choose bet, ask a card or not
     */
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
            deck.check();
        }
    }
}
