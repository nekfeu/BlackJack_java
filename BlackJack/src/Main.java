/**
 * Main
 * Creating the Menu and managing the deck, game.
 *
 * @author Kevin Empociello
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Deck deck = null;

        while (true) {
            menu.display();

            int choice = menu.getUserChoice();
            switch (choice) {
                case 1:
                    deck = new Deck();
                    deck.init();

                    break;
                case 2:
                    if (deck == null) {
                        deck = new Deck();
                        deck.init();
                    }

                    deck.check();
                    for (int i = 0; i <= 3; i++) {
                        deck.pop();
                    }

                    System.out.println("Number of remainer cards = " + deck.getNumberOfRemainerCards());

                    break;
                case 3:
                    if (deck == null) {
                        deck = new Deck();
                        deck.init();
                    }

                    deck.shuffle();
                    deck.display();

                    break;
                case 4:
                    new BlackJack();

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Please enter a number between 1 and 5");
            }
        }
    }
}
