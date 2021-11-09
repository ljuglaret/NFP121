package avecMVC;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Le controleur connait la vue et le modele
 */
public class Controleur 
{
    private Vue vue;

    public Controleur( Vue vue){
        this.vue = vue;

        vue.moinsAddActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    vue.modele = new Modele(new Modele((vue.modele).getValeur()).sub());
                    vue.actualiser(vue.modele);
                }});
        vue.plusAddActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    vue.modele = new Modele(new Modele((vue.modele).getValeur()).add());
                    vue.actualiser(vue.modele);
                }});
    }
}