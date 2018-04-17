package loader;

import appli.interfaces.AfficheurConsoleInterface;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Loader {

    /**
     * Classe de chargement du fichier des properties permettant de d'obtenir l'ensemble des descripteurs
     * @return
     */
    public static List<DescripteurPlugin> envoiDescripteurs() {
        Properties props = new Properties();
        List<DescripteurPlugin> descripteurPluginList = new ArrayList<>();
        try {
            props.load(new FileReader("file.properties"));
            List<String> availablePlugin = Arrays.asList(props.getProperty("class").split(","));
            for(String s : availablePlugin) {
                descripteurPluginList.add(new DescripteurPlugin(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return descripteurPluginList;
        }
    }

    /**
     * Renvoie le plugin (l'afficheur) en fonction du choix
     * @param choix
     * @return
     */
    public static Object donnePlugin(DescripteurPlugin choix) {
        Properties props = new Properties();
        Object o = null;
        try {
            props.load(new FileReader("file.properties"));
            Class<?> cl = Class.forName(choix.getNomClasse());
            //Vérifie si la classe cl est un super type de AfficheurConsoleInterface
            o = cl.newInstance();
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
