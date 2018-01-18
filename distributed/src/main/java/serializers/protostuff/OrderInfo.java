package serializers.protostuff;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by wjk on 2017/11/8.
 */
@Setter
@Getter
public class OrderInfo {
    /**
     * 订单流水
     */
    private String orderNo;
    /**
     * 订单概要信息
     */
    private Map<String, Object> orderItem;
    /**
     * 订单扩展信息
     */
    private List<OrderExt> orderExts;

    /**
     * 收货信息
     */
    private DelieryAddress address;
}
