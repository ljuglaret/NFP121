

public class Champignons extends PizzaDecorator
{
    public Champignons(PizzaAbstraite p){
        super(p);
    }
    
    public String description(){
        return super.description()+ "-champignons";
    }

    public double cout(){
        return super.cout()+0.5;
    }
}
