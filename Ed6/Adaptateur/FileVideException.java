package Adaptateur;


/**
 * Classe FileVideException
 */
public class FileVideException extends Exception {
    /**
    * sans message d'erreur
    */
    public  FileVideException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  FileVideException(String s) {
    super(s);
  }

}