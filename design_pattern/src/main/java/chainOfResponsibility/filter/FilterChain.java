package chainOfResponsibility.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjk on 16/7/5.
 */
public class FilterChain implements Filter {
    List<Filter> filterList = new ArrayList<Filter>();

    void add(List<Filter> filters) {
        filterList.addAll(filters);
    }

    public String doFilter(String str) {
        String r = str;
        for (Filter filter : filterList) {
            r = filter.doFilter(r);
        }
        return r;
    }
}
