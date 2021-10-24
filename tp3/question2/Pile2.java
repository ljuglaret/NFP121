package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacit� de la pile */
    private int capacite;

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile2(int taille) {

        if (taille <= 0){
            this.capacite = PileI.CAPACITE_PAR_DEFAUT ;
        }
        else{
            stk = new Stack<Object>();
            this.capacite = taille;
        }
    }

    // constructeur fourni
    public Pile2() {    
        this(PileI.CAPACITE_PAR_DEFAUT );
    }

    public void empiler(Object o) throws PilePleineException {
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
    public Object depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.pop();
    }

    /**
     * Retourne le sommet de la pile
     * 
     * @return la dernier �l�ment de la pile
     */
    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return stk.peek();
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
        for (int i =  stk.size() - 1 ; i >=0 ; i--){
            s+= stk.get(i);
            if(i > 0) {
                s+=", ";
            }
        }
        return s+ "]";
    }

    public boolean equals(Object o) {
        boolean egalite = true;
        if (o instanceof Pile2) {
            try{
                Pile2 p = (Pile2) o;
                if (p.taille() == this.taille() && p.capacite() == this.capacite()){
                    for(int i = 0; i < p.taille() ; i++){
                        if(!(stk.get(i).equals(p.stk.get(i)))){
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
     * Retourne le nombre d'�l�ment d'une pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacit� de la pile
     * 
     * @return le nombre d'�l�ments que la pile peut contenir
     */
    public int capacite() {
        if(capacite < 0){
            return this.CAPACITE_PAR_DEFAUT ;
        }
        else{
            return capacite;

        }
    }

} // Pile2.java
