package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class SansDoublon implements Visiteur<Boolean>{
    private Set<String> nomsDejaVus = new TreeSet<String>();
    
    /**
     * visite un contributeur c, renvoie vrai si il n'a pas de doublons
     * @param c
     * @return Boolean
     */
    public Boolean visite(Contributeur c){
        if(nomsDejaVus.contains(c.nom())){
            return false;
        }
        else {
            nomsDejaVus.add(c.nom());
            return true;
        }
    }
    /**
     * visite un contributeur c, renvoie vrai si il n'a pas de doublons
     * @param c
     * @return Boolean
     */
    public Boolean visite(GroupeDeContributeurs g){
        if(nomsDejaVus.contains(g.nom())){
            return false;
        }
        else {
            nomsDejaVus.add(g.nom());
        }
        for (Cotisant cotisant : g.getChildren()){
            Boolean pasDeDoublons = cotisant.accepter(this);
            if(!pasDeDoublons){
                return false;
            }
        }
        return true;
    }
}