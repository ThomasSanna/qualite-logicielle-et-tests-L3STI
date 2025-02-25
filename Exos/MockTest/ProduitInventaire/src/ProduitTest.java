import org.junit.Test;
import static org.junit.Assert.*;

public class ProduitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurIdNegatif() {
        new Produit(-1, "produit", 10); // ID négatif doit lever une exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurQuantiteNegative() {
        new Produit(1, "produit", -10); // Quantité négative doit lever une exception
    }

    @Test
    public void testConstructeurValide() {
        Produit produit = new Produit(1, "produit", 10);
        assertEquals("L'ID doit être 1", 1, produit.getId());
        assertEquals("Le nom doit être 'produit'", "produit", produit.getNom());
        assertEquals("La quantité doit être 10", 10, produit.getQuantite());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIdNegatif() {
        Produit produit = new Produit(1, "produit", 10);
        produit.setId(-1); // ID négatif doit lever une exception
    }

    @Test
    public void testSetIdValide() {
        Produit produit = new Produit(1, "produit", 10);
        produit.setId(2);
        assertEquals("L'ID doit être mis à 2", 2, produit.getId());
    }

    @Test
    public void testSetNomValide() {
        Produit produit = new Produit(1, "produit", 10);
        produit.setNom("nouveau");
        assertEquals("Le nom doit être 'nouveau'", "nouveau", produit.getNom());
    }

    @Test
    public void testSetQuantiteAjoute() {
        Produit produit = new Produit(1, "produit", 10);
        produit.setQuantite(20);
        assertEquals("La quantité doit être augmentée à 30 (10 + 20)", 30, produit.getQuantite());
    }
}