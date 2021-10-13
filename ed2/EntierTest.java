

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EntierTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    protected double fValeur1;
    protected double fValeur2;

    /**
     * Constructeur de la classe-test EntierTest
     */
    public EntierTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
     
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    
    @Test
    public void testEquals(){
        Entier e = new Entier(3);
        Entier e1 = new Entier(2);
        
        assertFalse(e.equals(e1)); // assertNotEquals n'existe pas
        e1.inc();
        assertEquals(e,e1);
//        assertEquals("deux objets égaux ==> leur hashCode sont égaux", e.hashCode(),e1.hashCode());
        assertEquals( e.hashCode(),e1.hashCode());
        
        assertFalse(e.equals(null));
        
        Entier e2 = new Entier(5);
        assertEquals(e2,e2);
        assertEquals(new Entier(7),new Entier(7));
        assertEquals(new Entier(7).hashCode(),new Entier(7).hashCode());
  }
    @Test
    public void testParseEntier(){
        Entier e = Entier.parseEntier("3");
        assertEquals(new Entier(3),e);
        try{
          Entier e1 = Entier.parseEntier("3x");
        }
        catch(Exception exc){
          assertTrue(exc instanceof NumberFormatException);
        }
    }
}
