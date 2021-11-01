package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Classe Controleur
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        
        boutons.add(push);
        push.addActionListener(
            new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.push();
                    }});
        boutons.add(add);
        add.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.add();
                    }});
        boutons.add(sub);
        sub.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.sub();
                    }});
        boutons.add(mul);
        mul.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.mul();
                    }});
        boutons.add(div);
        div.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.div();
                    }});
        boutons.add(clear);
        clear.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                       Controleur.this.clear();
                    }});
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        /**
         *  initial (taille = 0): pile vide, on ne peut que insérer un chiffre
         *  taille = 1 : seulement 1 chiffre a été saisi, on ne peut que l'effacer ou en saisir un autre
         *  taille = capacite : la pile est pleine
         *  dans tous les autres cas la pile a au moins deux éléments et n'est pas pleine, toutes les opérations sont donc autorisées
         */
                    
            if(pile.estVide()) {
                add.setEnabled(false);
                sub.setEnabled(false);
                mul.setEnabled(false);
                div.setEnabled(false);
                clear.setEnabled(false);
                push.setEnabled(true);

            }
            else if(pile.taille() == 1){
                    add.setEnabled(false);
                    sub.setEnabled(false);
                    mul.setEnabled(false);
                    div.setEnabled(false);
                    clear.setEnabled(true);
                    push.setEnabled(true);
            }
            else if(pile.taille() == pile.capacite()){
                        add.setEnabled(false);
                        sub.setEnabled(false);
                        mul.setEnabled(false);
                        div.setEnabled(false);
                        clear.setEnabled(true);
                        push.setEnabled(false);
            }
                //(pile.taille() > 1
            else {
                      add.setEnabled(true);
                      sub.setEnabled(true);
                      mul.setEnabled(true);
                      div.setEnabled(true);
                      clear.setEnabled(true);
                      push.setEnabled(true);
            }                           
        }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }
    
    /**
    * Ajout opérande
    */
    public void push(){
      try{
            this.pile.empiler(operande());
        }
        catch(Exception e){
         System.out.println("incidence sur la pile d'évaluation ");
        }
        this.actualiserInterface();
    }
    
    /**
    * Addition 
    */
    public void add(){
      try{
            int val1 = this.pile.sommet();
            this.pile.depiler();
            int val2 = this.pile.sommet();
            this.pile.depiler();
            this.pile.empiler(val2 + val1);
        }
        catch(Exception e){
            System.out.println("probleme avec l'operateur +");
        }
        this.actualiserInterface();
    }
    
    /**
    * Soustraction
    */
    public void sub(){
         try{
            int val1 = this.pile.sommet();
            this.pile.depiler();
            int val2 = this.pile.sommet();
            this.pile.depiler();
            this.pile.empiler(val2 - val1);
        }catch(Exception e){
            System.out.println("probleme avec l'operateur -");
        }
        this.actualiserInterface();
    }
    
    /**
    * Multiplication
    */
    public void mul(){
         try{
            int val1 = this.pile.sommet();
            this.pile.depiler();
            int val2 = this.pile.sommet();
            this.pile.depiler();
            this.pile.empiler(val2 * val1);
        }catch(Exception e){
            System.out.println("probleme avec l'operateur *");
        }
        this.actualiserInterface();
    }
    
    /**
    * Divisio
    */
    public void div(){
         try{
            int val1 = this.pile.sommet();
            this.pile.depiler();
            int val2 = this.pile.sommet();
            this.pile.depiler();
            this.pile.empiler(val2 / val1);
        }
        catch(ArithmeticException e){
             System.out.println("division par 0 impossible");
        }
        catch(Exception e){
            System.out.println("probleme avec l'operateur /");
        }
        this.actualiserInterface();
    
    }
    
      public void clear(){
        for(int i = this.pile.taille(); i >=0 ; i--){
            try{
                this.pile.depiler();
            }catch(Exception e){
            }
        }
        this.actualiserInterface();
    }
}


    // à compléter
    // en cas d'exception comme division par zéro, 
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)


