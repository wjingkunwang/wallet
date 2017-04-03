package observer.job;

/**
 * Created by wjk on 16/7/9.
 */
public class ConcreteSeeker implements JobSeeker {
    private String name;

    public ConcreteSeeker(String name) {
        this.name = name;
    }

    public void update(Headhunter headhunter) {
        headhunter.haveAJob(name);
    }

    public boolean getJobMessage() {
        return true;
    }
}
