import java.util.*;

public class Hand{
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> usedCards = new ArrayList<>();


    public Card[] generateHand (Card[] cards){
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Card card = cards[random.nextInt(cards.length)];
            if (usedCards.contains(card)){
                System.out.println("CONTAINS");
                i--;
            }else{
                usedCards.add(card);
                hand.add(card);
            }
        }
        /*System.out.println("------------------------------------");
        for (Card card :
                hand) {
            System.out.println(card.toString());
        }
        System.out.println("--------");
        for (Card x :
                usedCards) {
            System.out.println(x);
        } */
        Card[] arrayHand = new Card[hand.size()];
        int counter = 0;
        for (Card card : hand) {
            arrayHand[counter]  = card;
            counter++;
        }
        hand.clear();

        Arrays.sort(arrayHand);
        System.out.println(usedCards.size());
        return arrayHand;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand=" + hand +
                ", usedCards=" + usedCards +
                '}';
    }
}
