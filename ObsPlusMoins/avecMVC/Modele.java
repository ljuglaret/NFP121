package avecMVC;

import java.util.*;
/**
 * Le modèle est un observable
 */
public  class Modele implements IObservable{

    List<IObservateur> l ;
    private int n;
    
    public  Modele(int n){
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
            obs.actualiser(this,this.getValeur());
        }
    }
    
    public int add (){
        return n + 1;
    }
    
    public int sub (){
        return n - 1;
    }
}

