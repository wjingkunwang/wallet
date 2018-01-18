package rpc;

/**
 * Created by wjk on 2017/11/7.
 */
public class EchoServiceImpl implements EchoService {
    public String echo(String ping) {
        return ping != null ? ping + " I am ok" : "I am ok";
    }
}
