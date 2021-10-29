import java.util.Iterator;

public abstract class IncompleteCollection<E> implements CollectionI<E>{
    public abstract boolean ajouter(E e);

    public abstract Iterator<E> iterator();

    public boolean ajouter(CollectionI<E> c) {
        /**
         * On ne veut pas ajouter c si celui ci est égal à null
         */
        if(c == null){
            throw new NullPointerException();
        }
        boolean modifie = false;

        Iterator<E> it = c.iterator();
        while(it.hasNext()){
            boolean res = ajouter(it.next());
            modifie = modifie || res;
        }

        return modifie;
    }

    public boolean supprimer(E e){
        if(e == null){
            throw new NullPointerException();
        }
        Iterator<E> it = this.iterator();
        while(it.hasNext()){
            if(it.next().equals(e)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean supprimer(CollectionI<E> c){
        if(c == null){
            throw new NullPointerException();
        }
        boolean modifie = false;
        Iterator<E> e = iterator();
        while (e.hasNext()) {
            boolean res = c.contient(e.next());
            if(res) {
                e.remove();
                modifie = modifie || res;
            }
        }
        return modifie;
    }

    public boolean contient(E e) {
        if(e == null){
            throw new NullPointerException();
        }
        Iterator<E> it = iterator();
        if (e==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return true;
        } else {
            while (it.hasNext())
                if (e.equals(it.next()))
                    return true;
        }
        return false;
    }

    //return true si c est incluse dans la collection
    // => si un élément de c n'est pas dans this retourner faux
    // this = [1,2,3,4] c = [1,2,3] => true
    // this = [1,2,3,7] c = [1,2,3] => true
    // this = [1,2,3,4] c = [1,2,7] => false
    // this = [1,2,3], c = [1,2,3,4] => false
    public boolean contient(CollectionI<E> c){
        if (c.taille() > taille()){
            return false;
        }
        else{
            for (E e : c ){
                if(!this.contient(e)){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean equals(Object o){
        if((o == null) || (!(o instanceof CollectionI))) {
            throw new NullPointerException();
        }

        CollectionI c = (CollectionI) o;

        return ((c.taille() == taille()) &&
            (c.contient(this )) &&
            (this.contient(c))
        );

    }

    public int hashCode(){
        int h = 0;
        Iterator<E> i = iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            if (obj != null)
                h = h + obj.hashCode();
        }
        return h;
    }

    public int taille(){
        int cpt = 0 ;
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            it.next();
            cpt++;

        }
        return cpt;
    }

    public String toString(){
        String res = "[";
        Iterator<E> it = this.iterator();
        while(it.hasNext()){
            res = res + it.next();
            if(it.hasNext()) res = res + ", ";
        }
        return res + "]";
    }

}