public class Mystere {
  private int valeur; // La valeur du nb mystère
  private int valeurMax; // La valeur maximum possible

  public Mystere(int valeurMax) {
    this.valeurMax = valeurMax;
    generer();
  }

  public int getValeurMax() {
    return valeurMax;
  }

  public int getValeur() {
    return valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }

  public void generer() {
    // génère une valeur aléatoire comprise entre 0 et valeurMax et
    // l'affecte à la valeur du nombre mystère.
    this.valeur = (int) (Math.random() * (valeurMax + 1));
  }

  public int testProp(int proposition) {
    // renvoie 1 si le nombre est trouvé, 0 s'il est plus petit et
    // 2 s'il est plus grand
    if (proposition == valeur) {
      return 1;
    } else if (proposition < valeur) {
      return 0;
    } else {
      return 2;
    }
  }
}