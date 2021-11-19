package Adaptateur;

public class TestAdaptateur extends junit.framework.TestCase{

  public void testFileStandard(){
    FileEntiersI file = new FileEntiers(new Buffer(6));
    assertTrue(file.estVide());
    assertFalse(file.estPleine());
    int taille = 0;
    for(int i = 1; i<=6; i++){
      try{
        file.enfiler(i);
        taille++;
        assertEquals(taille, file.taille());
        assertFalse(file.estVide());
      }catch(Exception e){
        fail("aucune exception n'est attendue ici !!");
      }
    }
    assertEquals(taille, file.taille());
    assertEquals(taille, file.taille());
    assertTrue(file.estPleine());
    try{
      assertEquals(1, file.defiler());
      assertEquals(2, file.defiler());
      assertEquals(3, file.defiler());
      assertEquals(taille-3, file.taille());
      assertEquals(4, file.defiler());
      assertEquals(5, file.defiler());
      assertEquals(6, file.defiler());
      assertEquals(taille-6, file.taille());
    }catch(Exception e){
       fail("aucune exception n'est attendue ici !!");
    }
  }
  
  public void testBufferSimple(){
    FileEntiersI file = new FileEntiers(new Buffer(6));
    assertEquals(6,file.capacite());
    assertEquals(0,file.taille());
    assertTrue(file.estVide());
    assertFalse(file.estPleine());
    try{
      file.enfiler(1);
      file.enfiler(2);
      file.enfiler(3);
    }catch(Exception e){
      fail("aucune exception n'est attendue ici !!");
    }
    assertFalse(file.estPleine());
    try{
      assertEquals(1, file.defiler());
      assertEquals(2, file.defiler());
      file.enfiler(55);
      assertEquals(3, file.defiler());  
      assertEquals(55, file.defiler());
      assertTrue(file.estVide());
    }catch(Exception e){
       fail("aucune exception n'est attendue ici !!");
    }
  }
  
  public void testBufferAvecExceptions(){
    FileEntiersI file = new FileEntiers(new Buffer(3));
    assertTrue(file.estVide());
    assertFalse(file.estPleine());
    for(int i = 1; i<=3; i++){
      try{
        file.enfiler(i);
        assertFalse(file.estVide());
      }catch(Exception e){
        fail("aucune exception n'est attendue ici !!");
      }
    }
    try{
      assertTrue(file.estPleine());
      file.enfiler(55);
      fail("une exception est attendue ici !!");
    }catch(Exception e){
       assertTrue( e instanceof FilePleineException);
    }
    try{
      file.defiler();file.defiler();file.defiler();
      assertTrue(file.estVide());
      int i = file.defiler();
      fail("une exception est attendue ici !!");
    }catch(Exception e){
       assertTrue( e instanceof FileVideException);
    }
  }
  
}