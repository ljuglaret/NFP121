public class Adapteur implements Cible {
    public Adaptee adaptee;
    
    public Adapteur(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    
    public void priseUnionEuropeenne(){
        System.out.println("Appel de la méthode : adaptee.priseEtatsUnis");
        adaptee.priseEtatsUnis();
    }
}