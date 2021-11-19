package Adaptateur;

public class TestBuffer extends junit.framework.TestCase{

  public void testBufferStandard(){
    CollectionI file = new Buffer(6);
    assertTrue(file.empty());
    assertFalse(file.full());
    int taille = 0;
    for(int i = 1; i<=6; i++){
      try{
        file.put(i);
        taille++;
        assertEquals(taille, file.size());
        assertFalse(file.empty());
      }catch(Exception e){
        fail("aucune exception n'est attendue ici !!");
      }
    }
    assertEquals(taille, file.size());
    assertEquals(taille, file.size());
    assertTrue(file.full());
    try{
      assertEquals(1, file.get());
      assertEquals(2, file.get());
      assertEquals(3, file.get());
      assertEquals(taille-3, file.size());
      assertEquals(4, file.get());
      assertEquals(5, file.get());
      assertEquals(6, file.get());
      assertEquals(taille-6, file.size());
    }catch(Exception e){
       fail("aucune exception n'est attendue ici !!");
    }
  }
  
  public void testBufferSimple(){
    CollectionI file = new Buffer(6);
    assertEquals(6,file.capacity());
    assertEquals(0,file.size());
    assertTrue(file.empty());
    assertFalse(file.full());
    try{
      file.put(1);
      file.put(2);
      file.put(3);
    }catch(Exception e){
      fail("aucune exception n'est attendue ici !!");
    }
    assertFalse(file.full());
    try{
      assertEquals(1, file.get());
      assertEquals(2, file.get());
      file.put(55);
      assertEquals(3, file.get());  
      assertEquals(55, file.get());
      assertTrue(file.empty());
    }catch(Exception e){
       fail("aucune exception n'est attendue ici !!");
    }
  }
  
  public void testBufferAvecExceptions(){
    CollectionI file = new  Buffer(3);
    assertTrue(file.empty());
    assertFalse(file.full());
    for(int i = 1; i<=3; i++){
      try{
        file.put(i);
        assertFalse(file.empty());
      }catch(Exception e){
        fail("aucune exception n'est attendue ici !!");
      }
    }
    try{
      assertTrue(file.full());
      file.put(55);
      fail("une exception est attendue ici !!");
    }catch(Exception e){
       assertTrue( e instanceof BufferFullException);
    }
    try{
      file.get();file.get();file.get();
      assertTrue(file.empty());
      int i = file.get();
      fail("une exception est attendue ici !!");
    }catch(Exception e){
       assertTrue( e instanceof BufferEmptyException);
    }
  }
  
}