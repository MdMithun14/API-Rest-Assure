import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SetUp {
    Properties prop;
    FileInputStream File;
    @BeforeTest
    public void initConfig() throws IOException {
        prop = new Properties();
        File = new FileInputStream("./src/test/resources/config.properties");
        prop.load(File);

    }
}
