package serializers.protostuff;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wjk on 2017/11/8.
 */
@Getter
@Setter
public class OrderExt {
    /**
     * 订单流水
     */
    private String orderNo;
    /**
     * 商品编码
     */
    private String goodsNo;
}
