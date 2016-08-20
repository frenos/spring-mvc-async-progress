package de.codepotion.examples.asyncExample;

import de.codepotion.examples.asyncExample.jobs.ExampleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Frenos on 18.08.2016.
 */
@Controller
public class WebController {


    private final asyncService myService;
    private static int jobNumber;

    @Autowired
    private ThreadPoolTaskExecutor myExecutor;

    private ArrayList<ExampleJob> myJobList = new ArrayList<>(5);

    @Autowired
    WebController(asyncService myService) {
        this.myService = myService;
    }

    @RequestMapping("/trigger")
    @ResponseBody
    public void startWork() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this + "START startWork");

            ExampleJob newJob = new ExampleJob("Job-" + jobNumber);
            jobNumber = jobNumber + 1;
            myJobList.add(newJob);
            myService.doWork(newJob);
            System.out.println(this + "END startWork");
        }
    }

    @RequestMapping(value = "/status")
    @ResponseBody
    ArrayList<ExampleJob> fetchStatus() {
        return this.myJobList;
    }

    @RequestMapping(value = "/poolsize/{newSize}")
    @ResponseBody
    public void setNewPoolsize(@PathVariable("newSize") int id) {
        myExecutor.setCorePoolSize(id);
    }
}
