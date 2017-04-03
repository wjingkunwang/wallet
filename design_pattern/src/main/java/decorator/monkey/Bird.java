package decorator.monkey;

/**
 * Created by wjk on 16/3/22.
 */
public class Bird extends Change {
    private TheGreatestSage theGreatestSage;
    public Bird(TheGreatestSage theGreatestSage) {
        super();
        this.theGreatestSage = theGreatestSage;
    }
    public void move() {
        theGreatestSage.move();
        super.move();
        System.out.println("flying");
    }
}
