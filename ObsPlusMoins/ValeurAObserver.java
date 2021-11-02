import java.util.*;
/**
 * Décrivez votre classe abstraite FacebookView ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
public  class ValeurAObserver implements IObservable{

    List<IObservateur> l ;
    private int n;
    
    public  ValeurAObserver(int n){
        l =  new ArrayList<>();
        this.n  = n;
        
    }
    
    public   void ajoutObservateur(  IObservateur o){
        l.add(o);
    }

    public void suppressionObservateur(  IObservateur o){
        l.remove(o);
    }

    public int getValeur(){
        return n;
    }
  
    public void notifierObservateurs( ){
        for (IObservateur obs : l){
            n = obs.actualiser(this);
            System.out.println("passage par " + obs.getClass().getName() + " : " + n);
        }
    }

}

