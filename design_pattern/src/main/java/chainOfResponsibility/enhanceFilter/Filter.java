package chainOfResponsibility.enhanceFilter;

/**
 * Created by wjk on 16/7/5.
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
