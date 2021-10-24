package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 *Classe Pile3
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(PileI.CAPACITE_PAR_DEFAUT );
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile3(int taille) {
        if (taille <= 0){
            this.v = new Vector<Object>(PileI.CAPACITE_PAR_DEFAUT );
        }
        else{
            this.v = new Vector<Object>(taille);
        }
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        v.add(o);
    }

    /**
     * Retourne le sommet de la pile et le retire de la pile
     * 
     * @return la dernier élément de la pile
     */
    public Object depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        Object dernierElement = v.lastElement();
        v.remove(taille() - 1 );
        return dernierElement;
    }

    /**
     * Retourne le sommet de la pile
     * 
     * @return la dernier élément de la pile
     */
    public Object sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        return v.lastElement();
    }

    /**
     * Retourne la taille de la pile
     * 
     * @return le nombre d'éléments que la pile contient
     */
    public int taille() {
        return v.size();
    }

    /**
     * Retourne la capacité de la pile
     * 
     * @return le nombre d'éléments que la pile peut contenir
     */
    public int capacite() {
        return v.capacity();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return v.isEmpty();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
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

    /**
     * Effectue un test d'égalité entre l'objet courant et un Object
     * 
     * @return vrai si la capacité et le hashCode sont égaux
     */
    public boolean equals(Object o) {
        boolean egalite = true;

        if (o instanceof Pile3) {
            try {
                Pile3 p = (Pile3) o;
                if (p.taille() == this.taille() && p.capacite() == this.capacite()){
                    for(int i = 0; i < p.taille() ; i++){
                        if(!(v.get(i).equals(p.v.get(i)))){
                            egalite = false;
                            break;
                        }
                    }
                }
                else{
                    egalite = false;
                }
            }
            catch (Exception e){
               egalite = false;
            }
       }
        else{
            egalite = false;
        }
        return egalite;
      }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
