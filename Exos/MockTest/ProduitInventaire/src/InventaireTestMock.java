import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class InventaireTestMock {

    private Inventaire inventaire;
    private Produit produitMock1;
    private Produit produitMock2;

    // Méthode exécutée avant chaque test pour initialiser les objets
    @Before
    public void setUp() {
        inventaire = new Inventaire();
        produitMock1 = Mockito.mock(Produit.class);
        produitMock2 = Mockito.mock(Produit.class);
    }

    // Test : Ajouter un produit et vérifier sa quantité
    @Test
    public void testAjouterEtVerifierProduit() {
        // Configuration du mock
        when(produitMock1.getId()).thenReturn(1);
        when(produitMock1.getQuantite()).thenReturn(10);

        // Ajout du produit mocké à l'inventaire
        inventaire.ajouterProduit(produitMock1);

        // Vérification
        assertEquals("La quantité doit être 10 après l'ajout", 10, inventaire.verifierQuantite(1));
    }

    // Test : Ajouter plusieurs produits et vérifier leurs quantités
    @Test
    public void testAjouterProduitsMultiples() {
        // Configuration des mocks
        when(produitMock1.getId()).thenReturn(1);
        when(produitMock1.getQuantite()).thenReturn(10);
        when(produitMock2.getId()).thenReturn(2);
        when(produitMock2.getQuantite()).thenReturn(15);

        // Ajout des produits mockés
        inventaire.ajouterProduit(produitMock1);
        inventaire.ajouterProduit(produitMock2);

        // Vérifications
        assertEquals("La quantité du produit 1 doit être 10", 10, inventaire.verifierQuantite(1));
        assertEquals("La quantité du produit 2 doit être 15", 15, inventaire.verifierQuantite(2));
    }

    // Test : Supprimer un produit et vérifier qu'il n'est plus présent
    @Test
    public void testSuppressionProduit() {
        // Configuration du mock
        when(produitMock1.getId()).thenReturn(1);
        when(produitMock1.getQuantite()).thenReturn(10);

        // Ajout et suppression du produit mocké
        inventaire.ajouterProduit(produitMock1);
        assertTrue("Le produit doit être supprimé avec succès", inventaire.supprimerProduit(1));
        assertFalse("Le produit ne doit plus être présent", inventaire.estPresentProduit(1));
    }

    // Test : Ajouter un produit avec le même ID et vérifier que la quantité est cumulée
    @Test
    public void testAjouterProduitExistant() {
        // Configuration des mocks
        when(produitMock1.getId()).thenReturn(1);
        final int[] quantite1 = {10}; // Initial quantity
        when(produitMock1.getQuantite()).thenAnswer(invocation -> quantite1[0]);
        doAnswer(invocation -> {
            int nouvelleQuantite = invocation.getArgument(0);
            quantite1[0] = nouvelleQuantite; // Simulate setting the quantity
            return null;
        }).when(produitMock1).setQuantite(anyInt());

        when(produitMock2.getId()).thenReturn(1);
        when(produitMock2.getQuantite()).thenReturn(20);

        // Ajout des produits mockés avec le même ID
        inventaire.ajouterProduit(produitMock1);
        inventaire.ajouterProduit(produitMock2);

        // Vérification que la quantité totale est la somme (10 + 20 = 30)
        assertEquals("La quantité totale doit être la somme des quantités ajoutées", 30, inventaire.verifierQuantite(1));
    }
}