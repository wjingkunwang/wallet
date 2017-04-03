package bridge.demo;

import lombok.AllArgsConstructor;

/**
 * Created by wjk on 16/8/14.
 */
@AllArgsConstructor
public class DesktopComputer extends Computer {
    private Brand brand;
    @Override
    public void sale() {
        brand.sale();
        System.out.println("台式机");
    }
}
