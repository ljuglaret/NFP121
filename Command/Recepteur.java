import java.util.Stack;

/**
 * Décrivez votre classe Recepteur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Recepteur
{
    private StringBuilder contenu;
    private String donneesEnMemoire;
    private String nom;
    
    public Recepteur(String nom , String init) {
        this.nom  = nom;
        contenu = new StringBuilder(init);
     }
 
    public void ajout(String texte){
        contenu.append(texte);
    }
     
    public String getContenu() {
        return contenu.toString();
    }
 
    public void copier(String  donneesEnMemoire){
        this.donneesEnMemoire = donneesEnMemoire;
    }
     
    public void couper(int debut, int fin){
        this.donneesEnMemoire = contenu.substring(debut , fin);
        contenu = contenu.delete(debut , fin);
    }
     
    public void coller(){
        contenu.append(donneesEnMemoire);
    }
     
    public void setContent(String content) {
        this.contenu = new StringBuilder(content);
    }
    
    public String getNom(){
        return nom;
    }
}
