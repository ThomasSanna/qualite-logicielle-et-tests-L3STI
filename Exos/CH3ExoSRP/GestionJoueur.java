import java.util.ArrayList;

class GestionJoueurs {
  private ArrayList<String> lesJoueurs;

  public GestionJoueurs() {
      lesJoueurs = new ArrayList<>();
  }

  public void ajouterJoueur(String nom) {
      lesJoueurs.add(nom);
  }

  public ArrayList<String> getJoueurs() {
      return lesJoueurs;
  }
}