package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * D�crivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // � compl�ter
    }

    public void empiler(Object o) throws PilePleineException {
        v.add(o);
        // � compl�ter
    }

    public Object depiler() throws PileVideException {
        return null;
    }

    public Object sommet() throws PileVideException {
        // � compl�ter
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
        // � compl�ter
        return "";
    }

    public boolean equals(Object o) {
        // � compl�ter
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
