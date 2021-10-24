package question1;

/**
 * Classe PileTest
 */
public class PileTest extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    
    /**
     * Constructeur de la classe-test PileTest
     */
    public PileTest() {
    }

    private Pile p1 = new Pile();
    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile(4);
    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée après chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
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
