package question3;

import question3.tp3.PileI;
import question3.tp3.PileVideException;
import question3.tp3.PilePleineException;

/**
 * Classe Pile Modele
*/
public class PileModele<T> extends  java.util.Observable implements PileI<T> {

    private PileI<T> pile;

    public PileModele(PileI<T> pile) {
        this.pile = pile;
    }

    /***
     * Place o au sommet de la pile
     * @param o
     */
    public void empiler(T o) throws PilePleineException {
        if (estPleine()){
            throw new PilePleineException("pile pleine");
        }
        this.pile.empiler(o);
        setChanged();
        notifyObservers();
    }

    /***
     * Retire le sommet de la pile
     * @return le sommet
     */
    public T depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException("pile vide");
        }
        
        try{
            return this.pile.depiler();
        }
        finally{
            setChanged();
            notifyObservers();
        }
    }

    /***
     * @return le sommet
     */
    public T sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        return this.pile.sommet();
    }

    /***
     *@return le nombre d'éléments contenu dans la pile
     */
    public int taille() { 
        return pile.taille();
    }

    /***
    *@return le nombre d'éléments pouvant être contenu dans la pile
    */
    public int capacite() {
        return pile.capacite();
    }

    /***
     *@return vrai si la pile est vide, faux sinon
     */
    public boolean estVide() {
        return pile.estVide();
    }

    /***
     *@return vrai si la pile et pleine, faux sinon
     */
    public boolean estPleine() {
        return pile.estPleine();
    }

    public String toString() {
        return pile.toString();
    }
}

/**
 * notez qu'un message d'alerte subsiste à la compilation (unsafe ...) dû à
 * l'emploi de notifyObservers, incontournable et sans conséquence ici
 */
