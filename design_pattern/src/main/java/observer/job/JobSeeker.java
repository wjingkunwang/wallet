package observer.job;


/**
 * Created by wjk on 16/7/9.
 */
public interface JobSeeker {

    public void update(Headhunter headhunter);

    //添加一个熟悉表示是否pull
    public boolean getJobMessage();
}
