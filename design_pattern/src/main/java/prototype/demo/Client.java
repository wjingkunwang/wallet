package prototype.demo;

import lombok.AllArgsConstructor;

/**
 * Created by wjk on 16/8/14.
 */
@AllArgsConstructor
public class Client {
    private Prototype prototype;

    public void operation(){
        Prototype newPrototype = prototype.clone();
    }
}
