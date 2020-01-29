package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleRunnableWithExecutorService;

import org.apache.log4j.Logger;

public class EventLoggingTask implements Runnable {
    private Logger logger
            = Logger.getLogger(EventLoggingTask.class.getName());

    @Override
    public void run() {
        logger.info("Message");
    }
}
