package question1;

/**
 * Classe FahrenheitCelsius.
 * @Laure Juglaret @v1.0.0
 */
public class FahrenheitCelsius {
    public FahrenheitCelsius() {
    }

    /**
     * M�thode principale
     * @param args tableau de chaines de caracteres representant des degres
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
     *Fonction de conversion Fahrenheit vers Celsius en remontant si besoin l'erreur  NumberFormatException
     * 
     * @param f la valeur en degre Fahrenheit
     * @return la conversion en degre Celsius
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
