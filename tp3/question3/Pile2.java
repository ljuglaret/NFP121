package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

    /** 
    * Classe Pile2<T>
    */
public class Pile2<T> implements PileI<T>{
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacit� de la pile */
    private int capacite;

   /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     * la taille de la pile, la taille doit �tre > 0
     */
    public Pile2(int taille) {
        if(taille <= 0){
            throw new NumberFormatException("la taille ne peut pas �tre n�gative");
        }
        stk = new Stack();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }
    
    /**
    * Retourne le sommet de la pile
    * 
    * @return la dernier �l�ment de la pile
    */
    public T sommet() throws PileVideException {
        return stk.peek();
    }

    /**
     * Place o au sommet de la pile
     * @param o
    */
    public void empiler(T  o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        stk.push(o);
    }

    /**
    * Retourne le sommet de la pile et le retire de la pile
    * 
    * @return la dernier �l�ment de la pile
    */
    public T depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.pop();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite == taille();
    }

    /**
     * Retourne une repr�sentation en String d'une pile, contenant la
     * repr�sentation en String de chaque �l�ment.
     * 
     * @return une repr�sentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (Object obj : stk){
            s+= obj+",";
        }
        return s+ "]";
    }

    /**
     * Effectue un test d'�galit� entre l'objet courant et un Object
     * 
     * @return vrai si la capacit� et le hashCode sont �gaux
     */
    public boolean equals(Object o) {
        if(o instanceof Pile2){
            return stk.equals((Pile2)o);
        }
        else {
            return false;
        }
    }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'�l�ment d'une pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacit� de cette pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int capacite() {
        return stk.capacity();
    }

} 