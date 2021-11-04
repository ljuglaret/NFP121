package Adaptateur;



public class BufferFullException extends FullException {
    /**
    * sans message d'erreur
    */
    public  BufferFullException() {
    super();
  }

    /**
    * avec message d'erreur
    */
  public  BufferFullException(String s) {
    super(s);
  }

}

