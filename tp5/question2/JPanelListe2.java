package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
// Je ne comprends pas 
//There were 2 failures:
//1) test_IHMListe2_retirer_annuler(question2): retrait est-il inopérant ???
//2) test_IHMListe2_retirer_annulerBis(question2): retrait est-il inopérant ??? 
//
/**
 * Classe JPaneListe2
 */
public class JPanelListe2 extends JPanel implements ActionListener, ItemListener {

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("décroissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private JButton boutonAnnuler = new JButton("annuler");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    private Caretaker caretaker;
    private  Originator originator;

    public JPanelListe2(List<String> liste, Map<String, Integer> occurrences) {
        this.liste = liste;
        this.occurrences = occurrences;

        caretaker = new Caretaker();
        originator = new Originator();

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
        panelBoutons.add(boutonAnnuler);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null){
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }
        else{
            texte.setText("la classe Chapitre2CoreJava semble incomplète");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        // à compléter;
        boutonAnnuler.addActionListener(this);
        boutonRetirer.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);
        boutonOccurrences.addActionListener(this);

    }

    //Nouveauté par rapport à JPanel
    //1Liste1 : On peut sauvergarder le dernier état de la liste
    //On ne peut retirer un élément que si il est présent, d'où la condition : retirerDeLaListeTousLesElementsCommencantPar(saisie.getText())

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie) {
                boolean contains = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("résultat de la recherche de : "+ saisie.getText() + " -->  " + contains);
            }
            else if (ae.getSource() == boutonRetirer) {
                boolean res = retirerDeLaListeTousLesElementsCommencantPar(saisie.getText());
                afficheur.setText("résultat du retrait de tous les éléments commençant par -->  "+ saisie.getText() + " : " + res);
            }
            else if (ae.getSource() == boutonOccurrences) {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ???");
            }

            //Nouveauté par rapport à JPanel1Liste1 :
            //On peut restaurer le dernier état de la liste

            else if(ae.getSource() == boutonAnnuler){
                try{
                    if(!caretaker.estVide()){
                        liste = originator.restoreFromMemento(caretaker.getMemento());
                        occurrences = Chapitre2CoreJava2.occurrencesDesMots(this.liste); 
                    }
                    //Quand la pile est vide le bouton 'annuler' est sans effet
                } catch (Exception e){}
            }
            texte.setText(liste.toString());

        } catch (Exception e) {
            afficheur.setText(e.toString());
        }
    }

    /**
     * Trie la liste de String par ordre croissant ou décroissant
     */
    public void itemStateChanged(ItemEvent ie) {
        List<String> listeBis = new ArrayList<String>(this.liste);

        if (ie.getSource() == ordreCroissant){
            sauvegarder( listeBis);
            Collections.sort(this.liste);
        }
        else if (ie.getSource() == ordreDecroissant){
            sauvegarder( listeBis);
            this.liste.sort(new Comparator<String>() {
                    @Override
                    public int compare(String str1,String str2) {
                        return str2.compareTo(str1);
                    }});

        }
        texte.setText(liste.toString());
    }

    //La paire (clef, valeur) est (s , 0 ) pour indiquer que
    // s n'a plus aucune occurences 

    private static boolean commencantPar (List<String> l , String pre){
        boolean contient = false;
        for (String mot : l){
            if (mot.startsWith(pre)){
                contient = true; 
                break;
            }
        }
        return contient;
    }

    /**
     * retire de la liste tous les éléments commencant par préfixe. Retourne vrai si il a retiré au moins un élément, faux sinon.
     * @param String prefixe
     * @return boolean
     */
    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean res = false;
        Iterator<String> iter = this.liste.iterator();
        List<String> listeClone = new ArrayList<String>(this.liste);
        if (commencantPar( this.liste , saisie.getText())){
            sauvegarder(listeClone);
            res = true;
            System.out.println("retirer tous les mots commencant par "+saisie.getText() + "res : " + res);
            while(iter.hasNext()) {
                String s = iter.next();
                if (s.startsWith(prefixe)) {
                    iter.remove();
                    // mise à jour de la map des occurences
                    this.occurrences.put(s, 0);
                }
            }
        }

        return res;
    }

    private void sauvegarder(List<String> listeBis){
        listeBis = new ArrayList<>(this.liste);

        originator.set(listeBis);
        // la liste etats de originator est  remplacée par listeBis

        caretaker.addMemento(originator.storeInMemento());
        //sauvegarde placée au sommet des états sauvegardés
    } 

}