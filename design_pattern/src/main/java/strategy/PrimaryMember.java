package strategy;

/**
 * Created by wjk on 16/2/26.
 */
public class PrimaryMember implements MemberStrategy {

    public void calcPrice() {
        System.out.println("初级会员没有折扣");
    }
}
