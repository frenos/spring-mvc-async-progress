package de.codepotion.examples.async.jobs;

/**
 * Created by Frenos on 18.08.2016.
 */
interface DetailedJob extends Runnable {
    int getProgress();

    String getState();

    String getJobName();
}
