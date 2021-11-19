package Proxy;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClientTest
{
   ServiceI logon;
    public ClientTest()
    {
    }

  
    @BeforeEach
    public void setUp(){ // throws java.lang.Exception
        logon = new ServiceProxy();
  
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
    public void testSend(){
        assertEquals(logon.requete("Marie","url1") , testOk("Marie","url1"));
        assertEquals(logon.requete("Elsa","url2") , testOk("Elsa","url2"));
    }
    
    @Test
    public void testDontSend(){
        assertEquals(logon.requete("Eli","url1") , testNotOk("Eli","url1"));
    }
}
