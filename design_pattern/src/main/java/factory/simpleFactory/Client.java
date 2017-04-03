package factory.simpleFactory;

/**
 * Created by wjk on 16/8/13.
 */
public class Client {
    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory();
        Human man = factory.createHuman("man");
        man.print();
    }
}
