package Proxy;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClientTest
{
   ServiceI logon = new ServiceProxy();
    public ClientTest()
    {
    }

  
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
             
  
    }



    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    
    public String testNotOk(String utilisateur , String url){
        return "don't send " + url +" to " + utilisateur;
    }
    
    public String testOk(String utilisateur , String url){
            return "send " + url +" to " + utilisateur;
    }           

    
    @Test
    public void test(){
        assertEquals(logon.requete("Marie","scala") , testOk("Marie","scala"));
        assertEquals(logon.requete("Elsa","scala") , testOk("Elsa","scala"));

        assertEquals(logon.requete("Eli","scala") , testNotOk("Eli","scala"));
    }
}
