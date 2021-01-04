package selenium;

import java.io.*;
import java.util.Properties;

//OrpUtil类
public class OrpUtil {
    public static String readValue(String a) {
        Properties pro = new Properties();
        String popath = Contants.ObjectReUrl;
        String value = null;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(popath));
            try {
                pro.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = pro.getProperty(a);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;
    }
}
