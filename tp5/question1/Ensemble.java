package question1;

import java.util.*;

/**
 * Classe Ensemble
 */
public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }


   /**
    * ajoute t à l'ensemble si l'ensemble ne contient pas t
    * @param t 
    * @return faux si t est présent, vrai sinon
    */
    public boolean add(T t) {
        // à compléter pour la question1-1
        if (this.contains(t)){
            return false;
        }
        else{
            return this.table.add(t);
        }
    }

    /**
     * retourne l'union de 2 ensembles
     * @param Ensemble<? extends T> e
     * @return Ensemble<T>
     */
    public Ensemble<T> union(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> union = new Ensemble<T>();
        union.addAll(this);
        union.addAll(e);
        return union; 
    }

    /**
     * retourne l'intersection de deux ensembles
     * @param Ensemble<? extends T> e
     * @return Ensemble<T>
     */
    public Ensemble<T> inter(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> inter = new Ensemble<T>();
        //on ajoute tous les �l�ments de A
        inter.addAll(this);
        //on retire ce qui ne sont pas dans B
        inter.retainAll(e);
        return inter;
    }

    /**
     *
     * @param Ensemble<? extends T> e
     * @return Ensemble<T>
     */
    public Ensemble<T> diff(Ensemble<? extends T> e) {
        // à compléter pour la question1-2
        Ensemble<T> difference = new Ensemble<T>();
        difference.addAll(this);
        difference.removeAll(this.inter(e));
        return difference; 
    }

    /** retourne le complémentaire de A inter B
     * (A union B ) - ( A inter B )
     * @param Ensemble<? extends T> e
     * @return Ensemble<T>
     */
    
    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        return (this.union(e)).diff(this.inter(e));
    }
}
    

