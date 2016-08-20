package de.codepotion.examples.asyncExample.jobs;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Frenos on 18.08.2016.
 */
public class ExampleJob implements DetailedJob {

    private int loops = 20;
    private AtomicInteger progress = new AtomicInteger();
    private String status = "NEW";
    private Random myRandom = new Random();

    private String jobName = "";

    public ExampleJob(String jobName) {
        this.jobName = jobName;
    }


    ExampleJob(int loops) {
        this.loops = loops;
    }

    @Override
    public void run() {
        status = "RUNNING";
        for (double i = 0.0; i <= loops; i++) {
            try {
                Thread.sleep(1000);
                Thread.sleep(myRandom.nextInt(5000));
                progress.set((int) ((i / loops) * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        status = "DONE";
    }

    @Override
    public int getProgress() {
        return progress.get();
    }

    public String getStatus() {
        return status;
    }

    public String getJobName() {
        return jobName;
    }
}
