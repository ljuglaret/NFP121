public class FabriqueDeSacTest extends junit.framework.TestCase{

  public void testUneFabriqueAjouter(){
     Fabrique<Integer> f = new FabriqueDeSacs<Integer>();
     
     CollectionI<Integer> sac = f.fabriquerUneCollection("SAC");

     assertTrue(sac.ajouter(3));
     assertEquals(1,sac.taille());
     assertTrue(sac.contient(3));
     assertTrue(sac.ajouter(2));
     assertEquals(2,sac.taille());
     assertTrue(sac.ajouter(3));
     assertEquals(3,sac.taille());
     assertTrue(sac.ajouter(2));
     assertEquals(4,sac.taille());

     CollectionI<Integer> sac2 = f.fabriquerUneCollection("UNIQUE");
     assertTrue(sac2.ajouter(3));
     assertEquals(1,sac2.taille());
     assertTrue(sac2.contient(3));
     assertTrue(sac2.ajouter(2));
     assertEquals(2,sac2.taille());
     
     
     CollectionI<Integer> sac3 = f.fabriquerUneCollection("ORDONNE");
     assertTrue(sac3.ajouter(1));
     assertEquals(1,sac3.taille());
     assertTrue(sac3.contient(1));
     assertTrue(sac3.ajouter(3));
     assertEquals(2,sac3.taille());


   }
   
 
}