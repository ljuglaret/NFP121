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
    /** La sortie en degr� Celsius. */
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
     * m�thode d�clench�e lorsque le bouton de conversion est appuy�. 
     * remarquer que le champs de droite (les degr�s Celsius) n'est pas �ditable.
     * @param ae l'�v�nement transmis
     */
    @SuppressWarnings("static-access")
    public void actionPerformed( ActionEvent ae ){
        FahrenheitCelsius f = new FahrenheitCelsius();
        try{
            int fahrenheit = Integer.parseInt(entree.getText()); // valeur est une String et doit �tre convertie en entier, voir java.lang.Integer m�thode parseInt (--> try/catch)
            float celsius = f.fahrenheitEnCelsius(fahrenheit) ; // � compl�ter, en appelant la m�thode ad'hoc de la question2 
            float zeroAbsC = (float)-273.15;// cast double vers float pour �viter l'erreur "perte de pr�cision"
            float zeroAbsF = (float)(-459.67);
            // un test ici pour le z�ro absolu (-273.1)
            // 0 absolu ===  -273.15�C === -459.67�F
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
