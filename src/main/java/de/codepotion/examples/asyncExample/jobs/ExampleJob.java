package de.codepotion.examples.asyncExample.jobs;

import de.codepotion.examples.asyncExample.Messages.JobprogressMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Frenos on 18.08.2016.
 */
public class ExampleJob implements DetailedJob {

    private SimpMessagingTemplate template;


    private int loops = 20;
    private AtomicInteger progress = new AtomicInteger();
    private String state = "NEW";
    private Random myRandom = new Random();

    private String jobName = "";

    public ExampleJob(String jobName, SimpMessagingTemplate template) {
        this.jobName = jobName;
        this.template = template;
        sendProgress();
    }


    ExampleJob(int loops) {
        this.loops = loops;
    }

    @Override
    public void run() {
        state = "RUNNING";
        sendProgress();
        for (double i = 0.0; i <= loops; i++) {
            try {
                Thread.sleep(1000);
                Thread.sleep(myRandom.nextInt(5000));
                progress.set((int) ((i / loops) * 100));
                sendProgress();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state = "DONE";
        sendProgress();
    }

    public void sendProgress() {
        JobprogressMessage temp = new JobprogressMessage(jobName);
        temp.setProgress(progress.get());
        temp.setState(state);

        template.convertAndSend("/topic/status", temp);
    }

    @Override
    public int getProgress() {
        return progress.get();
    }

    public String getState() {
        return state;
    }

    public String getJobName() {
        return jobName;
    }
}
