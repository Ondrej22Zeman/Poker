import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateWinner {
    public String calculate(Player[] players) {
        Player winner = null;
        ArrayList<Player> winners = new ArrayList<Player>();
        boolean multipleWinners = false;

        for (Player player :
                players) {

            int redCounter = 0;
            int blackCounter = 0;
            boolean sameShape = true;
            boolean sameColor = false;
            boolean sequence = true;
            int[] sameRankFirst = {1, 0};
            int[] sameRankSecond = {1, 0};
            Card[] hand = player.getHand();


            for (int i = 0; i < hand.length - 1; i++) {
                if (!(hand[i].getShape() == hand[i + 1].getShape())) {
                    sameShape = false;
                }
            }

            for (int i = 0; i < hand.length; i++) {
                if (hand[i].getColor() == Color.red) {
                    redCounter++;
                } else {
                    blackCounter++;
                }
            }
            sameColor = redCounter == 5 || blackCounter == 5;


            Card[] temp = player.getHand();
            System.out.println("-----------------");
            for (Card card :
                    temp) {
                System.out.println(card.toString());
            }
            System.out.println("-----------------");

            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getValue() == (hand[i + 1].getValue() - 1)) {
                } else if (hand[i].getValue() == hand[i + 1].getValue() - 9) {
                } else {
                    sequence = false;
                }
            }

            ArrayList<Integer> sameRanks = new ArrayList<Integer>();
            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getValue() == hand[i + 1].getValue()) {
                    if (!sameRanks.contains(hand[i].getValue()) && sameRankFirst[0] > 1) {
                        sameRankSecond[1] = hand[i].getValue();
                        sameRankSecond[0]++;
                        continue;
                    }
                    sameRanks.add(hand[i].getValue());
                    sameRankFirst[1] = hand[i].getValue();
                    sameRankFirst[0]++;
                }
            }
            int combinationValue;
            int highestCard = 0;


            if (sameShape && sequence) {
                if (hand[0].getValue() == 1) {
                    System.out.println(player.getName() + " got Royal flush!");
                    combinationValue = 99999;
                } else {
                    System.out.println(player.getName() + " got Straight flush");
                    combinationValue = 500;
                }

            } else if (sameRankFirst[0] == 4) {
                System.out.println(player.getName() + " got Four of a kind!");
                combinationValue = 400;
                highestCard = sameRankFirst[1] == 1 ? 14 : sameRankFirst[1];

            } else if (sameRankFirst[0] == 3 && sameRankSecond[0] == 2 ||
                    sameRankFirst[0] == 2 && sameRankSecond[0] == 3) {
                System.out.println(player.getName() + " got Full house!");
                combinationValue = 200;
                highestCard = calcHighestCard(sameRankFirst[1], sameRankSecond[1]);

            } else if (sameShape) {
                System.out.println(player.getName() + " got Flush!");
                combinationValue = 150;
                highestCard = calcHighestCard(hand);

            } else if (sequence) {
                System.out.println("Straight!");
                combinationValue = 100;
                highestCard = calcHighestCard(hand);

            } else if (sameRankFirst[0] == 3) {
                System.out.println(player.getName() + " got Three of a kind!");
                player.setHandValue(60 + sameRankFirst[1]);
                combinationValue = 60;
                highestCard = calcHighestCard(sameRankFirst[1]);

            } else if (sameRankFirst[0] == 2 && sameRankSecond[0] == 2) {
                System.out.println(player.getName() + " got Two pairs!");
                combinationValue = 40;
                highestCard = calcHighestCard(sameRankFirst[1], sameRankSecond[1]);

            } else if (sameRankFirst[0] == 2 || sameRankSecond[0] == 2) {
                System.out.println(player.getName() + " got One pair!");
                combinationValue = 20;
                highestCard = calcHighestCard(sameRankFirst[1]);
            } else {
                int temp2; //if hand contains ace hand value is 14 not 1
                if (hand[0].getValue() == 1){
                    temp2 = 0;
                }else{
                    temp2 = hand.length-1;
                }
                System.out.println(player.getName() + " got Nothing! :(. His highest card is: " +
                        hand[temp2].toString());
                combinationValue = calcHighestCard(hand[temp2].getValue());
            }
            player.setHandValue(combinationValue + highestCard);


            if (winner == null) {
                winner = player;
            } else if (player.getHandValue() == winner.getHandValue()) {
                System.out.println("same");
                if (!winners.contains(winner)) {
                    winners.add(winner);
                    System.out.println("adding");
                }
                winners.add(player);
                multipleWinners = true;

            } else {
                if (player.getHandValue() > winner.getHandValue()) {
                    winners.clear();
                    winner = player;
                    multipleWinners = false;
                }
            }

            System.out.println(player.getName() + " got " + player.getHandValue() + " score");

        }



        if (multipleWinners) {
            String ret = "Draw! Players that drew are: ";
            int i = 1;

            for (Player p :
                    winners) {
                if (i<winners.size()) {
                    ret += p.getName() + ", ";
                }else{
                    ret += p.getName();
                }
                i++;
            }
            return ret;
        } else {
            return winner.getName() + " is the winner!!";

        }
    }

    private int calcHighestCard(Card[] hand){
        int ret = hand[0].getValue() == 1 ? 14 : hand[hand.length-1].getValue();
        return ret;
    }
    private int calcHighestCard(int card){
        int ret = card == 1 ? 14 : card;
        return ret;
    }
    private int calcHighestCard(int card1, int card2){
        int ret;
        if (card1 == 1 || card2 == 1){
            ret = 14;
        }else {
            ret = Math.max(card1, card2);
        }
        return ret;
    }
}
