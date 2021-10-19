package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
    }

    public void empiler(Object o) throws PilePleineException {
        v.add(o);
        // à compléter
    }

    public Object depiler() throws PileVideException {
        return null;
    }

    public Object sommet() throws PileVideException {
        // à compléter
        return null;
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return v.capacity();
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return false;
    }

    public String toString() {
        // à compléter
        return "";
    }

    public boolean equals(Object o) {
        // à compléter
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
