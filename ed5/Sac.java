import java.util.*;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
public class Sac<E> extends IncompleteCollection<E>{

    private List<E> contenu;

    public Sac(){
        this.contenu = new ArrayList<>();
    }
    
    public List<E> getSac(){
    
        return contenu;
    }

    @Override
    public boolean ajouter(E e){
    if(e == null){
        throw new NullPointerException();
    }
    return this.contenu.add(e);

    }
  
    @Override
    public Iterator<E> iterator(){
        return contenu.iterator();// new SacIterator<E>();  
    }
   
}
