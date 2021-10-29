
import java.util.*;

public class SacOrdonneAObjetsUniquesComp<E extends Comparable<E>> extends SacAObjetsUniques<E>{
 

    @Override
    public boolean ajouter(E e){
        boolean res;
        // cette fois ci il n'y a pas de tri
        res = super.ajouter(e);
        // si l'ajout c'est fait 
        if(res){
            Collections.sort(getSac())  ;      
        }
        return res;
    }
}