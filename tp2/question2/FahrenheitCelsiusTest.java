package question2;

/**
 * Classe-test FahrenheitCelsiusTest.
 *
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 *
 *          Les classes-test sont document�es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont bas�es sur le document � 2002 Robert A. Ballance intitul�
 *          �JUnit: Unit Testing Framework�.
 *
 *          Les objets Test (et TestSuite) sont associ�s aux classes � tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          m�me paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque m�thode Test �
 *          ex�cuter. Il peut y avoir plus d'une m�thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ d�couvrira
 *          automatiquement (par introspection) les m�thodes Test de votre
 *          classe Test et g�n�rera la TestSuite cons�quente. Chaque appel d'une
 *          m�thode Test sera pr�c�d� d'un appel de setUp(), qui r�alise les
 *          engagements, et suivi d'un appel � tearDown(), qui les d�truit.
 */
public class FahrenheitCelsiusTest extends junit.framework.TestCase {
  // D�finissez ici les variables d'instance n�cessaires � vos engagements;
  // Vous pouvez �galement les saisir automatiquement du pr�sentoir
  // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
  // Notez cependant que ce dernier ne peut saisir les objets primitifs
  // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).

  /**
   * Constructeur de la classe-test FahrenheitCelsiusTest
   */

  /**
   * Met en place les engagements.
   *
   * M�thode appel�e avant chaque appel de m�thode de test.
   */
  protected void setUp() // throws java.lang.Exception
  {
    // Initialisez ici vos engagements

  }

  /**
   * Supprime les engagements
   *
   * M�thode appel�e apr�s chaque appel de m�thode de test.
   */
  protected void tearDown() // throws java.lang.Exception
  {
    // Lib�rez ici les ressources engag�es par setUp()
  }

  /**
   * Il ne vous reste plus qu'� d�finir une ou plusieurs m�thodes de test. Ces
   * m�thodes doivent v�rifier les r�sultats attendus � l'aide d'assertions
   * assertTrue(<boolean>). Par convention, leurs noms devraient d�buter par
   * "test". Vous pouvez �baucher le corps gr�ce au menu contextuel "Enregistrer
   * une m�thode de test".
   */

  public void test_fahrenheitEnCelsius() {
    assertEquals("    0 �F -> -17.7 �C ? ", -17.7, question2.FahrenheitCelsius.fahrenheitEnCelsius(0), 0.1);
    assertEquals("  100 �F -> 37.7 �C ? ", 37.7, question2.FahrenheitCelsius.fahrenheitEnCelsius(100), 0.1);
    assertEquals(" 2000 �F -> 1093.3 �C ?", 1093.3, question2.FahrenheitCelsius.fahrenheitEnCelsius(2000), 0.1);
    assertEquals("   54 �F -> 12.2 �C ?", 12.2, question2.FahrenheitCelsius.fahrenheitEnCelsius(54), 0.1);
    assertEquals("   -27 �F -> -32.7�C ?", -32.7, question2.FahrenheitCelsius.fahrenheitEnCelsius(-27), 0.1);

  }

  public void test_fahrenheitEnCelsiusNeg() {
    assertEquals("   -27 �F -> -32.7�C ?", -32.7, question2.FahrenheitCelsius.fahrenheitEnCelsius(-27), 0.1);
  }

  public void test_fahrenheitEnCelsius2() {
    assertEquals("   60 �F -> 15.5�C ?", 15.5, question2.FahrenheitCelsius.fahrenheitEnCelsius(60), 0.1);
  }

  public void test_fahrenheitEnCelsiusAvecException1() throws Exception {
    String[] out = mainExec("question2.FahrenheitCelsius", new String[] { "100", "x", "-27" });
    assertTrue(out[0].endsWith("100�F -> 37.7�C"));
    assertTrue(out[1].toUpperCase().contains("EXCEPTION"));
    assertTrue(out[2].endsWith("-27�F -> -32.7�C"));
  }

  public static String[] mainExec(String className, String[] args) throws Exception {
    java.io.PrintStream out = System.out;
    String[] consoleOut = null; // ou new String[]{""};
    try {
      java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
      java.io.PrintStream ps = new java.io.PrintStream(baos);
      Class<?> c = Class.forName(className);
      System.setOut(ps);
      c.getMethod("main", String[].class).invoke(null, new Object[] { args });
      consoleOut = baos.toString().split(System.getProperty("line.separator"));
    } finally {
      System.setOut(out);
    }
    return consoleOut;
  }

}
