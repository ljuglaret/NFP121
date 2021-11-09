import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;


public class IHM extends JFrame {
    public IHM() {
        super("IHM Plus Moins");
        Vue2 vue = new Vue2();

        setLayout(new GridLayout(2, 1));
        add(vue);
        
        pack();
        setLocation(200,200);
        setVisible(true);
        
        

    }

    public static void main(String[] args){
        new IHM();
    }
}
