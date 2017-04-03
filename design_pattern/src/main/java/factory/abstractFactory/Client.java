package factory.abstractFactory;

/**
 * Created by wjk on 16/2/26.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("**********第一天吃西餐***********");
        BreakfastFactory breakfast = new WestBreakfast();
        breakfast.makeDrink().drink();
        breakfast.makeFood().eat();
        System.out.println("**********第一天吃中餐***********");
        breakfast = new EastBreakfast();
        breakfast.makeDrink().drink();
        breakfast.makeFood().eat();
    }
}
