package question2;

import question1.PilePleineException;
import question1.PileVideException;
import question1.Pile0;


/**
 * Classe Pile
 */
public class Pile implements PileI {  
    
    private Pile0 pile;
    
    public Pile() {
         this(0);
    }

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit ï¿½tre > 0
     */
    public Pile(int taille) {
        if (taille <= 0){
            this.pile = new Pile0(PileI.CAPACITE_PAR_DEFAUT );
        }
        else{
            this.pile = new Pile0(taille);
        }
    }

    public void empiler(Object o) throws PilePleineException {
        pile.empiler(o);
    }

    /**
     * Retourne le sommet de la pile et le retire de la pile
     * 
     * @return la dernier ï¿½lï¿½ment de la pile
     */
    public Object depiler() throws PileVideException {
       return pile.depiler();
    }

    /**
     * Retourne le sommet de la pile
     * 
     * @return la dernier ï¿½lï¿½ment de la pile
     */
    public Object sommet() throws PileVideException {
       
        return pile.sommet();
    }

    /**
     * Retourne la taille de la pile
     * 
     * @return le nombre d'ï¿½lï¿½ments que la pile contient
     */
    public int taille() {
        return pile.taille();
    }

    /**
     * Retourne la capacitï¿½ de la pile
     * 
     * @return le nombre d'ï¿½lï¿½ments que la pile peut contenir
     */
    public int capacite() {
        return pile.capacite();
    }

    /**
     * Effectue un test de l'ï¿½tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return pile.estVide();
    }

    /**
     * Effectue un test de l'ï¿½tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return capacite() == taille();
    }

    public String toString() {
       return pile.toString();
    }

    /**
     * Effectue un test d'egalite entre l'objet courant et un Object
     * 
     * @return vrai si les objets sont égaux
     */
    public boolean equals(Object o) {
       
        boolean egalite = true;
        
        //il faut vérifier que pour toute Pile pile : pile == pile
        if (this == o){
            return egalite;
        }
        if (o instanceof Pile) {
          
           try{
                 Pile p = (Pile) o;
                Object sommet1;
                Object sommet2;
                if (p.taille() == this.taille() && p.capacite() == this.capacite()){
                    sommet1 = this.sommet();
                    sommet2 = p.sommet();
                    for(int i = 0; i < p.taille() ; i++){
                        if(!(sommet1 ==sommet2)){
                            egalite = false;
                            break;
                        }
                        else{
                           this.depiler();
                           p.depiler();
                        }       
                    }
                }
                else{
                    egalite = false;
                }
            }
            catch (Exception e){
               egalite = false;
            }
       }
        else{
            egalite = false;
        }
        return egalite;

        
      }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
