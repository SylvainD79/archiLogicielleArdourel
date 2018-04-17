package plugins;

import appli.interfaces.AfficheurConsoleInterface;

public class AfficheurConsole2 implements AfficheurConsoleInterface {

    @Override
    public void affiche(String personneString) {
        System.out.println("Afficheur 1 : " + personneString);
    }

}
