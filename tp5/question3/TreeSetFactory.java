package question3;

import java.util.Set;
import java.util.TreeSet;


// Proposez la fabrique d'ensemble  TreeSetFactory
/**
 * Classe TreeSetFactory
 */
public class TreeSetFactory<T extends Comparable>implements Factory<Set>{
 public Set create(){
    //en utilisant la classe concrete java.util.TreeSet,
    //attention dans ce cas les elements doivent etre comparables
     return new TreeSet<Comparable<T>>(); 
    }
}
