public class CardGenerator {

    public Card[] generate(){
        Card[] cards = new Card[52];
        int x = 1;
        int shapeSwitcher = 0;
        for (int i = 0; i < cards.length; i++) {
            if (i<(cards.length/2)){
                cards[i] = new Card(Color.red);
            }else{
                cards[i] = new Card(Color.black);
            }

            if (i % 13 == 0 && i != 0) {
                x = 1;
                shapeSwitcher++;
            }
            switch (shapeSwitcher) {
                case (0) -> cards[i].setShape(Shapes.diamonds);
                case (1) -> cards[i].setShape(Shapes.hearts);
                case (2) -> cards[i].setShape(Shapes.clubs);
                case (3) -> cards[i].setShape(Shapes.spades);
            }
            cards[i].setValue(x);
            x++;
        }
        return cards;
    }

    public CardGenerator() {
    }



}
