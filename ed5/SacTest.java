public class SacTest extends junit.framework.TestCase{
 
   public void testAjouterEtTaille(){
     CollectionI<Integer> sac = new Sac<Integer>();
     assertTrue(sac.ajouter(3));
     assertTrue(sac.contient(3));
     assertTrue(sac.ajouter(2));
     assertTrue(sac.contient(2));
     assertTrue(sac.ajouter(1));
     assertTrue(sac.contient(1));
     assertEquals(3,sac.taille());
   }
   
   public void testSupprimer(){
     CollectionI<Integer> sac = new Sac<Integer>();
     assertTrue(sac.ajouter(3));
     assertEquals(1,sac.taille());
     assertTrue(sac.contient(3));
     assertTrue(sac.supprimer(3));
     assertEquals(0,sac.taille());
     assertTrue(sac.ajouter(3));
     assertTrue(sac.ajouter(3));
     assertTrue(sac.ajouter(2));
     
     assertTrue(sac.contient(2));
     assertEquals(3,sac.taille());
     assertTrue(sac.supprimer(2));
     assertEquals(2,sac.taille());

   }
   
   public void testAjouterCollection(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(1);
     int n = sacA.taille();
     CollectionI<Integer> sacB = new Sac<Integer>();
     sacB.ajouter(4);sacB.ajouter(sacA);
     assertEquals(n+1, sacB.taille());
     assertTrue(sacB.contient(3));
     assertTrue(sacB.contient(2));
     assertTrue(sacB.contient(1));
     assertTrue(sacB.contient(4));
   }
   
   public void testSupprimerCollection(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(1);
     CollectionI<Integer> sacB = new Sac<Integer>();
     sacB.ajouter(2);sacB.ajouter(4);sacB.ajouter(3);
     assertTrue(sacB.supprimer(sacA));
     assertEquals(1, sacB.taille());
     assertTrue(sacB.contient(4));
      
   }
   
   public void testEgaliteCollection(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);sacA.ajouter(2);sacA.ajouter(1);
     
     CollectionI<Integer> sacB = new Sac<Integer>();
     sacB.ajouter(2);sacB.ajouter(4);sacB.ajouter(3);
     
     assertFalse(sacA.equals(sacB));
     sacB.supprimer(4); sacA.supprimer(1);
     assertTrue(sacA.equals(sacB));      
   }
 
     // à compléter
     
     
   public void testEgaliteCollection2(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);
     sacA.ajouter(2);
     sacA.ajouter(1);
     CollectionI<Integer> sacB = new Sac<Integer>();
     sacB.ajouter(2);
     sacB.ajouter(4);
     sacB.ajouter(3);
     assertFalse(sacA.toString() + " - " + sacB.toString(),sacA.equals(sacB));
     

   }

   
    public void testContient(){
     CollectionI<Integer> sacA = new Sac<Integer>();
     sacA.ajouter(3);
     sacA.ajouter(2);
     sacA.ajouter(1);
     CollectionI<Integer> sacB = new Sac<Integer>();
     sacB.ajouter(1);
     sacB.ajouter(3);
     assertTrue(sacA.toString() + " - " + sacB.toString(),sacA.contient(sacB));
     assertFalse(sacA.toString() + " - " + sacB.toString(),sacB.contient(sacA));
     assertTrue(sacA.toString() + " - " + sacA.toString(),sacA.contient(sacA));
     assertTrue(sacB.toString() + " - " + sacB.toString(),sacB.contient(sacB));
     
     sacB.ajouter(2);
     sacB.ajouter(4);
     assertTrue(sacA.toString() + " - " + sacB.toString(),sacB.contient(sacA));

     
   }

}