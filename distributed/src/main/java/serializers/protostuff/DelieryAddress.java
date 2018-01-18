package serializers.protostuff;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by wjk on 2017/11/8.
 */
@Setter
@Getter
public class DelieryAddress {
    /**
     * 收货地址
     */
    private String address;
    /**
     * 收货人
     */
    private String consigneeName;
    /**
     * 送达时间
     */
    private Date expectTime;
}
