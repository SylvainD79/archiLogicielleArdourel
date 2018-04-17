package loader;

import appli.Appli;
import appli.interfaces.AfficheurConsoleInterface;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Loader {

    private static List<DescripteurPlugin> descripteursAutorun = new ArrayList<>();

    private static List<Class> mesAutorun = new ArrayList<>();


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("coucou");

        descripteursAutorun = chargementDescripteursAutorun();

        // chargement des class
        for(DescripteurPlugin descripteurAutorun : descripteursAutorun){
            mesAutorun.add(lancementAutorun(descripteurAutorun));
        }

        System.out.println("Mes plugin disponibles :");
        for(Class maClass : mesAutorun){
            System.out.println(maClass.getName());
        }

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        //appel du constructeur.
        mesAutorun.get(choix).newInstance();


        //lancement de mon pllugin quand je veux
    }

    /**
     * Classe de chargement du fichier des properties permettant de d'obtenir l'ensemble des descripteurs
     * @return
     */
    public static List<DescripteurPlugin> chargementDescripteursAutorun() {
        Properties props = new Properties();
        List<DescripteurPlugin> descripteurAutorun = new ArrayList<>();
        try {
            props.load(new FileReader("file.properties"));
            List<String> availablePlugin = Arrays.asList(props.getProperty("autorun").split(","));
            for(String s : availablePlugin) {
                descripteurAutorun.add(new DescripteurPlugin(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return descripteurAutorun;
        }
    }


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
     * chargement automatique des classe
     * @param descripteurPlugin
     * @return
     */
    public static Class lancementAutorun(DescripteurPlugin descripteurPlugin){
        Class<?> cl  = null;
        try {
            cl = Class.forName(descripteurPlugin.getNomClasse());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cl;
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}
