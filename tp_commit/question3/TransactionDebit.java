package question3;
 
import question1.*;

public class TransactionDebit extends AbstractTransaction{
  private Gardien gardien;
  
  public TransactionDebit(Cotisant cotisant){
        super(cotisant);
        this.gardien = new Gardien();
    }
    
  /**
   * Commence une transaction
   */
  public void beginTransaction(){
     Memento instantane = new Memento(cotisant);
     gardien.setMemento(instantane);
  }
  
  /**
   * Commit
   */
  public void endTransaction(){
      gardien.getMemento();
  }
  
  /**
   * Restitue l'état précédent
   */
  public  void rollbackTransaction(){
    Memento instantane = gardien.getMemento();
    instantane.setState(cotisant);
  }
}