package question2;
import java.util.Stack;

/**
 * Classe Caretaker
 */
class Caretaker {
    //Ici, les différents états sont stockés dans une pile, comme demandé dans l'énoncé
    private Stack<Memento> etatsSauvegardes = new Stack<Memento>();

    /**
     * ajoute m à la pile de Memento
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