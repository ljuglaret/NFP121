package question3;

import question1.PolygoneRegulier;
/**
 * Classe UneUtilisation
 */
public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        // déclarer p1
        PileI p1 = new Pile2(7);
        // déclarer p2
        PileI p2 = new Pile2(7);
        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));
        PileI p3= new Pile2(12);
        p3.empiler(new PolygoneRegulier(5, 200));
        p3.empiler(new PolygoneRegulier(8, 150));
        p3.empiler(new PolygoneRegulier(9, 150));
        p3.empiler(new PolygoneRegulier(10, 150));
        p3.empiler(new PolygoneRegulier(11, 150));
        p3.empiler(new PolygoneRegulier(12, 150));
        p3.empiler(new PolygoneRegulier(13, 150));
        p3.empiler(new PolygoneRegulier(14, 150));
        p3.empiler(new PolygoneRegulier(15, 150));

        p3.depiler();
        p3.depiler();
        p3.depiler();
        p3.depiler();
        p3.depiler();
        p3.depiler();

        PileI p4= new Pile2(7);
        p4.empiler(new PolygoneRegulier(7, 150));

        System.out.println(" la pile p1 = " + p1);
        // p2 ne contient que des piles de polygones réguliers
        p2.empiler(p1);
        p2.empiler(p3);
        System.out.println(" la pile p2 = " + p2);

        try {
            p1.empiler(new PolygoneRegulier(5,10)); // vérifiez qu'une erreur est levée à la compilation
            //String s = (String)p1.depiler();
        } catch(Exception e ) {
            System.out.println("erreur");
            e.printStackTrace();
        }
    }

}