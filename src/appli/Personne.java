package appli;

public class Personne {
    private String name;

    public Personne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void affiche(String s) {
        System.out.println(this.name);
    }
}
