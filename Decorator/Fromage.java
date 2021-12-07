

public class Fromage extends PizzaDecorator
{
    public Fromage(PizzaAbstraite p){
        super(p);
    }
    
    public String description(){
        return super.description()+ "-fromage";
    }

    public double cout(){
        return super.cout()+0.75;
    }
}
