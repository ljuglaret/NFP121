package question1;

import question3.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class GroupeDeContributeurs extends Cotisant implements Iterable<Cotisant>{
    private List<Cotisant> liste;

    public GroupeDeContributeurs(String nomDuGroupe){
        super(nomDuGroupe);
        liste = new ArrayList<>();
    }

    /**
     * ajoute un cotisant au groupe de contributeur
     * @param cotisant
     */
    public void ajouter(Cotisant cotisant){
        assert cotisant!=null && cotisant.getParent()==null;
        this.liste.add(cotisant);   
        cotisant.setParent(this);
    }

    /**
     * calcule le nombre de cotisants
     * @return int
     */
    public int nombreDeCotisants(){
        int nombre = 0;
        for(Cotisant c : getChildren()) {
            nombre += c.nombreDeCotisants();
        }
        return nombre;
    }

    /**
     * 
     * @return String
     */
    public String toString(){
        String str = new String();
        str+=nom();
        for(Cotisant c : getChildren()) {
            str += c.toString();
        }
        return str;
    }

    /**
     * renvoie tous les enfants du groupe de contributeurs
     * @return List<Cotisant>
     */
    public List<Cotisant> getChildren(){

        return this.liste;
    }

    /**
     * retire somme à tous les cotisants du groupe de contributeurs
     * @param somme
     * @throws SoldeDebiteurException
     */
    public void debit(int somme) throws SoldeDebiteurException{
        Memento sauvegarde = new Memento(this);
        try{
            for (Cotisant cotisant : getChildren()){
                cotisant.debit(somme);
            }
        }
        catch(SoldeDebiteurException e){
            sauvegarde.setState(this);
            throw e;
        }
    }

    /**
     * ajoute somme à tous les cotisants du groupe de contributeurs
     * @param somme
     */
    public void credit(int somme){
        for (Cotisant cotisant : getChildren()){
            cotisant.credit(somme);
        }
    }

    /**
     * calcule la solde totale
     * @return int
     */
    public int solde(){
        int solde = 0;
        for (Cotisant cotisant : getChildren()){
            solde += cotisant.solde();
        }
        return solde;
    }

    // m�thodes fournies

    public Iterator<Cotisant> iterator(){
        return new GroupeIterator(liste.iterator());
    }

    private class GroupeIterator implements Iterator<Cotisant>{
        private Stack<Iterator<Cotisant>> stk;

        public GroupeIterator(Iterator<Cotisant> iterator){
            this.stk = new Stack<Iterator<Cotisant>>();
            this.stk.push(iterator);
        }

        public boolean hasNext(){
            if(stk.empty()){
                return false;
            }else{
                Iterator<Cotisant> iterator = stk.peek();
                if( !iterator.hasNext()){
                    stk.pop();
                    return hasNext();
                }else{
                    return true;
                }
            }
        }

        public Cotisant next(){
            if(hasNext()){
                Iterator<Cotisant> iterator = stk.peek();
                Cotisant cpt = iterator.next();
                if(cpt instanceof GroupeDeContributeurs){
                    GroupeDeContributeurs gr = (GroupeDeContributeurs)cpt;
                    stk.push(gr.liste.iterator());
                }
                return cpt;
            }else{
                throw new NoSuchElementException();
            }
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public <T> T accepter(Visiteur<T> visiteur){
        return visiteur.visite(this);
    }

}
