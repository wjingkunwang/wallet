package rpc;


import java.net.InetSocketAddress;

/**
 * Created by wjk on 2017/11/7.
 */
public class RpcTest {
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8888);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService service = importer.getRemoteProxyObj(EchoServiceImpl.class, new InetSocketAddress("localhost", 8888));
        System.out.println(service.echo("小明"));
    }
}
