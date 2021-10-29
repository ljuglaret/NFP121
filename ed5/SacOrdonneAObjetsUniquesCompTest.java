import java.util.*;

public class SacOrdonneAObjetsUniquesCompTest extends junit.framework.TestCase{


  public void testAjouter(){
     CollectionI<Integer> sac = new SacOrdonneAObjetsUniquesComp<Integer>();
     assertTrue(sac.ajouter(3));
     assertEquals(1,sac.taille());
     assertTrue(sac.contient(3));
     assertTrue(sac.ajouter(2));
     assertEquals(2,sac.taille());
     assertFalse(sac.ajouter(3));
     assertEquals(2,sac.taille());
     assertFalse(sac.ajouter(2));
     assertEquals(2,sac.taille());
     assertTrue("sac non ordonné ???" + sac.toString(), isSorted(sac));
   }
 
  public void testAjouterCollection(){
    CollectionI<Integer> sacA = new Sac<Integer>();
    sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(2);sacA.ajouter(2);sacA.ajouter(1);sacA.ajouter(1);
    assertEquals(6, sacA.taille());
    CollectionI<Integer> sacB = new SacOrdonneAObjetsUniquesComp<Integer>();
    sacB.ajouter(4);sacB.ajouter(sacA);
    assertEquals(4, sacB.taille());
    assertTrue(sacB.contient(3));
    assertTrue(sacB.contient(2));
    assertTrue(sacB.contient(1));
    assertTrue(sacB.contient(4));
    assertTrue("sac non ordonné ???", isSorted(sacB));
  }
   
  public void testSupprimerCollection(){
    CollectionI<Integer> sacA = new Sac<Integer>();
    sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(1);
    CollectionI<Integer> sacB = new SacOrdonneAObjetsUniquesComp<Integer>();
    sacB.ajouter(2);sacB.ajouter(4);sacB.ajouter(4);sacB.ajouter(3);
     
    assertTrue(sacB.supprimer(sacA));
    assertEquals(1, sacB.taille());
    assertTrue(sacB.contient(4));
    assertTrue("sac non ordonné ???", isSorted(sacB));
    
    CollectionI<Integer> sacC = new SacOrdonneAObjetsUniquesComp<Integer>();
    sacC.ajouter(sacA);
    assertTrue("sac non ordonné ???", isSorted(sacC));
  }
  
  private static class A{}
  private static class B implements Comparable<B>{
    public int compareTo(B b){ return 0;}
  }
  // http://stackoverflow.com/questions/3047051/how-to-determine-if-a-list-is-sorted-in-java
  public static <T extends Comparable<? super T>>
        boolean isSorted(Iterable<T> iterable) {
    Iterator<T> iter = iterable.iterator();
    if (!iter.hasNext()) {
        return true;
    }
    T t = iter.next();
    while (iter.hasNext()) {
        T t2 = iter.next();
        if (t.compareTo(t2) > 0) {
            return false;
        }
        t = t2;
    }
    return true;
  }
}