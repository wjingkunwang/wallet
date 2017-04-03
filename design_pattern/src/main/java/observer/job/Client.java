package observer.job;

/**
 * Created by wjk on 16/7/9.
 */
public class Client {
    public static void main(String[] args) {
        Headhunter headhunter = new ConcreteHeadhunter();

        JobSeeker jobSeeker1 = new ConcreteSeeker("xiaoming");
        JobSeeker jobSeeker2 = new ConcreteSeeker("wangjingkun");

        headhunter.addJobSeeker(jobSeeker1);
        headhunter.addJobSeeker(jobSeeker2);

        headhunter.notifyJobSeeker();
    }
}
