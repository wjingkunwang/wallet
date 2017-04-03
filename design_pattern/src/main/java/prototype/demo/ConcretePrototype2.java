package prototype.demo;

/**
 * Created by wjk on 16/8/14.
 */
public class ConcretePrototype2  implements Prototype {
    public Prototype clone() {
        return new ConcretePrototype2();
    }
}
