package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleRunnableWithExecutorService;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ExecuteTaskTest {

    @Before
    public void setLogger(){
        File propertiesFile = new File(String.format("%s%s", this.getClass()
                .getResource("/").getPath(), "Log4J_config.properties"));

        PropertyConfigurator.configure(propertiesFile.toString());
    }

    @Test
    public void testExecuteTask() throws Exception {

        new ExecuteTask().executeTask();
    }
}