
/**
 * Décrivez votre classe EntierPositif ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EntierPositif extends Entier
{
    /**
     * Constructeur d'objets de classe EntierPositif
     */
    public EntierPositif(int x){
        super(x);
        if(x < 0 ){
             throw new EntierPositifException("constructeur en défaut");
        }
    }
    
     public boolean repOk(){
         return this.getEntier() >= 0 && this.getEntier() <= Integer.MAX_VALUE;
    }

    public void setEntier(int nouvelleValeur){
        if(nouvelleValeur < 0){
             throw new EntierPositifException("setEntier en défaut");
        }
        super.setEntier(nouvelleValeur);
    }
    
    public void dec (){
        if (this.getEntier() == 0){
            throw new EntierPositifException("dec en défaut");
        }
        super.dec();
    }
    
    public void inc(){
        if (this.getEntier() >= Integer.MAX_VALUE){
            throw new EntierPositifException("inc en défaut");
        }
        super.inc();
    }
}
