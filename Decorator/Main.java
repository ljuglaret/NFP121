
/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    public static void main(String[] args){
    
        PizzaDeBase pizza = new PizzaDeBase();
        //pizza double fromage et olives
        Olive plusOlive = new Olive(pizza);
        Fromage plusFrom1Fois = new Fromage(plusOlive);
        Fromage plusFromEncore1Fois = new Fromage(plusFrom1Fois);
        System.out.println(plusFromEncore1Fois.cout());
    }
}
