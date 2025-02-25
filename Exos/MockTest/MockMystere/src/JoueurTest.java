import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JoueurTest {

    private Joueur joueur;
    private Mystere mockMystere;

    @Before
    public void setUp() {
        joueur = new Joueur("TestJoueur");
        mockMystere = mock(Mystere.class);
        joueur.setNombreMystere(mockMystere);
    }

    @Test
    public void testJouerGagne() {
        when(mockMystere.testProp(anyInt())).thenReturn(1);
        String result = joueur.jouer(50);
        assertEquals("gagne", result);
    }

    @Test
    public void testJouerPlusPetit() {
        when(mockMystere.testProp(anyInt())).thenReturn(0);
        String result = joueur.jouer(50);
        assertEquals("PlusPetit", result);
    }

    @Test
    public void testJouerPlusGrand() {
        when(mockMystere.testProp(anyInt())).thenReturn(2);
        String result = joueur.jouer(50);
        assertEquals("PlusGrand", result);
    }
}