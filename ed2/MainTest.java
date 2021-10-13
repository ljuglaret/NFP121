

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest extends junit.framework.TestCase{
  
  public void testSortieSurLaConsole() throws Exception{
    String[] out = mainExec("Main",new String[]{"2","8"});
    assertEquals(2, out.length);
    assertTrue(out[0].endsWith("3"));
    assertTrue(out[1].endsWith("9"));
  }
  
  public void testSortieSurLaConsoleAvecException1() throws Exception{
    String[] out = mainExec("Main",new String[]{"2","8","x","99"});
    assertEquals(4, out.length);
    assertTrue(out[0].endsWith("3"));
    assertTrue(out[1].endsWith("9"));
    assertTrue(out[2].toUpperCase().contains("EXCEPTION"));
    assertTrue(out[3].endsWith("100"));

  }
  
    public void testSortieSurLaConsoleAvecException2() throws Exception{
    String[] out = mainExec("Main",new String[]{"0","-" ,"-0" ,"-2"});
    assertEquals(4, out.length);
    assertTrue(out[0].endsWith("1"));
    assertTrue(out[1].toUpperCase().contains("EXCEPTION"));
    assertTrue(out[2].endsWith("1"));
    assertTrue(out[3].endsWith("-1"));

  }


  
  /** Obtention de l'affichage produit par l'exécution de la méthode main d'une classe.
    * @param className le nom de la classe
    * @param args les arguments de la ligne de commande
    * @return le texte en tableau de lignes
    * @throws une exception est levée si la classe est inconnue
    */
    public static String[] mainExec(String className, String[] args)throws Exception{
      java.io.PrintStream out = System.out;
      String[] consoleOut = null; // ou new String[]{""};
      try{
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        java.io.PrintStream ps = new java.io.PrintStream(baos);
        Class<?> c = Class.forName(className);
        System.setOut(ps);
        c.getMethod("main",String[].class).invoke(null, new  Object[]{args});
        consoleOut = baos.toString().split(System.getProperty("line.separator"));
      }finally{
        System.setOut(out);
      }
      return consoleOut;
    }
  }