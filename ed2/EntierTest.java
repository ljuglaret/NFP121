
  
  import static org.junit.jupiter.api.Assertions.*; 
  import org.junit.jupiter.api.AfterEach;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
  
  
  public class EntierTest {
  
  protected double fValeur1; protected double fValeur2;
  
  public EntierTest() { }
  
  @BeforeEach public void setUp() // throws java.lang.Exception 
  {
  
  }
  
  @AfterEach public void tearDown() // throws java.lang.Exception 
  { //Libérez ici les ressources engagées par setUp() 
    }
  
  @Test public void testEquals(){
      Entier e = new Entier(3); Entier e1 = new
      Entier(2);
  
      assertFalse(e.equals(e1)); // assertNotEquals n'existe pas e1.inc();
      assertEquals(e,e1); //
     // assertEquals("deux objets égaux ==> leur hashCode sont égaux",e.hashCode(),e1.hashCode()); assertEquals( e.hashCode(),e1.hashCode());
  
      assertFalse(e.equals(null));
      
      Entier e2 = new Entier(5); assertEquals(e2,e2); assertEquals(new
      Entier(7),new Entier(7)); assertEquals(new Entier(7).hashCode(),new
      Entier(7).hashCode());
    }
  
  @Test public void testParseEntier(){
      Entier e = Entier.parseEntier("3");
      assertEquals(new Entier(3),e);
      try{ Entier e1 = Entier.parseEntier("3x"); }
      catch(Exception exc){ assertTrue(exc instanceof NumberFormatException); } } }
 