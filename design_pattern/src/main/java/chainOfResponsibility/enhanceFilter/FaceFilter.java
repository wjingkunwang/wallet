package chainOfResponsibility.enhanceFilter;


/**
 * Created by wjk on 16/7/5.
 */
public class FaceFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        request.reqStr = request.reqStr.replace(":) ", "^V^ ");
        chain.doFilter(request, response, chain);
        response.resStr = response.resStr.replace("^V^ ", ":) ");
    }
}
