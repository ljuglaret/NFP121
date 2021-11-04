package Adaptateur;



public class FullException extends Exception {
    /**
    * sans message d'erreur
    */
    public  FullException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  FullException(String s) {
    super(s);
  }

}

