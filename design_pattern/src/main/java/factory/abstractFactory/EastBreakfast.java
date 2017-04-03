package factory.abstractFactory;

/**
 * Created by wjk on 16/2/26.
 */
public class EastBreakfast implements BreakfastFactory {
    public Food makeFood() {
        return new EastFood();
    }

    public Drink makeDrink() {
        return new EastDrink();
    }
}
