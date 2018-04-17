package plugins;

import appli.interfaces.AfficheurConsoleInterface;

public class AfficheurConsole3 implements AfficheurConsoleInterface {

    @Override
    public void affiche(String personneString) {
        System.out.println(personneString + "2");
    }

}
