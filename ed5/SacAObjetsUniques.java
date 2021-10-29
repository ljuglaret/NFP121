import java.util.*;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class SacAObjetsUniques<E> extends Sac<E>{
    // à compléter
    
    private List<E> contenu ;

    
    public SacAObjetsUniques(){
        super();
        contenu =   new ArrayList<>();
    }
    
    @Override
    public boolean ajouter(E e){
        if(! this.contient(e)){
            return super.ajouter(e);      
        }
        else{
            return false;
        }
       
        
    }
    // Une seule méthode est à redéfinir, pourquoi ?
}