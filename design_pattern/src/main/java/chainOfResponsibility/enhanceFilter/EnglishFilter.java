package chainOfResponsibility.enhanceFilter;


/**
 * Created by wjk on 16/7/5.
 */
public class EnglishFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        request.reqStr = request.reqStr.replace("English", "英文");
        chain.doFilter(request,response,chain);
        response.resStr = response.resStr.replace("英文","English");
    }
}
