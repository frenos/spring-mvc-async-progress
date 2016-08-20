package de.codepotion.examples.asyncExample;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Frenos on 18.08.2016.
 */
@Service
public class asyncService {
    @Async
    public void doWork(Runnable runnable) {
        System.out.println("Got runnable " + runnable);
        runnable.run();
    }
}
