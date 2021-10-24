package question2;

/**
 * Classe-test Pile4Test.
 */
public class Pile4Test extends junit.framework.TestCase {
    private PileI p1;
    private PileI p2;
    private PileI p3;

    public void setUp() {
        p1 = new question2.Pile4();
        p2 = new question2.Pile4();
        p3 = new question2.Pile4();
    }

    public void test_Pile4_capacite() {
        assertEquals(6, p3.capacite());
    }

    public void test_Pile4_estPleine() throws Exception {
        PileI p = new question2.Pile4(3);
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

    public void test_Pile4_sommet() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile4_estVide() throws Exception {
        PileI p = new question2.Pile4(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile4_toString() throws Exception {
        PileI pile1 = new question2.Pile4(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile4_TailleNegative() {
        PileI p = new question2.Pile4(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile4_equals() throws Exception {

        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue("égalité de deux piles ? ", p1.equals(p2));
        assertTrue("égalité de deux piles ? ", p2.equals(p1));
        assertTrue("égalité de deux piles ? ", p1.equals(p1));

        p2.empiler(1);
        assertFalse("égalité de deux piles ? ", p1.equals(p2));

    }

    public void test_Pile4_hashCodeErreur() throws Exception {
        try{
            p1.empiler(4);

            assertFalse("égalité hashcode " +p1.toString()  + " - " +p2.toString(), (p1.hashCode())==(p2.hashCode()));
            assertFalse("égalité de deux piles ? " +p1.toString()  + " - " +p2.toString(), p1.equals(p2));
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void test_Pile4_equals_hashCode(){
        try{
            PileI ptest0 = new question2.Pile4(1);
            ptest0.empiler(1);
            
            PileI ptest1 = new question2.Pile4(1);
            ptest1.empiler("1");
            
            assertTrue("égalité hashcode " +ptest0.toString()  + " - " +ptest1.toString(), (ptest0.hashCode())==(ptest1.hashCode()));
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
 