public class Constante implements Expr{
    private int valeur;
    
    public Constante (int valeur){
        this.valeur = valeur;
    }
    
    public <R> R accept (Visiteur<R> visiteur ){
        return visiteur.visitConstante(this);
    }
    
    public int getValeur(){
        return valeur;
    }
    
 

}