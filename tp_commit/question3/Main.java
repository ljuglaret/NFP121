package question3;
import question1.*;


public class Main
{
    
    public static void main(String[] args){
    
        
        GroupeDeContributeurs g = new GroupeDeContributeurs("g");
        
        g.ajouter(new Contributeur("g_a",100));
        g.ajouter(new Contributeur("g_b",200));
        g.ajouter(new Contributeur("g_c",300));
        
        GroupeDeContributeurs g1 = new GroupeDeContributeurs("g1");
        GroupeDeContributeurs g2 = new GroupeDeContributeurs("g2");
        g2.ajouter(new Contributeur("g2_a",100));
        g2.ajouter(new Contributeur("g2_b",200));
        g1.ajouter(g2);
        g.ajouter(g1);
        GroupeDeContributeurs g11 = new GroupeDeContributeurs("g11");
        g11.ajouter(new Contributeur("g11_a",100));
        g1.ajouter(g11);
      
        

        int ancienSolde = g.solde();
        AbstractTransaction transaction = new TransactionDebit(g);
        try{
            // inital :1000
            transaction.debit(30);// 1000-6*30 = 1000 - 180 = 820
            transaction.debit(30);// 820-6*30 = 820- 180 = 640

            transaction.debit(71);// impossible 30+30+71 > 100

            transaction.rollbackTransaction();
           // transaction.rollbackTransaction();            


        }catch(Exception e){
          System.out.println("transaction impossible");
        }
    }
}

