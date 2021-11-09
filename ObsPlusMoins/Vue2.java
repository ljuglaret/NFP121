
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

public class Vue2 extends JPanel  {
    private JButton plus = new JButton("+"); 
    private JButton moins = new JButton("-");
    private  Plus  plusOpe = new Plus();
    private Moins moinsOpe = new Moins();
    private JLabel etatVal;
    private ValeurAObserver val;
    public Vue2( ) {
        //super();
         val = new ValeurAObserver(4);

        etatVal = new JLabel(String.valueOf(val.getValeur( )));
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());

        boutons.add(plus);
        val.ajoutObservateur(plusOpe);
        val.ajoutObservateur(moinsOpe);
        plus.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    val = new ValeurAObserver(plusOpe.actualiser(val));
                    etatVal.setText(String.valueOf(val.getValeur( )));                    

                }}

        );

        boutons.add(moins);
        moins.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    val = new ValeurAObserver(moinsOpe.actualiser(val));
                    etatVal.setText(String.valueOf(val.getValeur( )));                   

                }});
        add(etatVal);
        add(boutons);

    }

} 