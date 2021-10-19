package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

   /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile2(int taille) {
        if(taille <= 0){
            throw new NumberFormatException("la taille ne peut pas être négative");
        }
        stk = new Stack();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }
    
        public T sommet() throws PileVideException {
        return stk.peek();
    }

    public void empiler(T  o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        stk.push(o);
    }

    public T depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.pop();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite == taille();
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (Object obj : stk){
            s+= obj+",";
        }
        return s+ "]";
    }


    public boolean equals(Object o) {
       return stk.equals(o);
    }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'élément d'une pile.
     * 
     * @return le nombre d'élément
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacité de cette pile.
     * 
     * @return le nombre d'élément
     */
    public int capacite() {
        return stk.capacity();
    }


    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2