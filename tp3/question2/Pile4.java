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
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        nombre++;
        this.stk = new Maillon(o,this.stk);
    }

    public Object depiler() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        
        Object dernier =  stk.element;
        stk = stk.suivant();
        nombre--;
        return dernier;
        
}

public void depiler2() throws PileVideException {
        if (estVide()){
            throw new PileVideException();
        }
        
       
        Maillon temp1 , temp2;
        Maillon lastElement = null;
        int x;
        int index = 0 ;
        stk = stk.suivant();
        nombre--;
       
        
}


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
        Maillon temp;
        int x;
        temp = stk;
        for(x=0; x<nombre ; x++) {
            s+=temp.element();
            if(x < nombre - 1 ){
               s+=", ";
            }
            temp = temp.suivant();
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            PileI p = (PileI) o;
            return this.capacite() == p.capacite()
                  && this.hashCode() == p.hashCode();
        }
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}