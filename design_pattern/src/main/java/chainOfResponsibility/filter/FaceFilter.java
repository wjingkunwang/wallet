package chainOfResponsibility.filter;

/**
 * Created by wjk on 16/7/5.
 */
public class FaceFilter implements Filter {
    public String doFilter(String str) {
        return str.replace(":) ", "^V^ ");
    }
}
