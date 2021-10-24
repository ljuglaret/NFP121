package question1;

/**
 * Classe PileTest
 */
public class PileTest extends junit.framework.TestCase {
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).
    
    /**
     * Constructeur de la classe-test PileTest
     */
    public PileTest() {
    }

    private Pile p1 = new Pile();
    /**
     * Met en place les engagements.
     * 
     * M�thode appel�e avant chaque appel de m�thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile(4);
    }

    /**
     * Supprime les engagements
     * 
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Lib�rez ici les ressources engag�es par setUp()
    }

    public void test_estVide() {
        assertTrue(p1.estVide());
    }

    public void test_estPleine() {
        try{
             p1.empiler(0);   
             p1.empiler(5);   
             p1.empiler(7);   

        }
        catch(PilePleineException e){
        }
         assertFalse(p1.estPleine());
    }
}
