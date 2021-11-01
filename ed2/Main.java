import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        
        Entier ent = new Entier(2);
        ent.inc();
        ent.inc();
        ent.inc();        
        ent.inc();

        /*
         * for (String arg : args) { try { Entier entIncr = Entier.parseEntier(arg);
         * entIncr.inc(); System.out.println(entIncr.hashCode()); } catch
         * (NumberFormatException e) { System.out.println("EXCEPTION"); } }
         */
    }
}
