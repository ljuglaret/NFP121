package question2;

import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class CompositeValide implements Visiteur<Boolean>{
    // Le solde de chaque contributeur doit �tre sup�rieur ou �gal � un nombre transmis en param�tre 
    // et il n�existe pas de groupe n�ayant pas de contributeurs.
    // groupe de contributeurs : pas de cycle
    private int valeur;
    private Stack<GroupeDeContributeurs> groupesDejaVus = new Stack();
    public CompositeValide(int valeur){
        this.valeur = valeur;
    }

    public CompositeValide(){
        this(0);
    }

    /**
     * visite un contributeur c, renvoie vrai si il est valide
     * @param c
     * @return Boolean
     */
    public Boolean visite(Contributeur c){
        return c.solde() >= valeur;
    }

    /**
     * visite un contributeur g,renvoie vrai si il est valide
     * @param g
     * @return Boolean
     */
    public Boolean visite(GroupeDeContributeurs g){
         //pas vide et  pas de cycles
        if(g.getChildren().isEmpty() ){
            return false;
        }
        for(GroupeDeContributeurs gr : groupesDejaVus ){
            if (gr == g){
                return false;
            }
        }
          //se souvenir qu'on l a vu (pour �viter un cycle)  
        groupesDejaVus.push(g);
          
        
        for (Cotisant cotisant : g.getChildren()){
            Boolean enfantValide = cotisant.accepter(this);
            if(!enfantValide){
                groupesDejaVus.pop();
                return false;
            }
        }
        groupesDejaVus.pop();        
        return true;
    }
}