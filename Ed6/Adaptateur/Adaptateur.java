package Adaptateur;

/**
 * Décrivez votre classe FileEntier ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Adaptateur implements FileEntiersI
{
    public Buffer adaptee;

    public Adaptateur(Buffer adaptee){
        this.adaptee = adaptee;
    }

    public void enfiler(int i) throws FilePleineException{
        if (adaptee.full()){
            throw new FilePleineException("file pleine");
        }
        
        try{
            adaptee.put(i);
        }
        catch(BufferFullException e){}
    }
    
    public int defiler() throws FileVideException{
        if (adaptee.empty()){
            throw new FileVideException("file vide");
        }
        
        try{
            return adaptee.get();
        }
        catch(BufferEmptyException e){
        }
        return 0;
    }
    
    public int taille(){return adaptee.size();}
    
    public int capacite(){return adaptee.capacity();}
    
    public boolean estVide(){return adaptee.empty();}
    
    public boolean estPleine(){return adaptee.full();}
}
