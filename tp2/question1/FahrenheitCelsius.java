package question1;

/**
 * 
 * @Laure Juglaret @v1.0.0
 */
public class FahrenheitCelsius {
    public FahrenheitCelsius() {
    }

    /**
     * le point d'entrée de cette application, dont le commentaire est à compléter
     * 
     * @param args tableau de chaines de caractères représentant des degrés
     *             fahrenheit
     */
    public static void main(String[] args) {
        // pour tous les paramètres de la ligne de commande
        for (String arg : args) {
            int fahrenheit = Integer.parseInt(arg);
            float celsius = fahrenheitEnCelsius(fahrenheit);
            System.out.println(fahrenheit + "\u00B0F -> " + celsius + "\u00B0C"); // ligne,
            // format
            // imposés
        }
    }

    /**
     * la méthode à compléter.
     * 
     * @param f la valeur en degré Fahrenheit
     * @return la conversion en degré Celsius
     */
    public static float fahrenheitEnCelsius(int f) {
        return (float) ((int) (10 * ((float) (f - 32) * 5 / 9))) / 10;
        /*
         * formule utilis�e dans les premiers test pour obtenir un arrondi :
         * (float)Math.round(10 * ((float)f - 32 ) * 5/9)/10 ; pour 100�F => 37.8 car
         * 100�F = 37.778 les tests en local �taient valid�s mais pas ceux sur le
         * serveur
         */
    }
}
