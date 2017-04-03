package chainOfResponsibility.filter;

import lombok.Data;

/**
 * Created by wjk on 16/7/5.
 */
@Data
public class MsgProcessor {
    //省略setter，getter方法
    private String msg;
    FilterChain fc;

    public String process() {
        return fc.doFilter(msg);
    }
}
