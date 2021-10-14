
import java.util.List;
import java.util.Iterator;
public class TableEntiersTest extends junit.framework.TestCase{

    public void testAjout(){
        try{
            TableEntiers table = new TableEntiers(4);
            assertEquals(0, table.taille()); assertEquals(true, table.estVide());
            assertEquals(false, table.estPleine());

            table.ajouter(new Entier(-2)); assertEquals(1, table.taille());
            assertEquals(false, table.estVide()); assertEquals(false, table.estPleine());

            table.ajouter(new EntierPositif(1)); assertEquals(2, table.taille());
            assertEquals(false, table.estVide()); assertEquals(false, table.estPleine());

            table.ajouter(new Entier(2)); assertEquals(3, table.taille());
            assertEquals(false, table.estVide()); assertEquals(false, table.estPleine());

            table.ajouter(new EntierPositif(3)); assertEquals(4, table.taille());
            assertEquals(false, table.estVide()); assertEquals(true, table.estPleine());
            // ... 
        }catch(TableException exc){
            fail("Une exception n'est pas attendue ici ..."); } }

    public void testRetrait(){ try{ TableEntiers table = new TableEntiers(4);
            table.ajouter(new Entier(0)); table.ajouter(new Entier(1));// [0,1]
            assertEquals(2, table.taille()); table.retirer(new Entier(0));// [1]
            assertEquals(1, table.taille()); assertFalse(table.contient(new Entier(0)));
            assertTrue(table.contient(new Entier(1))); table.retirer(new Entier(2));
            assertEquals(1, table.taille());
            table.retirer(new Entier(1));
            assertEquals(0, table.taille());// []
            table.ajouter(new Entier(0));
            table.ajouter(new Entier(1));
            table.ajouter(new Entier(0)); table.ajouter(new Entier(2));//[0,1,0,2]
            assertEquals("[0, 1, 0, 2]",table.toString());
            table.retirer(new Entier(0));//[1,0,2]
            assertEquals(3, table.taille());
            assertEquals("[1, 0, 2]",table.toString());
            table.retirer(new Entier(2));//[1,0,2]
            assertEquals(2, table.taille());
            assertEquals("[1, 0]",table.toString()); // ... 
        }catch(TableException exc){
            fail("Une exception n'est pas attendue ici ..."); }
    }
    public void testIterator() {
        try{
            TableEntiers table = new TableEntiers(6);
            for(int i=10;i < 16;i++){
                table.ajouter(new Entier(i));
            }
            Iterator<Entier> it = table.iterator();
            for(int i = 0 ; i < 6; i++){
                //System.out.println((new Entier(i+10)).equals( it.next()));
               assertEquals(new Entier(i+10), it.next());
            }
           //assertFalse(it.hasNext());
        }
      
        catch(TableException exc){
            fail("Une exception n'est pas attendue ici ...");
        }
        
    }

    public void testRepOk(){
        try{
            TableEntiers table = new TableEntiers(4);
            assertTrue(table.repOk());
            assertEquals(0, table.taille());
            assertTrue(table.repOk());
            table.ajouter(new Entier(0));
            assertEquals(1,table.taille()); assertTrue(table.repOk());
            table.ajouter(new Entier(1)); assertTrue(table.repOk());
            table.ajouter(new Entier(2)); assertTrue(table.repOk());
            table.ajouter(new Entier(3)); assertEquals(4, table.taille());
            assertTrue(table.repOk()); 
        }
        catch(TableException exc){
            fail("Une exception n'est pas attendue ici ...");
        }
    }

    public void testAf(){
        try{
            TableEntiers table = new TableEntiers(4);
            List<Integer> liste = table.af();
            table.ajouter(new Entier(0));
            liste.add(new Entier(0).getEntier());
            assertEquals(table.af(),liste); // ...
        }
        catch(TableException exc){
            fail("Une exception n'est pas attendue ici ...");
        }
    }

    public void testRepOkTailleNulle(){
        try{
            TableEntiers table = new
                TableEntiers(0); assertTrue(table.repOk()); assertEquals(0, table.taille());

            assertEquals(true, table.estVide()); assertEquals(true, table.estPleine());

            assertNotNull(table.iterator()); assertFalse(table.iterator().hasNext());
            //... 
        }
        catch(Exception exc){ fail("Une exception n'est pas attendue ici ...");
        } }

}
 