package question1;

public class main {
	private static Square wall;
	private static  Square window;
	private static  Triangle roof;
	private static   Circle sun;
	private static   Circle sun2;


	public static void main(String[] args) {

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


}
