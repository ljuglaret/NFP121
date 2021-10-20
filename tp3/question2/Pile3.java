package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }
    
    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile3(int taille) {
        if (taille < 0){
            this.v = new Vector<Object>(PileI.CAPACITE_PAR_DEFAUT );
            throw new NumberFormatException("la taille ne peut pas être négative");
        }
        this.v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        Object dernierElement = v.lastElement();
        v.remove(taille() - 1 );
        return dernierElement;
    }

    public Object sommet() throws PileVideException {
         if (estVide()){
            throw new PileVideException();
        }
        return v.lastElement();
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return capacite() == taille();
    }

    public String toString() {
        String s = "[";
        for (int i =  v.size() - 1 ; i >=0 ; i--){
            s+= v.get(i);
            if(i > 0) {
                s+=", ";
            }
        }
        return s+ "]";
    }

    public boolean equals(Object o) {
          if (o instanceof PileI) {
              PileI p = (PileI) o;
              return this.capacite() == p.capacite()
                  && this.hashCode() == p.hashCode();
        }
        else{
            return false;
        }
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
