package question1;

/**
 * Classe PileVideException
 */
public class PileVideException extends Exception {
    /**
    * sans message d'erreur
    */
    public  PileVideException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  PileVideException(String s) {
    super(s);
  }

}

