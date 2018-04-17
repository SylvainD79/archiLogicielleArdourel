package plugins;

import appli.interfaces.AfficheurConsoleInterface;

public class AfficheurConsole implements AfficheurConsoleInterface {

    @Override
    public void affiche(String personneString) {
        System.out.println("Afficheur 0 : " + personneString);
    }

}
