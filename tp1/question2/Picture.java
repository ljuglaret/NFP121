package question2;

import question1.Circle;
import question1.Square;
import question1.Triangle;

/**
 * This class represents a simple picture. You can draw the picture using the
 * draw method. But wait, there's more: being an electronic picture, it can be
 * changed. You can set it to black-and-white display and back to colors (only
 * after it's been drawn, of course).
 * 
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.1 (24 May 2001)
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle sun2;


    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw() {
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();

        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(20);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("blue");
        sun.moveHorizontal(180);
        sun.moveVertical(-10);
        sun.changeSize(60);
        sun.makeVisible();
        
        //Ajouter une nouvelle donnée d'instance : un nouveau soleil (jaune...),
        sun2 = new Circle();
        sun2.changeColor("yellow");
        sun2.moveHorizontal(0);
        sun2.moveVertical(-10);
        sun2.changeSize(60);
        sun2.makeVisible();
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
    /*
    Ajouter une nouvelle méthode à la classe Picture permettant au soleil ( bleu)
    de se coucher (si la terre est fixe...), voir la méthode slowMoveVertical de la classe "Circle"   
    */
    private void coucherDeSoleilQuandToutVaBien(){
        //copie du soleil bleu d'origine (sun)
        Circle  sunset = new Circle();
        sunset.changeColor("blue");
        sunset.moveHorizontal(180);
        sunset.moveVertical(-10);
        sunset.changeSize(60);
        //rend le soleil d'origine invisible
        sun.makeInvisible();
        // fait apparaitre puis descendre la copie du soleil 
        sunset.makeVisible();
        sunset.slowMoveVertical(200); 
        // rend la copie invisible
        sunset.makeInvisible();            
    }
    
    public void coucherDeSoleil () {
        try{
           coucherDeSoleilQuandToutVaBien();
        }
        catch(NullPointerException ex){
            System.out.println("il faut d'abord dessiner l'image avec la méthode draw()");
            draw();
            coucherDeSoleilQuandToutVaBien();
        }
                
    }

}
