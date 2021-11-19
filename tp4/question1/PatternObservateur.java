package question1;
public class PatternObservateur extends junit.framework.TestCase {
    /**
     * Teste la notification.
     */
    public void testNotify() {
        /**Sujet concret (observable): list.*/
        ConcreteSubject list;
        /**Obervateur concret (observateur): observer.*/
        ConcreteObserver observer;

        list = new ConcreteSubject();           // création d'un "observé" constitué d'une liste
        observer = new ConcreteObserver();      // création d'un observateur
        list.addObserver(observer);             // ajouter cet observateur à la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) être notifié

        // "vérification" :
        assertFalse(observer.senders().empty());                            
        assertEquals(list, observer.senders().pop());                       
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); 
    }

    /**
     * Teste la notification d'une liste avec 2 observateurs.
     */
    public void test1() {
        /**On crée la liste observable.*/
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        /**on ajoute 2 observateurs : o1.*/
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        /**o2.*/
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        
        // vérifier que les deux observateurs ont bien été notifiés avec les
        // bons paramètres

        assertFalse(o1.senders().empty());
        assertFalse(o2.senders().empty()); 
        assertEquals(l1, o1.senders().pop()); 
        assertEquals(l1, o1.senders().pop()); 
        assertEquals(l1, o2.senders().pop());
        assertEquals(l1, o2.senders().pop()); 
        assertEquals(" 1 ", o1.arguments().pop());
        assertEquals(" 1 ", o2.arguments().pop());
        assertEquals("test", o1.arguments().pop());
        assertEquals("test", o2.arguments().pop());
        
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    
    /**
     * 2 listes, 1 observateur.
     */
    public void test2() {
        /**liste 1 .*/
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        /**liste 2.*/
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        
        /**observateur o.*/
        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");


        // vérifier que l'observateur a bien été notifié par les deux listes
    
        assertEquals(l2, o.senders().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(" B ", o.arguments().pop()); 
        assertEquals("testB", o.arguments().pop()); 
        assertEquals(" A ", o.arguments().pop());
        assertEquals("testA", o.arguments().pop());

        assertTrue(o.senders().empty() && o.arguments().empty());

    }

    /**
     * 2 listes, 2 observateurs.
     * Teste countObserver(), deleteObservers() et
     * deleteOserver(observer o)
     */
      
    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);
        
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());

        // vérifier le bon fonctionnement de countObservers(), de deleteObserver

        assertTrue(l1.countObservers() == 2);
        assertTrue(l2.countObservers() == 2);
        
        l1.deleteObserver(o1);
        // l1 n'a plus qu'un observeur : o2
        
        assertTrue(l1.countObservers() == 1);
        
        l1.deleteObserver(o2);
        // l1 n'a plus aucun observeur
                
        l2.deleteObservers();
        // l2 n'a plus aucun observeur

        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
        public void test2Bis() {
        /**liste 1 .*/
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        /**liste 2.*/
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        
        /**observateur o.*/
        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l2.insert("L2.0");
        l1.insert("L1.0");
        l1.insert("L1.1");
        l2.insert("L2.2");

        assertEquals(l2, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals("L2.2", o.arguments().pop()); 
        assertEquals("L1.1", o.arguments().pop()); 
        assertEquals("L1.0", o.arguments().pop());
        assertEquals("L2.0", o.arguments().pop());

        assertTrue(o.senders().empty() && o.arguments().empty());

    }
    
    }
    