import java.util.*;  
import java.util.stream.*;  
public class SacOrdonneAObjetsUniques<E> extends SacAObjetsUniques<E>{
    // à compléter


    @Override
    public boolean ajouter(E e){
        if (! (e instanceof Comparable)){
            //new RunTimeException("il n'y a pas d'ordre sur " + e.getClass().getName());

            new RuntimeException("il n'y a pas d'ordre sur ");
        }

        if(! this.contient(e)){
            // pour créer un ensemble d'objets uniques et ordonnés
            Set<E> ensembleOrdonne = new TreeSet<>();
            for (E elt : this){
                ensembleOrdonne.add(elt);
            }
            ensembleOrdonne.add(e);

            Sac copie = new Sac();
            copie.ajouter(this);
            
            this.supprimer(copie);
            
            for (E ens : ensembleOrdonne){
                super.ajouter(ens);
            }
            return true;
        }
        
        return false;        
    }
}
// Une seule méthode est à redéfinir, pourquoi ?
