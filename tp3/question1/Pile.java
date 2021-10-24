
package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * Classe Pile
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * Initialise une pile de capacite taille
     * @param int taille
     */
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    /**
     * Initialise une pile de capacite TAILLE_PAR_DEFAUT
     * 
     */
    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    /**
     * 
     * Place i au sommet de la pile.
     * @param i
     */
    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
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
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String de la pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}