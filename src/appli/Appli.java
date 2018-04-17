package appli;

import appli.interfaces.AfficheurConsoleInterface;
import loader.DescripteurPlugin;
import loader.Loader;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;
import java.util.Scanner;

public class Appli {
    private AfficheurConsoleInterface afficheurConsoleInterface;

    public Appli(){
        Personne p = new Personne("Nicolas");
        p.setName(p.getName() + " The  Bee");
        List<DescripteurPlugin> descripteurPluginList = Loader.envoiDescripteurs();
        int i = 0;
        for(DescripteurPlugin descripteurPlugin : descripteurPluginList) {
            System.out.println("position : " + i + " " + descripteurPlugin.getNomClasse());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        afficheurConsoleInterface = donneLAfficheur(descripteurPluginList.get(choix));
        affichePersonne(p.getName());
    }

    private AfficheurConsoleInterface donneLAfficheur(DescripteurPlugin desc){
        return (AfficheurConsoleInterface) Loader.donnePlugin(desc);
    }

    private void affichePersonne(String s){
        this.afficheurConsoleInterface.affiche(s);
    }

    public static void main(String[] args) {
        Appli appli = new Appli();
    }
}
