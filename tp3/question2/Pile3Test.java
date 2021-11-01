package question2;

/**
 * Classe-test Pile3Test.
 */

public class Pile3Test extends junit.framework.TestCase {
     private PileI p1;
    private PileI p2;
    private PileI p3;
    
    public void setUp() {
        p1 = new question2.Pile3();
        p2 = new question2.Pile3();
        p3 = new question2.Pile3();
    }

    public void test_Pile3_capacite() {
         assertEquals(6, p3.capacite());
    }

    public void test_Pile3_estPleine() throws Exception {
        PileI p = new question2.Pile3(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile3_sommet() throws Exception {
        PileI p = new question2.Pile3(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile3_estVide() throws Exception {
        PileI p = new question2.Pile3(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile3_toString() throws Exception {
        PileI pile1 = new question2.Pile3(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile3_TailleNegative() {
        PileI p = new question2.Pile3(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile3_equals() throws Exception {

    try{
        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue("�galit� de deux piles 1)? " +p1.toString()  + " - " +p2.toString(), p1.equals(p2));
        assertTrue("�galit� de deux piles 2)? " +p1.toString()  + " - " +p2.toString(), p2.equals(p1));
        assertTrue("�galit� de deux piles 3)? " +p1.toString()  + " - " +p2.toString(), p1.equals(p1));

        p2.empiler(1);
        assertFalse("�galit� de deux piles 4)? " +p1.toString()  + " - " +p2.toString(), p1.equals(p2));
    }
    catch(Exception e){
        System.out.println(e);
    }

    }
    
    
    public void test_Pile3_equalsException() throws Exception {

    try{
        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        
        assertFalse("�galit� de deux piles 1)? " +p1.toString()  + " - " +p2.toString(), p1.equals(p2));
        assertFalse("�galit� de deux piles 2)? " +p1.toString()  + " - " +p2.toString(), p2.equals(p1));
        assertTrue("�galit� de deux piles 3)? " +p1.toString()  + " - " +p2.toString(), p1.equals(p1));
    }
    catch(Exception e){
        System.out.println(e);
    }

    }
}