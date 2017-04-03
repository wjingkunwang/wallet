package factory.abstractFactory;

/**
 * Created by wjk on 16/2/26.
 */
public class WestBreakfast implements BreakfastFactory {
    public Food makeFood() {
        return new WestFood();
    }

    public Drink makeDrink() {
        return new WestDrink();
    }
}
