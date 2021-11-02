
/**
 * Décrivez votre classe WebBrower ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Moins implements IObservateur
{
   
    public Moins(){
       
    }
    
    public int actualiser(IObservable o){
        return o.getValeur() - 1 ;
    };
    
   
   
}