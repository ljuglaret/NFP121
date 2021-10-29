

public class SacAObjetsUniquesTest extends junit.framework.TestCase{

  public void testAjouter(){
     CollectionI<Integer> sac = new SacAObjetsUniques<Integer>();
     assertTrue(sac.ajouter(3));
     assertEquals(1,sac.taille());
     assertTrue(sac.contient(3));
     assertTrue(sac.ajouter(2));
     assertEquals(2,sac.taille());
     assertFalse(sac.ajouter(3));
     assertEquals(2,sac.taille());
     assertFalse(sac.ajouter(2));
     assertEquals(2,sac.taille());
   }
   
   public void testAjouterCollection(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(2);sacA.ajouter(2);sacA.ajouter(1);sacA.ajouter(1);
     assertEquals(6, sacA.taille());
     CollectionI<Integer> sacB = new SacAObjetsUniques<Integer>();
     sacB.ajouter(4);sacB.ajouter(sacA);
     assertEquals(4, sacB.taille());
     assertTrue(sacB.contient(3));
     assertTrue(sacB.contient(2));
     assertTrue(sacB.contient(1));
     assertTrue(sacB.contient(4));
   }
   
   public void testSupprimerCollection(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(1);
     CollectionI<Integer> sacB = new SacAObjetsUniques<Integer>();
     sacB.ajouter(2);sacB.ajouter(4);sacB.ajouter(4);sacB.ajouter(3);
     
     assertTrue(sacB.supprimer(sacA));
     assertEquals(1, sacB.taille());
     assertTrue(sacB.contient(4));
      
   }

   // à compléter, 
}
