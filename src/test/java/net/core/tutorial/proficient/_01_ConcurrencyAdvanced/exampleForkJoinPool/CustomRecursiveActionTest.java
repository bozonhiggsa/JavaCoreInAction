package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleForkJoinPool;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class CustomRecursiveActionTest {

    @Before
    public void setLogger(){
        File propertiesFile = new File(String.format("%s%s", this.getClass()
                .getResource("/").getPath(), "Log4J_config.properties"));

        PropertyConfigurator.configure(propertiesFile.toString());
    }

    @Test
    public void testCompute() throws Exception {

        String workload = "Some hard work fhfnfgkdjgbdjkhgiduhgkjdbhgksghfdlskghklsd";

        new CustomRecursiveAction(workload).compute();
    }
}