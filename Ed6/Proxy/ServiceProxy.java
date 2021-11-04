package question3;
import java.util.List;


public class ServiceProxy implements ServiceI{
     UtilisateursNFP121 users = new UtilisateursNFP121();
    protected  List<String> agrees = users.agrees();
    private ServiceI real = new VraiService();
  public String requete(String utilisateur, String url){
      if (agrees.contains(utilisateur)){
          return real.requete(utilisateur, url);
        }
        else{
            return "don't send " + url +" to " + utilisateur;
        }
    
    }

}