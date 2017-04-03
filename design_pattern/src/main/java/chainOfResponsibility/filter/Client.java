package chainOfResponsibility.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个是一条直链
 */
public class Client {
    public static void main(final String[] args) {
        FilterChain chain = new FilterChain();
        final EnglishFilter englishFilter = new EnglishFilter();
        final FaceFilter faceFilter = new FaceFilter();
        final HtmlFilter htmlFilter = new HtmlFilter();

        List<Filter> filters = new ArrayList<Filter>() {{
            add(faceFilter);
            add(htmlFilter);
            add(englishFilter);

        }};

        chain.add(filters);

        MsgProcessor processor = new MsgProcessor();
        processor.setMsg(":) English < > ");
        processor.setFc(chain);
        processor.setMsg(processor.process());
        System.out.println(processor.getMsg());
    }
}
