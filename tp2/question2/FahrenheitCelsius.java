package question2;

/**
 * Classe FahrenheitCelsius.
 */
public class FahrenheitCelsius {

    /**
    * Méthode principale
    * @param args tableau de chaines de caracteres representant des degres
    *             fahrenheit
    */
    public static void main(String[] args) throws NumberFormatException {
        for (String arg : args) {
            try {
                int fInt = Integer.parseInt(arg);
                float celsius = fahrenheitEnCelsius(fInt);
                System.out.println(arg + "\u00B0F -> " + celsius + "\u00B0C"); 
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION");
            }
        }
    }

    /**
     * Fonction de conversion Fahrenheit vers Celsius en remontant si besoin l'erreur  NumberFormatException
     * @param f la valeur en degre Fahrenheit
     * @return la conversion en degre Celsius
     */

    public static float fahrenheitEnCelsius(int celsiusInt) throws NumberFormatException {
        return question1.FahrenheitCelsius.fahrenheitEnCelsius(celsiusInt);
    }

    /*
     * Sans utiliser la mï¿½thode parseInt de la classe Integer :
     * 
     * public static float fahrenheitEnCelsius2(String str) throws
     * NumberFormatException { int taille = str.length(); if (taille == 0){ throw
     * new NumberFormatException("chaine vide " + str); } char premierChar =
     * str.charAt(0); if(! ( (taille == 1 && Character.isDigit(premierChar)) ||
     * (premierChar == '-' && taille > 1) || (Character.isDigit(premierChar)&&
     * taille > 1))) { throw new NumberFormatException(str +" n'est pas un entier "
     * ); }
     * 
     * for(int i = 1 ; i < taille ; i++){ if (!Character.isDigit(str.charAt(i))){
     * throw new NumberFormatException( str.charAt(i) +" n'est pas un entier " ); }
     * }
     * 
     * boolean estNegatif = premierChar == '-'; int acc = 0 ; // 123 = 100 + 20 + 3
     * = 10*(10 + 2)+3 = 10*(10*(1) + 2) + 3 if (estNegatif){ for(int i = 1 ; i <
     * taille ; i++){ int valNum = Character.getNumericValue(str.charAt(i)); acc =
     * 10*acc + valNum ; } return - (float)((int)(10*((float)(acc - 32 ) * 5/9)
     * ))/10; } else{ for(int i = 0 ; i < taille ; i++){ int valNum =
     * Character.getNumericValue(str.charAt(i)); acc =10*acc + valNum ; } return
     * (float)((int)(10*((float)(acc - 32 ) * 5/9) ))/10; } }
     */

}
