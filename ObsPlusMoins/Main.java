import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        
        ValeurAObserver ent = new ValeurAObserver(2);
        System.out.println("valeur à observer : " + ent.getValeur());
        Plus  plus = new Plus();
        Moins moins = new Moins();
        
        ent.ajoutObservateur(plus);
        ent.ajoutObservateur(plus);
        ent.ajoutObservateur(moins);
        ent.ajoutObservateur(moins);
        ent.ajoutObservateur(plus);
        ent.ajoutObservateur(plus);

        ent.notifierObservateurs();
    }
}
