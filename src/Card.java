public class Card implements Comparable<Card>{
    private Color color;
    private Shapes shape;
    private int value;

    public Card(Color color, Shapes shape, int value) {
        this.color = color;
        this.shape = shape;
        this.value = value;
    }

    public Card(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shapes getShape() {
        return shape;
    }

    public void setShape(Shapes shape) {
        this.shape = shape;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String trueValue = null;
        switch (value){
            case (1):
                trueValue = "Ace";
                break;
            case (11):
                trueValue = "Jack";
                break;
            case (12):
                trueValue = "Queen";
                break;
            case (13):
                trueValue = "King";
                break;
            default:
                trueValue = Integer.toString(value);
        }
        return "Karta " +
                "color=" + color +
                ", shape=" + shape +
                ", value='" + trueValue + '\'';
    }

    @Override
    public int compareTo(Card o) {
        return this.value - o.value;
    }
}
