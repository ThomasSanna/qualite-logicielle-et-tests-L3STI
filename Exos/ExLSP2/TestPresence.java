public class TestPresence {
  public static void main(String[] args) {
    Personne p1 = new Personne(false, "Pierre");
    Personne p2 = new Personne(false, "Marie");
    Personne p3 = new Personne(true, "Jean");
    PresencesCours presences = new PresencesCours();
    presences.arriveEnCours(p1);
    presences.arriveEnCours(p2);
    presences.arriveEnCours(p3);
    System.out.println(presences);

    PresencesCours presencesP = new PresencesProf();
    presencesP.arriveEnCours(p1);
    presencesP.arriveEnCours(p2);
    presencesP.arriveEnCours(p3);
    System.out.println(presencesP);

  }
}
