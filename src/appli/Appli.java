package appli;

import appli.interfaces.AfficheurConsoleInterface;
import loader.Loader;

public class Appli {
    private AfficheurConsoleInterface afficheurConsoleInterface;

    public Appli(){
        Personne p = new Personne("Nicolas");
        p.setName(p.getName() + " The  Bee");
        afficheurConsoleInterface = donneLAfficheur();
        affichePersonne(p.getName());
    }

    private AfficheurConsoleInterface donneLAfficheur(){
        return (AfficheurConsoleInterface) Loader.donnePlugin("class", AfficheurConsoleInterface.class);
    }

    private void affichePersonne(String s){
        this.afficheurConsoleInterface.affiche(s);
    }

    public static void main(String[] args) {
        Appli appli = new Appli();
    }
}
