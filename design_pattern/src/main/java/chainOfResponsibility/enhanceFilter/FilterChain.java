package chainOfResponsibility.enhanceFilter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjk on 16/7/5.
 */
public class FilterChain implements Filter {
    List<Filter> filterList = new ArrayList<Filter>();
    int index;

    void add(Filter filter) {
        filterList.add(filter);
    }

    public void doFilter(Request request, Response response, FilterChain chain) {
        if(index == filterList.size()) return ;

        Filter f = filterList.get(index);
        index ++;
        f.doFilter(request, response, chain);
    }
}
