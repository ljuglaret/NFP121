package question3;
import java.util.HashSet;
import java.util.Set;




//Proposez la fabrique d'ensemble HashSetFactory
/**
 * Classe HashSetFactory
 */
public class HashSetFactory<T>implements Factory<Set>{
 public Set create(){
    //en utilisant la classe concrete java.util.HashSet
     return new HashSet<T>(); 
    }
}
