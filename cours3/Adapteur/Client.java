
public class Client {
    public Client(){
            System.out.println("Le client a une prise spéciale UE");
            new Adapteur(new Adaptee()).priseUnionEuropeenne();
    }

}