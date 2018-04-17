package loader;

import appli.interfaces.AfficheurConsoleInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Loader {
    public static Object donnePlugin(String key, Class<?> interf) {
        Properties props = new Properties();
        Object o = null;
        try {
            props.load(new FileReader("file.properties"));
            Class<?> cl = Class.forName(props.getProperty(key));
            //Vérifie si la classe cl est un super type de AfficheurConsoleInterface
            if(interf.isAssignableFrom(cl)) {
                o = cl.newInstance();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return o;
    }
}
