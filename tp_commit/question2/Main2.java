package question2;

import question1.*;
import org.jdom.*;
import org.jdom.output.*;
import java.io.ByteArrayOutputStream;

public class Main2 {
// 1) testSurUnGroupeDeGroupeAvecDoublons(question2): Ce composite est valide, revoyez CompositeValide !!! 
    public static void main(String[] args) throws Exception {
        try{
            String sg1 = "g1";
            
        GroupeDeContributeurs g0 = new GroupeDeContributeurs("g0");
        GroupeDeContributeurs g1 = new GroupeDeContributeurs(sg1);
        GroupeDeContributeurs g1bis = new GroupeDeContributeurs(sg1);
        System.out.println("g1 ==? g1bis :"+g1.equals(g1bis));
        g0.ajouter(g1);
        g1.ajouter(g1bis);
        g1bis.ajouter(new Contributeur("c1",100));
        System.out.println("visiteur : " +g0.accepter(new CompositeValide(0)));}
        catch(Throwable e){e.printStackTrace();}
    }
}