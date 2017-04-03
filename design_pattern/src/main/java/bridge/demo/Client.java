package bridge.demo;

/**
 * Created by wjk on 16/8/14.
 */
public class Client {
    public static void main(String[] args) {
        Brand brand = new Dell();
        Computer computer = new DesktopComputer(brand);
        computer.sale();
    }
}
