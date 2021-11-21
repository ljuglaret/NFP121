package question2;

import java.util.List;
/**
 * Classe Memento
 */
class Memento {
    private final List<String> etat;

    /**
     * Constructeur de la classe
     *@param List<String>
     */
    public Memento(List<String> etatsASauvergarder) {
        etat = etatsASauvergarder;
    }

    /**
     * @return List<String>
     */
    public List<String> getEtatSauvegarde() {
        return etat;
    }
}

    