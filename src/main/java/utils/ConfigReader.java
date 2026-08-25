package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop = new Properties();
    static{
        try{
        FileInputStream file=new FileInputStream("src/test/resources/config.properties");
        prop.load(file);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
         return prop.getProperty(key);
    }
    
}
