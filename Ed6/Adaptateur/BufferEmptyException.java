package Adaptateur;



public class BufferEmptyException extends EmptyException {
    /**
    * sans message d'erreur
    */
    public  BufferEmptyException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  BufferEmptyException(String s) {
    super(s);
  }

}

