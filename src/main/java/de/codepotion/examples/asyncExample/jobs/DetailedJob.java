package de.codepotion.examples.asyncExample.jobs;

/**
 * Created by Frenos on 18.08.2016.
 */
interface DetailedJob extends Runnable {
    int getProgress();

    String getStatus();

    String getJobName();
}
