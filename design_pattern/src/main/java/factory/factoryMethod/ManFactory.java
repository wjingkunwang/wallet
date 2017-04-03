package factory.factoryMethod;

/**
 * Created by wjk on 16/8/13.
 */
public class ManFactory extends HumanFactory {
    @Override
    public Human createHuman() {
        return new Man();
    }
}
