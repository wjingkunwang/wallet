package serializers.protostuff;

import java.util.*;

/**
 * Created by wjk on 2017/11/8.
 */
public class ProtostuffTest {
    public static void main(String[] args) {
        OrderInfo oldOrder = createOrder();
        System.out.println(oldOrder);

        byte[] orderinfo = SerializationUtils.serializer(oldOrder);

        OrderInfo neOrder = SerializationUtils.deserializer(orderinfo, OrderInfo.class);

        System.out.println(neOrder);
        System.out.println(neOrder.getOrderNo() == null ? "y" : "n");
    }

    private static OrderInfo createOrder(){
        OrderInfo orderInfo = new OrderInfo();
        DelieryAddress delieryAddress = new DelieryAddress();
        List<OrderExt> orderExts = new LinkedList<OrderExt>();

        for(int i=0; i<2; i++){
            OrderExt orderExt = new OrderExt();
            orderExt.setGoodsNo("343434");
            orderExt.setOrderNo("12345");
            orderExts.add(orderExt);
        }

        delieryAddress.setAddress("江苏南京");
        delieryAddress.setConsigneeName("熊猫");
        delieryAddress.setExpectTime(new Date());

        Map<String, Object> orderItem = new HashMap<String, Object>();
        orderItem.put("google","google.com");
        orderItem.put("baidu", "baidu.com");

        orderInfo.setOrderItem(orderItem);
        orderInfo.setAddress(delieryAddress);
        orderInfo.setOrderExts(orderExts);

        return orderInfo;
    }
}
