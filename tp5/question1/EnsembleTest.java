package question1;

public class EnsembleTest extends junit.framework.TestCase {

     public void testAdd() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertTrue(e1.add(2));
        assertTrue(e1.add(3));
        assertTrue(e1.add(6));
        assertFalse(e1.add(3));
        assertTrue(e1.add(8));
        assertFalse(e1.add(2));

    }
    
    
    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    
    public void testIntersection() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        e1.add(2);
        e1.add(4);
        e1.add(1);
        e1.add(3);

        e2 = new question1.Ensemble<Integer>();
        e2.add(5);
        e2.add(1);
        e2.add(2);
        e2.add(8);

        question1.Ensemble<Integer> intersection = e1.inter(e2);
        assertEquals(2, intersection.size());
        assertTrue(intersection.contains(2));
        assertTrue(intersection.contains(1));
    }
    
        public void testDiff() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        e1.add(2);
        e1.add(4);
        e1.add(1);
        e1.add(3);

        e2 = new question1.Ensemble<Integer>();
        e2.add(5);
        e2.add(1);
        e2.add(2);
        e2.add(8);

        question1.Ensemble<Integer> difference = e1.diff(e2);
        assertTrue(difference.contains(4));
        assertTrue(difference.contains(3));
    }
    
    
        public void testDiffSy() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        e1.add(2);
        e1.add(4);
        e1.add(1);
        e1.add(3);

        e2 = new question1.Ensemble<Integer>();
        e2.add(5);
        e2.add(1);
        e2.add(2);
        e2.add(8);

        question1.Ensemble<Integer> diffSym = e1.diffSym(e2);
        assertTrue(diffSym.contains(4));
        assertTrue(diffSym.contains(3));
        assertTrue(diffSym.contains(5));
        assertTrue(diffSym.contains(8));
    }
}
