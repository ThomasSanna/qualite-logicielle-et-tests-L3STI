public class Controler {
    private Jeu jeu;
    private IHM ihm;

    public Controler(Jeu jeu, IHM ihm) {
        this.jeu = jeu;
        this.ihm = ihm;
    }

    public void ajouterJoueur(String nom) {
        jeu.ajouterJoueur(nom);
    }

    public void lancerBataille() {
        Bataille bataille = new Bataille(jeu.getGestionJoueurs(), jeu.getLancerDe(), ihm);
        bataille.jouer();
    }
}