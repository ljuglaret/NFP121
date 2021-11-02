package question2;

import question1.PilePleineException;
import question1.PileVideException;
import question1.Pile0;


/**
 * Classe Pile
 */
public class Pile implements PileI {  
    
    private Pile0 stk;
    
    public Pile() {
        this(PileI.CAPACITE_PAR_DEFAUT );
    }

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile(int taille) {
        if (taille <= 0){
            this.stk = new Pile0(PileI.CAPACITE_PAR_DEFAUT );
        }
        else{
            this.stk = new Pile0(taille);
        }
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        stk.empiler(o);
    }

    /**
     * Retourne le sommet de la pile et le retire de la pile
     * 
     * @return la dernier �l�ment de la pile
     */
    public Object depiler() throws PileVideException {
       return stk.depiler();
    }

    /**
     * Retourne le sommet de la pile
     * 
     * @return la dernier �l�ment de la pile
     */
    public Object sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        return stk.sommet();
    }

    /**
     * Retourne la taille de la pile
     * 
     * @return le nombre d'�l�ments que la pile contient
     */
    public int taille() {
        return stk.taille();
    }

    /**
     * Retourne la capacit� de la pile
     * 
     * @return le nombre d'�l�ments que la pile peut contenir
     */
    public int capacite() {
        return stk.capacite();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.estVide();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite() == taille();
    }

    public String toString() {
       return stk.toString();
    }

    /**
     * Effectue un test d'�galit� entre l'objet courant et un Object
     * 
     * @return vrai si la capacit� et le hashCode sont �gaux
     */
    public boolean equals(Object o) {
      return stk.equals(o);
      }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
