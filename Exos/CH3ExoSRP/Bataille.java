class Bataille {
    private GestionJoueurs gestionJoueurs;
    private LancerDe lancerDe;
    private IHM ihm;

    public Bataille(GestionJoueurs gestionJoueurs, LancerDe lancerDe, IHM ihm) {
        this.gestionJoueurs = gestionJoueurs;
        this.lancerDe = lancerDe;
        this.ihm = ihm;
    }

    public void jouer() {
        int nbGagnants = 0, score, max = 0;
        String nomsGagnants = "";
        String res;
        for (String nom : gestionJoueurs.getJoueurs()) {
            score = jouerUnTour();
            if (score > max) {
                max = score;
                nbGagnants = 1;
                nomsGagnants = nom;
            } else if (score == max) {
                nbGagnants += 1;
                nomsGagnants += "-" + nom;
            }
            ihm.afficherScore(nom, score);
        }
        if (nbGagnants == 1)
            res = "Le gagnant est ";
        else
            res = "Il y a " + nbGagnants + " exaequo :";
        res += nomsGagnants;
        ihm.afficherResultat(res);
    }

    private int jouerUnTour() {
        int total = 0;
        for (int i = 0; i < 2; i++) {
            total += lancerDe.lancer();
        }
        return total;
    }
}