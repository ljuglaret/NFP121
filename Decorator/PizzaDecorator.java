public abstract class PizzaDecorator implements PizzaAbstraite
{
    protected PizzaAbstraite pizza;
    public PizzaDecorator(PizzaAbstraite pizza){
    this.pizza = pizza;
}

public String description(){
    return pizza.description();
}
public  double cout(){
    return pizza.cout();
}

}