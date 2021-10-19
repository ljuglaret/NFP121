package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        // déclarer p1
        PileI p1 = new Pile2(6);
        // déclarer p2
        PileI p2 = new Pile2(6);
        // p1 est ici une pile de polygones réguliers PolygoneRegulier.java
        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        // p2 ne contient que des piles de polygones réguliers
        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
          p1.empiler(new PolygoneRegulier(5,10)); // vérifiez qu'une erreur est levée à la compilation
          String s = (String)p1.depiler();
        } catch(Exception e ) {
            System.out.println("erreur");
              e.printStackTrace();
        }
    }

}