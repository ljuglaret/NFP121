package question3;

import question1.*;
import java.util.*;

public class Memento {
    // Note : Un usage du patron Memento, 
    //        d’un premier visiteur pour la sauvegarde et 
    //        d’un second pour la restitution du composite, 
    //        représentent une solution possible. 
    private HashMap<Contributeur ,Integer> contributeurEtValeurDeSonCompte = new HashMap<Contributeur ,Integer>() ;
    public Memento(Cotisant c) {
        assert c!=null;
         // sauvegarde
        c.accepter(new Visiteur<Void>(){
                public Void visite(Contributeur contrib){
                    contributeurEtValeurDeSonCompte.put(contrib,contrib.solde());
                    return null;
                }

                public Void visite(GroupeDeContributeurs g){
                    for (Cotisant cotisant : g.getChildren()){
                        cotisant.accepter(this);//this == Visiteur
                    }
                    return null;
                }
            });
    }

    public void setState(Cotisant c) {
        assert c!=null;
        // restitution
        c.accepter(new Visiteur<Void>(){
                public Void visite(Contributeur contrib){
                    //verifie que contrib est dans  contributeurEtValeurDeSonCompte
                    if(contributeurEtValeurDeSonCompte.containsKey(contrib)){
                        int ancienSolde = contributeurEtValeurDeSonCompte.get(contrib);
                        contrib.affecterSolde(ancienSolde);
                    }
                    return null;
                }

                public Void visite(GroupeDeContributeurs g){
                    for (Cotisant cotisant : g.getChildren()){
                        cotisant.accepter(this);//this == Visiteur
                    }
                    return null;
                }
            });
    }
}