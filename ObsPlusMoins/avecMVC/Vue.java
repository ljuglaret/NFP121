package avecMVC;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * La vue est un observateur, elle connait et observe le modele
*/

public class Vue extends JPanel implements IObservateur  {
    private JButton plus = new JButton("+"); 
    private JButton moins = new JButton("-");
  
    public JLabel etatVal;
    public Modele modele;
    public Vue( Modele modele ) {
        super();
        this.modele = modele;
        modele.ajoutObservateur(this);

        etatVal = new JLabel(String.valueOf(modele.getValeur( )));
        add(etatVal);

        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(plus);
        boutons.add(plus);
        boutons.add(moins);
        add(boutons);
        

    }
        
    public void moinsAddActionListener(ActionListener e){
        this.moins.addActionListener(e);    
    }
   
    public void plusAddActionListener(ActionListener e){
        this.plus.addActionListener(e);    
    }
    
    public void actualiser(IObservable o , Object obj){
        modele.notifierObservateurs( );
        etatVal.setText(String.valueOf(obj)); 
    };
} 