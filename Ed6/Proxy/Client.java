package Proxy;

public class Client{
    public static void main(String[] args){
        ServiceI logon = new ServiceProxy();

        System.out.println(logon.requete("root","java"));//false
        System.out.println(logon.requete("root","scala"));//false
        System.out.println(logon.requete("Marie","scala"));//true
        System.out.println(logon.requete("root","scala"));//false
        System.out.println(logon.requete("Elsa","scala"));//true
    }
}