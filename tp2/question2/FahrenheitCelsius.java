package question2;

/**
 * classe FahrenheitCelsius : similaire � la question mais avec gestion
 * exception
 * 
 * @Laure Juglaret @v1.0.0
 */
public class FahrenheitCelsius {

    /**
     * le point d'entr�e de cette application, dont le commentaire est � compl�ter
     *
     * @param args un tableau de temp�ratures en degr� Fahrenheit, chacune
     *             repr�sent�e sous forme de String
     */
    public static void main(String[] args) throws NumberFormatException {
        for (String arg : args) {
            try {
                int fInt = Integer.parseInt(arg);
                float celsius = fahrenheitEnCelsius(fInt);
                System.out.println(arg + "\u00B0F -> " + celsius + "\u00B0C"); // ligne,
            } catch (NumberFormatException e) {
                System.out.println("EXCEPTION");
            }
        }
    }

    /**
     * la m�thode � compl�ter.
     * 
     * @param f la valeur en degr� Fahrenheit sous forme de cha�ne de caract�res
     * @return la conversion en degr� Celsius
     */

    public static float fahrenheitEnCelsius(int celsiusInt) throws NumberFormatException {
        return question1.FahrenheitCelsius.fahrenheitEnCelsius(celsiusInt);
    }

    /*
     * Sans utiliser la m�thode parseInt de la classe Integer :
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
