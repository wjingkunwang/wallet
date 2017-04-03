package strategy;

/**
 * Created by wjk on 16/2/26.
 */
public class IntermediateMember implements MemberStrategy {

    public void calcPrice() {
        System.out.println("中级会员有0.8的折扣");
    }
}
