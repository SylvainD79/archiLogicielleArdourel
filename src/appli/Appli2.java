package appli;

import appli.interfaces.AfficheurConsoleInterface;
import loader.DescripteurPlugin;
import loader.Loader;

import java.util.List;
import java.util.Scanner;

public class Appli2 {
    private AfficheurConsoleInterface afficheurConsoleInterface;

    public Appli2(){
        Personne p = new Personne("Sylvain");
        p.setName(p.getName() + " /20");
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

}
