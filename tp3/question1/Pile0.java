
package question1;

import question2.PileI;


/**
 * Classe Pile
 */
 public class Pile0 implements PileI {
   private Object[] zone;
    private int ptr;

    /**
     * Cr?ation d'une pile.
     * 
     * @param taille
     *  la taille de la pile, la taille doit ?tre > 0
     */
    public Pile0(int taille) {
        if (taille < 0){
            this.zone = new Object[this.CAPACITE_PAR_DEFAUT] ;
        }
        else{
            this.zone = new Object[taille];
        }
        this.ptr = 0;

    }

    public Pile0() {
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
     * @return la dernier ?l?ment de la pile
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    
    /**
     * Effectue un test de l'?tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return ptr == 0;
    }

    /**
     * Effectue un test de l'?tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return ptr == zone.length;
    }



    /**
     * Retourne une repr?sentation en String d'une pile, contenant la
     * repr?sentation en String de chaque ?l?ment.
     * 
     * @return une repr?sentation en String d'une pile
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
    
    /**************************************************** Question 2.1****************************************************/
    
    
    /**
     * Retourne le sommet de la pile
     * 
     * @return la dernier ?l?ment de la pile
     */
    public Object sommet() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        return zone[this.ptr - 1];
    }

    /**
     * Retourne la capacit? de la pile
     * 
     * @return le nombre d'?l?ments que la pile peut contenir
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
     * @return le nombre d'?l?ments que la pile contient
     */
    public int taille() {
        return ptr;
    }


    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }
    
    
    /**
     * Effectue un test d'?galit? entre l'objet courant et un Object
     * 
     * @return vrai si la capacit? et le hashCode sont ?gaux
     */
    public boolean equals(Object o) {
        boolean egalite = true;
        if (o instanceof Pile0) {
            try{
                Pile0 p = (Pile0) o;
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
}