package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// pour le comportement attendu depuis votre répertoire
// exécuter cette commande tp3>appletviewer tp3.html
public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel("[]");

    private Pile p;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    /*
     * Empiler
     *      Si la pile est pleine  : erreur "pile pleine"
     *      Sinon  --------
     * Depiler 
     *      Si la pile est vide  : erreur "pile vide"
     *      Sinon  --------
     * 
     */
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler")){
            try {
                p.empiler(Integer.parseInt(donnee.getText()));
                sommet.setText(donnee.getText());
                contenu.setText(p.toString());
                donnee.setText("");
            }
            catch(NumberFormatException e){
                contenu.setText("saisir un entier");
            }
            catch(PilePleineException e2){
                 contenu.setText( "la pile est Pleine !");
            }
        }
         
        if (ae.getActionCommand().equals("depiler")){
            try {
                p.depiler();
                contenu.setText(p.toString());
            }
            catch(PileVideException e){
                 contenu.setText( "la pile est Vide !");
            }
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
