package Proxy;
import java.util.List;


public class VraiService implements ServiceI {
    
    protected  List<String> agrees;
    
  public String requete(String utilisateur, String url){
     
          return "send " + url +" to " + utilisateur;
    
    
    }

}