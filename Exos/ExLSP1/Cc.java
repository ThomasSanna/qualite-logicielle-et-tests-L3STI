public class Cc {
  public static void main(String[] args) {

    Crayon crayon = new Crayon();
    crayon.ecrire("Bonjour");
    crayon.ecrire("Bonjour");

    Crayon stylo = new Stylo(1);
    stylo.ecrire("Bonjour");
    stylo.ecrire("Bonjour");

  }
}
