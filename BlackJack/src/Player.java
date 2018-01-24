public class Player {

    private int money = 100;
    private boolean autoPlay;

    public Player(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public int getMoney() {
        return this.money;
    }

    public void displayPortfolio() {
        System.out.println("Your wallet: " + this.money + "$");
    }

    public boolean isDealer() {
        return this.autoPlay;
    }
}
