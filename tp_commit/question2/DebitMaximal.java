package question2;

import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;
import java.util.Iterator;

public class DebitMaximal implements Visiteur<Integer>{

  public Integer visite(Contributeur c){
    return c.solde();
  }
  
  public Integer visite(GroupeDeContributeurs g){
    int minDesDebitsMaxs = Integer.MAX_VALUE;
    for (Cotisant cotisant : g.getChildren()){
        Integer enfantDebitMax= cotisant.accepter(this);
        if(enfantDebitMax < minDesDebitsMaxs){
            minDesDebitsMaxs =  enfantDebitMax;
        }
    }
   return minDesDebitsMaxs;
  }
}