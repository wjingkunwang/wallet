package decorator.monkey;

/**
 * Created by wjk on 16/3/22.
 */
public class Client {
    public static void main(String[] args) {
        Change bird = new Bird(new Monkey());
        bird.move();
    }
}
