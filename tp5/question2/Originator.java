package question2;
import java.util.List;

class Originator {
    //l'�tat est ici une liste de String repr�sentant la liste de Chapitre2CoreJava2
    private List<String> etat;

    public void set(List<String> etat) {
        this.etat = etat;
    }

    /**
     * cr�e un nouvel Memento avant une modification
     * @return Memento
     */
    public Memento storeInMemento() {
        System.out.println("Originator: sauvegarde." );
        return new Memento(this.etat);
    }

    /**
     * restaure le dernier enregistrement de la pile de Memento
     * @param Memento memento
     */
    public List<String> restoreFromMemento(Memento memento) {
        System.out.println("Originator: restaure." );
        this.etat = memento.getEtatSauvegarde();
        return etat;
    }
}