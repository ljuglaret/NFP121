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

    public void retablir(){
        if(!retablirCommandeStack.isEmpty()){
            retablirCommandeStack.pop().lancer();
        }else{
            System.out.println("Rien à retablir");
        }
    }
}
