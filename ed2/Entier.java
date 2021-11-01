
/**
 * classe Entier redefinition des méthodes de la classe Integer
 * 
 * @Laure Juglaret @v1.0.0
 */
import java.lang.Integer;
import java.util.Observable;
import java.util.ArrayList;

public class Entier  extends Observable{
    // variable d'instance
    private int entier;
    ObservateurEntier obs = new ObservateurEntier();
   // ObservateurEntier obsInc = new ObservateurEntier();
   // ObservateurEntier obsDec = new ObservateurEntier();
    
              

    /**
     * Constructeur d'objets de classe Entier
     */
    public Entier(int entier) {

        this.entier = entier;
        this.addObserver(obs);
        //this.addObserver(obsInc);
        // this.addObserver(obsDec);
       
    }
    

    public void inc() {
       try{
            this.entier++;
            this.setChanged();
            this.notifyObservers(this.entier);
        }
        catch(NumberFormatException e){}
         
       
    }

    public void dec() {
      
            this.entier--;
            this.setChanged();
            this.notifyObservers(this.entier);
        
    }

    public int getEntier() {
        return this.entier;
    }

    public Integer af() {
        Integer iInteger =  Integer.valueOf(getEntier()); //new Integer(getEntier())
        return iInteger;
    }

    public void setEntier(int newEntier) {
        this.entier = newEntier;
        this.setChanged();
            this.notifyObservers(this.entier);
       
    }

    /*
     * public boolean equals (Entier o2){ if (o2 == null){ throw new
     * NullPointerException(""); } return entier == o2.entier; }
     */

    public boolean equals(Object o2) {
        if (o2 instanceof Entier) {
            Entier ent2 = ((Entier) o2);
            return this.entier == ent2.entier;
        } else {
            return false;
        }

    }

    public int hashCode() {
        return this.entier;
    }

    public static Entier parseEntier(String str) throws NumberFormatException {
        int taille = str.length();
        if (taille == 0) {
            throw new NumberFormatException("chaine vide " + str);
        }
        char premierChar = str.charAt(0);
        if (!((taille == 1 && Character.isDigit(premierChar)) || (premierChar == '-' && taille > 1)
                || (Character.isDigit(premierChar) && taille > 1))) {
            throw new NumberFormatException(str + " n'est pas un entier ");
        }

        for (int i = 1; i < taille; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                throw new NumberFormatException(str.charAt(i) + " n'est pas un entier ");
            }
        }

        boolean estNegatif = premierChar == '-';
        int acc = 0;
        // 123 = 100 + 20 + 3 = 10*(10 + 2)+3 = 10*(10*(1) + 2) + 3
        if (estNegatif) {
            for (int i = 1; i < taille; i++) {
                int valNum = Character.getNumericValue(str.charAt(i));
                acc = 10 * acc + valNum;
            }
            return new Entier(-acc);
        } else {
            for (int i = 0; i < taille; i++) {
                int valNum = Character.getNumericValue(str.charAt(i));
                acc = 10 * acc + valNum;
            }
            return new Entier(acc);
        }
    }

    public static String inverseString(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }

    /*
     * toute base b contient b - 1 éléments la base 16 est représentée par : 0 - 1 -
     * 2 ... - 10 - 11 - 12 - 13 - 14 - 15 Pour éviter toute confusion 10 - 11 - 12
     * - 13 - 14 - 15 sont respectivement remplacés par : A - B - C - D - E - F
     */
    public static String lettresHexa(int entier) {
        if (entier < 10) {
            return String.valueOf(entier);
        } else {
            switch (entier) {
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
                default:
                    return "";

            }
        }
    }

    /*
     * lors d'une conversion d'un entier x exprimé en base 10 vers sa représentation
     * en base 16 on divise successivement x par 16 et on enregistre les restes :
     * r0, r1, r2,...,rp. la condition de fin est : x/16 = 0 x en base 16 se lit :
     * rp,...,r2,r1,r0
     */
    public String representationEnBase16() {
        if (entier < 0) {
            throw new NumberFormatException("Attention, entier négatif");
        }
        String restes = "";
        while (entier > 0) {
            restes += lettresHexa(entier % 16);
            entier = entier / 16;
        }
        return inverseString(restes);
    }
}
