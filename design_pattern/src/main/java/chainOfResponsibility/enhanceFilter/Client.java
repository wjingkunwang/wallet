package chainOfResponsibility.enhanceFilter;


/**
 * web中的链条还要折回来，并且response处理的顺序和request的顺序相反。
 */
public class Client {
    public static void main(final String[] args) {
        String msg = "< > English";
        Request request = new Request();
        //客户端设置需要处理的String
        request.setReqStr(msg);
        Response response = new Response();
        //讲客户端处理好的参数赋给服务器端
        response.setResStr(request.getReqStr());
        //FilterChain中添加Filter
        FilterChain fc = new FilterChain();
        fc.add(new FaceFilter());
        fc.add(new EnglishFilter());
        //执行FilterChain
        fc.doFilter(request, response, fc);
        System.out.println(request.getReqStr());
        System.out.println();
        System.out.println(response.getResStr());
    }
}
