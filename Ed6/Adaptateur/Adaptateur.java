package Adaptateur;

public class Adaptateur implements FileEntiersI
{
    public CollectionI adaptee;

    public Adaptateur(CollectionI adaptee){
        this.adaptee = adaptee;
    }

    public void enfiler(int i) throws FilePleineException{
      
        try{
            adaptee.put(i);
        }
        catch(FullException e){
         throw new FilePleineException("file pleine");}

    }
    
    public int defiler() throws FileVideException{
        try{
            return adaptee.get();
        }
        catch(EmptyException e){
        }
        throw new FileVideException("file vide");
    }
    
    public int taille(){return adaptee.size();}
    
    public int capacite(){return adaptee.capacity();}
    
    public boolean estVide(){return adaptee.empty();}
    
    public boolean estPleine(){return adaptee.full();}
}
