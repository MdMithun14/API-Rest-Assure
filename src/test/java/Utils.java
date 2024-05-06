import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utils {
    public static int genarateRandom(int min,int max){
      double randomId=  Math.random()*(max-min)+min;
      return (int) randomId;
    }

    public static void main(String[] args) {
       int rand= genarateRandom(10000,999999);
        System.out.println(rand);
    }
    public static void setEnvironment(String key,String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key,value);
        config.save();
    }
}
