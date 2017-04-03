package observer.job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wjk on 16/7/9.
 */
public abstract class Headhunter {
    List<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();

    public void addJobSeeker(JobSeeker seeker) {
        jobSeekerList.add(seeker);
    }

    public void removeJobSeeker(JobSeeker seeker) {
        jobSeekerList.remove(seeker);
    }

    public void haveAJob(String name) {
        System.out.println(name + "有一个BAT的工作机会");
    }

    public void notifyJobSeeker() {
        for (JobSeeker seeker : jobSeekerList) {
            if (seeker.getJobMessage()) {
                seeker.update(this);
            }
        }
    }
}
