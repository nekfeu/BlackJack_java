import java.util.Scanner;

/**
 * Menu class
 *
 * @author Kevin Empociello
 * @version 1.0
 */

public class Menu {

    /**
     * Display the menu
     */
    public void display() {
        System.out.println("");

        System.out.println("1- Create a new deck");
        System.out.println("2- Deal 4 cards and show the number of remainer cards");
        System.out.println("3- Shuffle the card and show the cards");
        System.out.println("4- Play the Blackjack game");
        System.out.println("5- Exit");

        System.out.println("\nWhat is your choice ?");
    }

    /**
     * Get the user input
     *
     * @return the index of the menu selected
     */
    public int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int choice;

        try {
            choice = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid number");

            return getUserChoice();
        }

        return choice;
    }
}
