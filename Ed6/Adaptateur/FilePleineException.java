package Adaptateur;

public class FilePleineException extends Exception {
    /**
    * sans message d'erreur
    */
    public  FilePleineException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  FilePleineException(String s) {
    super(s);
  }

}
