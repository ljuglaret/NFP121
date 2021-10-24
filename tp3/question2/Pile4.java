package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0){
            //this.stk = null;
            this.capacite  = this.CAPACITE_PAR_DEFAUT;
        }
        else{
            //this.stk = null;
            this.capacite = taille;
        }
        this.stk = null;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
        this.nombre = 0;
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        nombre++;
        this.stk = new Maillon(o,this.stk);
    }

    /**
    * Retourne le sommet de la pile et le retire de la pile
    * 
    * @return la dernier élément de la pile
    */
    public Object depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        Object dernier =  stk.element;
        stk = stk.suivant();
        nombre--;
        return dernier;  
    }

    /**
    * Retourne le sommet de la pile
    * 
    * @return la dernier élément de la pile
    */
    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.element; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return nombre == 0; 
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return taille() == capacite(); // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        Maillon tmp = stk;
        while (tmp != null){
            s = s + tmp.element() ;
            tmp = tmp.suivant();
            if (tmp !=null) {
                s = s + ", ";
            }  
        }  
        return s + "]"; 
    }

    /**
     * Effectue un test d'égalité entre l'objet courant et un Object
     * 
     * @return vrai si la capacité et le hashCode sont égaux
     */
    public boolean equals(Object o) {
        boolean egalite = true;
        if (o instanceof Pile4) {
            Pile4 p = (Pile4) o;
              Maillon m1;
            Maillon m2;
           try{
                if (p.taille() == this.taille() && p.capacite() == this.capacite()){
                    m1 = stk;
                    m2 = p.stk;
                    for(int i = 0; i < nombre ; i++){
                        if(!(m1.element()==(m2.element()))){
                            egalite = false;
                            break;
                        }
                        else{
                            m1 = m1.suivant();
                            m2 = m2.suivant();
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
    /**
    * Retourne la capacité de la pile
    * 
    * @return le nombre d'éléments que la pile peut contenir
    */
    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }
    
    /**
    * Retourne la taille de la pile
    * 
    * @return le nombre d'éléments que la pile contient
    */
    public int taille() {
        return nombre;
    }
}