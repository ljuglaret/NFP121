package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * Classe Pile
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    /**
     * Création d'une pile.
     * 
     * @param taille
     *  la taille de la pile, la taille doit être > 0
     */
    public Pile(int taille) {
        if (taille < 0){
            this.zone = new Object[this.CAPACITE_PAR_DEFAUT] ;
        }
        else{
            this.zone = new Object[taille];
        }
        this.ptr = 0;

    }

    public Pile() {
        this.zone = new Object[this.CAPACITE_PAR_DEFAUT];
        this.ptr = 0;
    }

    /**
     * Place o au sommet de la pile.
     * @param o
     */
    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    /**
     * Retourne le sommet de la pile et le retire de la pile
     * 
     * @return la dernier élément de la pile
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
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
        return zone[this.ptr - 1];
    }

    /**
     * Retourne la capacité de la pile
     * 
     * @return le nombre d'éléments que la pile peut contenir
     */
    public int capacite() {
        if (ptr <= 0)
            return this.CAPACITE_PAR_DEFAUT ;
        else 
            return zone.length ;
    }

    /**
     * Retourne la taille de la pile
     * 
     * @return le nombre d'éléments que la pile contient
     */
    public int taille() {
        return ptr;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return ptr == 0;
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return ptr == zone.length;
    }

    /**
     * Effectue un test d'égalité entre l'objet courant et un Object
     * 
     * @return vrai si la capacité et le hashCode sont égaux
     */
    public boolean equals(Object o) {
        boolean egalite = true;
        if (o instanceof Pile) {
            try{
                Pile p = (Pile) o;
                if (p.taille() == this.taille() && p.capacite() == this.capacite()){
                    for(int i = 0; i < p.taille() ; i++){
                        if(!(zone[i].equals(p.zone[i]))){
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

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(String.valueOf(zone[i]));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}