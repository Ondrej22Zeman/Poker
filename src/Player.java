import java.util.Arrays;

public class Player {
    private String name;
    private Card[] hand;
    private int handValue;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", handValue=" + handValue +
                '}';
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public Player(String name, Card[] hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}
