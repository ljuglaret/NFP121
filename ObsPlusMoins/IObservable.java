
/**
 * Décrivez votre interface IsObservable ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */

public interface IObservable<T>
{
      
    int getValeur();
    
    void ajoutObservateur(  IObservateur o);

    void suppressionObservateur(  IObservateur o);

    void notifierObservateurs( );
}
