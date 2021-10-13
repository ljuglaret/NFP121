
/**
 * Décrivez votre classe EntierPositif ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EntierPositif extends Entier
{
    private int x;
    /**
     * Constructeur d'objets de classe EntierPositif
     */
    public EntierPositif(int x){
        super(x);
        if(x < 0 ){
             throw new EntierPositifException("constructeur en défaut");
        }
        this.x=x;
    }
    

     public boolean repOk(){
         return x >= 0 && x <= Integer.MAX_VALUE;
    }

    public void setEntier(int nouvelleValeur){
        x = nouvelleValeur;
        if(nouvelleValeur < 0){
             throw new EntierPositifException("setEntier en défaut");
        }
        super.setEntier(nouvelleValeur);
    }
    
    public void dec (){
        if (this.x == 0){
            throw new EntierPositifException("dec en défaut");
        }
        super.dec();
    }
    
    public void inc(){
        if (x >= Integer.MAX_VALUE){
            throw new EntierPositifException("inc en défaut");
        }
        super.inc();
    }
}
