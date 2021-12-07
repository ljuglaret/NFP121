package question1;


public class TestsACompleter extends junit.framework.TestCase{
    private Memoire m;
    private Variable i,j,k,l;
    private VisiteurExpression<Integer> ve;
    private VisiteurExpression<String>  vp,vi;
    
    
    public void setUp(){
      m  = new Memoire();
      i  = new Variable(m,"i",3);
      j = new Variable(m,"j",5);
        k  = new Variable(m,"k",30);
      l = new Variable(m,"l",50);
      ve = new VisiteurEvaluation( m);
      vi = new VisiteurInfixe( m);
      vp = new VisiteurPostfixe( m);
      assertNotNull(i);assertNotNull(j);
      assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
    }
    
    
    public void testUneAddition(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
    }
    
    public void testMultiplication(){
       Expression expr = new Multiplication(new Constante(3), j);
        assertEquals("",15,expr.accepter(ve).intValue());
    }

    public void testSoustraction(){
      Expression expr = new Soustraction(new Constante(3), j);
        assertEquals("",-2,expr.accepter(ve).intValue());
    }
    
    
    public void testSoustraction2(){
      Expression expr = new Soustraction(k,l);
        assertEquals("",-20,expr.accepter(ve).intValue());
    }
    
    
    public void testSoustraction3(){
      Expression expr = new Soustraction( j , i);
        assertEquals("",2,expr.accepter(ve).intValue());
    }
    
    public void testDivision(){
      Expression expr = new Division(new Constante(15), new Constante(5));
        assertEquals("",3,expr.accepter(ve).intValue());
      
      try{
        new Division(i,new Constante(0)).accepter(ve);
        fail("division par zéro ? possible ");
       }catch(ArithmeticException ae){
       }
     }
     
     public void testVisiteurInfixe(){
        Expression expr = new Addition(new Constante(1),new Multiplication(new Constante(3), new Constante(2)));
        assertEquals("(1 + (3 * 2))", expr.accepter(vi));
     }
     
     // (3,2)*
     //(1,____)+
     //(1,(3,2)*)+
    
     public void testVisiteurPostfixe(){
        Expression expr = new Addition(new Constante(1),new Multiplication(new Constante(3), new Constante(2)));
        assertEquals("(1,(3,2)*)+", expr.accepter(vp));
     }
     
     
         // à compléter
      // à compléter
      // à compléter

}
