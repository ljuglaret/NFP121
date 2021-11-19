import java.util.Stack;

public class Appelant{
    private Stack<Commande> retablirCommandeStack = null;
    private Stack<Commande> annulerCommandeStack = null;

    public Stack<Commande> getPile(){
        return annulerCommandeStack;
    }
    public Appelant() {
        annulerCommandeStack = new Stack<Commande>();
        retablirCommandeStack = new Stack<Commande>();
    }

    public void changerCommande(Commande commande) {
        annulerCommandeStack.add(commande);
    }

    public void lancer(){
        annulerCommandeStack.peek().lancer();
    }

    public void annuler(){
                retablirCommandeStack.push(annulerCommandeStack.peek());

        if(!annulerCommandeStack.isEmpty()){
            if (annulerCommandeStack.peek()  instanceof CommandeConcreteColler){
                CommandeConcreteColler derniere = (CommandeConcreteColler)annulerCommandeStack.peek();
                derniere.annulerColler();           

            }
            
            if (annulerCommandeStack.peek()  instanceof CommandeConcreteCouper){
                CommandeConcreteCouper derniere = (CommandeConcreteCouper)annulerCommandeStack.peek();
                derniere.annulerCouper();          

            }            
           annulerCommandeStack.pop();
        }else{
            System.out.println("Rien à annuler");
        }
    }
    
    public String dernier(){
          if (annulerCommandeStack.peek()  instanceof CommandeConcreteCopie){
                CommandeConcreteCopie derniere = (CommandeConcreteCopie)annulerCommandeStack.peek();
        return  derniere.getDonneesCopiees();

            }
            
            if (annulerCommandeStack.peek()  instanceof CommandeConcreteCouper){
                CommandeConcreteCouper derniere = (CommandeConcreteCouper)annulerCommandeStack.peek();
        return  derniere.getDonneesCoupees();

            }     
            
             if (annulerCommandeStack.peek()  instanceof CommandeConcreteColler){
                CommandeConcreteColler derniere = (CommandeConcreteColler)annulerCommandeStack.peek();
        return  derniere.getDonneesCollees();

            }     

    return "";                
    }    
    

    public void retablir(){
        if(!retablirCommandeStack.isEmpty()){
            retablirCommandeStack.pop().lancer();
        }else{
            System.out.println("Rien à retablir");
        }
    }
}
