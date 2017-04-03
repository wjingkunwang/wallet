package factory.factoryMethod;

/**
 * Created by wjk on 16/8/13.
 */
public class WomanFactory extends HumanFactory {
    @Override
    public Human createHuman() {
        return new Woman();
    }
}
