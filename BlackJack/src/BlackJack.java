import java.lang.reflect.Array;

public class BlackJack {

    Deck deck = new Deck();

    public BlackJack() {
        System.out.println("Creation du Black Jack");

        deck.init();
        deck.display();
        deck.shuffle();
        deck.display();
    }

    public void play() {

    }
}
