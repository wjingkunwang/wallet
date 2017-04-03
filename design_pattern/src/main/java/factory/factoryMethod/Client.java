package factory.factoryMethod;


/**
 * Created by wjk on 16/8/13.
 */
public class Client {
    public static void main(String[] args) {
        HumanFactory manFactory = new ManFactory();
        Human man = manFactory.createHuman();
        man.print();
    }
}
