/**
 * @Laure Juglaret
 * @v1.0.0
 */
package question3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import org.junit.Test;
import question2.*;

public class IHMFahrenheit extends JFrame implements ActionListener   {
    /**
     * 
     */
    private JTextField entree = new JTextField( 6 );
    /** Le bouton de conversion. */
    private JButton  boutonDeConversion = new JButton( "convertir" );
    /** La sortie en degré Celsius. */
    private JTextField sortie = new JTextField( 6 );

    public IHMFahrenheit()  {
        super("IHM Fahrenheit");

        setLayout(new FlowLayout());
        add( entree );
        add( boutonDeConversion );
        add( sortie );
        sortie.setEditable( false );
        getContentPane().setBackground( Color.pink );
        setLocation(100,100);
        pack();setVisible(true);

        boutonDeConversion.addActionListener( this );
    }

    /** 
     * méthode déclenchée lorsque le bouton de conversion est appuyé. 
     * remarquer que le champs de droite (les degrés Celsius) n'est pas éditable.
     * @param ae l'événement transmis
     */
    @SuppressWarnings("static-access")
    public void actionPerformed( ActionEvent ae ){
        FahrenheitCelsius f = new FahrenheitCelsius();
        try{
            int fahrenheit = Integer.parseInt(entree.getText()); // valeur est une String et doit être convertie en entier, voir java.lang.Integer méthode parseInt (--> try/catch)
            float celsius = f.fahrenheitEnCelsius(fahrenheit) ; // à compléter, en appelant la méthode ad'hoc de la question2 
            float zeroAbsC = (float)-273.15;// cast double vers float pour éviter l'erreur "perte de précision"
            float zeroAbsF = (float)(-459.67);
            // un test ici pour le zéro absolu (-273.1)
            // 0 absolu ===  -273.15°C === -459.67°F
             junit.framework.TestCase.assertEquals("zero absolu",f.fahrenheitEnCelsius((int)zeroAbsF),zeroAbsC,0.6);
             if (celsius < zeroAbsC){
                 celsius = zeroAbsC;
                }
            sortie.setText(Float.toString( celsius));
        }catch(NumberFormatException nfe){
            sortie.setText("error ! ");
        }
    }


    public static void main(String[] args){
        new IHMFahrenheit();
    }
}
