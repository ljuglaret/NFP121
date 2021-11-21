package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 * Classe JPanelListe
 */
public class JPanelListe extends JPanel implements ActionListener, ItemListener {

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("d�croissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private TextArea texte = new TextArea();

    private List<String> liste;
    
    //occurrence : obtention du nombre d'occurrences du mot pr�sent dans la zone de saisie
    private Map<String, Integer> occurrences;

    public JPanelListe(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incompl�te");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);

        boutonRetirer.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);
        boutonOccurrences.addActionListener(this);


    }

    /** ne pas modifier les affichages, les classes de tests en ont besoin ... */
    public void actionPerformed(ActionEvent ae) {
        try {
            //rechercher : recherche du mot tap� dans la zone de saisie; 
            //le bool�en, le r�sultat de la recherche est affich�. la touche Entr�e du clavier a le m�me effet qu'une action effectu�e sur ce bouton.
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                boolean contains = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("r�sultat de la recherche de : "+ saisie.getText() + " -->  " + contains);
            }
            else if (ae.getSource() == boutonRetirer) {
                boolean res = retirerDeLaListeTousLesElementsCommencantPar(saisie.getText());
                afficheur.setText("r�sultat du retrait de tous les �l�ments commen�ant par -->  "+ saisie.getText() + " : " + res);
            }
            else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            }
            texte.setText(liste.toString());

        } catch (Exception e) {
            afficheur.setText(e.toString());
        }
    }

    /**
     * Trie la liste de String par ordre croissant ou d�croissant
     */
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == ordreCroissant)
            // tri "classique" de liste avec Collections.sort
            Collections.sort(this.liste);
        else if (ie.getSource() == ordreDecroissant)
            // tri d�croissant de liste avec l'interface Comparator
            this.liste.sort(new Comparator<String>() {
                @Override
                public int compare(String str1,String str2) {
                   return str2.compareTo(str1);
            }});
        
        // liste a �t� tri� selon le crit�re demand� par ie
        // on transf�re le contenu de liste dans texte
        texte.setText(liste.toString());
    }

    /**
     * retire de la liste tous les �l�ments commencant par pr�fixe. Retourne vrai si il a retir� au moins un �l�ment, faux sinon.
     * @param String prefixe
     * @return boolean
     */
    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean res = false;
        Iterator<String> iter = this.liste.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            if (s.startsWith(prefixe)) {
                iter.remove();
                res = true; 
                //La paire (clef, valeur) est (s , 0 ) pour indiquer que
                // s n'a plus aucune occurences 
                this.occurrences.put(s, 0);
            }
        }
        return res;
    }
}