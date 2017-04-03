package proxy;

/**
 * Created by wjk on 16/6/16.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = new Proxy(subject);
        proxy.print();
    }
}
