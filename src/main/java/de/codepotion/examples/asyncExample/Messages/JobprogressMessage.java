package de.codepotion.examples.asyncExample.Messages;

/**
 * Created by Frenos on 23.08.2016.
 */
public class JobprogressMessage {
    private String jobName;
    private String state;
    private int progress;

    public JobprogressMessage(String jobName)
    {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }

    public String getState() {
        return state;
    }

    public int getProgress() {
        return progress;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
