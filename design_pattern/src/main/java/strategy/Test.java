package strategy;

/**
 * 策略模式:策略模式是分装算法,不关心算法的具体实现,而是关系如何组织和调用这些算法
 *
 * 类图地址:http://7xpxnz.com1.z0.glb.clouddn.com/%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F.png
 *
 */
public class Test {
    public static void main(String[] args) {
        PrimaryMember primaryMember = new PrimaryMember();
        Price price = new Price(primaryMember);
        price.quote();
    }
}
