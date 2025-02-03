class Jeu {
    private GestionJoueurs gestionJoueurs;
    private LancerDe lancerDe;

    public Jeu() {
        gestionJoueurs = new GestionJoueurs();
        lancerDe = new LancerDe();
    }

    public void ajouterJoueur(String nom) {
        gestionJoueurs.ajouterJoueur(nom);
    }

    public GestionJoueurs getGestionJoueurs() {
        return gestionJoueurs;
    }

    public LancerDe getLancerDe() {
        return lancerDe;
    }
}