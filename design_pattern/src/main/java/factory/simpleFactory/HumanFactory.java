package factory.simpleFactory;

/**
 * Created by wjk on 16/8/13.
 */
public class HumanFactory {
    public Human createHuman(String type){
        if("man".equals(type)){
            return new Man();
        }else if("woman".equals(type)){
            return new Woman();
        }else {
            return null;
        }
    }
}
