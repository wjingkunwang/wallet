import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
/**
 * Created by wjk on 2017/11/21.
 */
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
//        ThreadContext.put("name", "xiaoming");
//        ThreadContext.put("age", "18");
        MDC.put("name", "xiaoming");
        MDC.put("age", "18");
        LOGGER.trace("Learning3 log4j trace");
        LOGGER.debug("Learning3 log4j debug");
        LOGGER.info("Learning3 log4j info");
        LOGGER.warn("Learning3 log4j warn");
        LOGGER.error("Learning3 log4j error");

//        System.out.printf(ThreadContext.get("name") + "-" + ThreadContext.get("age"));
    }
}
