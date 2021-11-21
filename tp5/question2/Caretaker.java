package question2;
import java.util.Stack;

/**
 * Classe Caretaker
 */
class Caretaker {
    //Ici, les diff�rents �tats sont stock�s dans une pile, comme demand� dans l'�nonc�
    private Stack<Memento> etatsSauvegardes = new Stack<Memento>();

    /**
     * ajoute m � la pile de Memento
     * @param Memento m
     */
    public void addMemento(Memento m) {
        etatsSauvegardes.push(m);
    }

    /**
     * retourne le sommet de la pile de Memento
     */
    public Memento getMemento() {
        return etatsSauvegardes.pop();
    }

    /**
     * retourne vrai si la pile de Memento est vide, fausse sinon
     * @return boolean
     */
    public boolean estVide(){
        return etatsSauvegardes.empty();
    }
}