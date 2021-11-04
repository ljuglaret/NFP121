package Adaptateur;


public class EmptyException  extends Exception 
{
    /**
    * sans message d'erreur
    */
    public  EmptyException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  EmptyException(String s) {
    super(s);
  }

}

