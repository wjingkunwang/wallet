package jvm.gc;

/**
 * finalize()方法只执行一次
 * gc线程优先级地，无法确定啥时候执行，不可靠
 * 建议是try catch finally
 */
public class ObjRev {
    public static ObjRev objRev;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize()方法执行");
        objRev = this;
    }

    public static void main(String[] args) throws InterruptedException {
        objRev = new ObjRev();
        objRev = null;
        System.gc();//第一次gc
        Thread.sleep(1000);
        if (objRev == null) {
            System.out.println("第一次gc:对象已不存在");
        } else {
            System.out.println("第一次gc:对象存在");
        }

        objRev = null;
        System.gc();//第二次gc
        Thread.sleep(1000);
        if (objRev == null) {
            System.out.println("第二次gc:对象已不存在");
        } else {
            System.out.println("第二次gc:对象存在");
        }


    }
}
