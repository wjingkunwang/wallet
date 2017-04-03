package strategy;

/**
 * Created by wjk on 16/2/26.
 */
public class Price {
    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    void  quote(){
         this.memberStrategy.calcPrice();
    }
}
