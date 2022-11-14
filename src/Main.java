import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CardGenerator cg = new CardGenerator();
        Hand hand = new Hand();
        CalculateWinner cw = new CalculateWinner();

        Player p1 = new Player("Ondra Zeman", hand.generateHand(cg.generate()));
        Player p2 = new Player("Steve Jobs", hand.generateHand(cg.generate()));
        Player p3 = new Player("Mark Zuckenberg", hand.generateHand(cg.generate()));
        Player[] players = {p1, p2, p3};

        System.out.println(cw.calculate(players));

    }
}