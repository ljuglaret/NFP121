

public class Olive extends PizzaDecorator{
    
    public Olive(PizzaAbstraite p){
        super(p);
    }
    
    public String description(){
        return super.description() + "-olive";
    }

    public double cout(){
        return super.cout()+1.25;
    }
}