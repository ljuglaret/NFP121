package Adaptateur;


public class Client
{
   public Client() throws FilePleineException , FileVideException{
            Adaptateur x = new Adaptateur(new Buffer(10));
            x.enfiler(5);
            x.enfiler(2);
            x.enfiler(3);
            System.out.println("taille : " +x.taille());
            System.out.println("on retire  la valeur située en queue de la file : " + x.defiler());
            System.out.println("taille : "+ x.taille());
            System.out.println("on retire  la valeur située en queue de la file : " + x.defiler());
            System.out.println("taille : "+ x.taille());


    }
}
