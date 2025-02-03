public class Test {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        IHM ihm = new IHM();
        Controler controleur = new Controler(jeu, ihm);

        controleur.ajouterJoueur("Pierre");
        controleur.ajouterJoueur("Marie");
        controleur.ajouterJoueur("Jean");
        controleur.lancerBataille();
    }
}