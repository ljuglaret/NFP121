package question1;

/**
 * Classe PilePleineException
 */
public class PilePleineException extends Exception {
    /**
     * sans message d'erreur
     */
    public PilePleineException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public PilePleineException(String s) {
    super(s);
  }

}
