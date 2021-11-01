package question1;
/**
 * Classe UneUtilisation 
 */
public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        Pile0 p1 = new Pile0(6);
        Pile0 p2 = new Pile0(10);
        //p1 est ici une pile de polygones réguliers PolygoneRegulier.java

        p1.empiler(new PolygoneRegulier(5, 100));
        p1.empiler("polygone");
        p1.empiler(new Integer(100));
        System.out.println(" la pile p1 = " + p1); // Quel est le résultat ?

        p2.empiler(new Integer(1000));
        p1.empiler(p2);
        System.out.println(" la p1 = " + p1); // Quel est le résultat ?

        try {
            p1.empiler(new PolygoneRegulier(4,100)); // Le sommet est de type PolygoneRégulier
            p1.empiler(new Integer(45)); // Le sommet est de type Integer
            // ....
            String s = (String) p1.depiler(); // vérifiez qu'une exception se
                                                // produit
        p1.depiler();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } // main()
} // UneUtilisation
