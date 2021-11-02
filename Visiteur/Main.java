
public class Main
{
    public static void main(String[] args){
        //(4*(8 - 2)) + 5 
        Expr e1 = new Plus(new Prod(new Constante(4) , new Moins(new Constante(8) , new Constante(2)))  ,new Constante(5));
        Visiteur<Integer> v1 = new Visiteur<Integer>(){
            public Integer  visitConstante(Constante constante){
                return constante.getValeur();
            }
            public Integer visitProd(Prod prod){
                Integer evalExpr1 =  prod.getExpr1().accept(this);
                Integer evalExpr2 =  prod.getExpr2().accept(this);
                return evalExpr1 * evalExpr2;
            }
            public Integer visitMoins(Moins moins){
                Integer evalExpr1 =  moins.getExpr1().accept(this);
                Integer evalExpr2 =  moins.getExpr2().accept(this);
                return evalExpr1 - evalExpr2;
            }
            public Integer visitPlus(Plus plus){
                Integer evalExpr1 =  plus.getExpr1().accept(this);
                Integer evalExpr2 =  plus.getExpr2().accept(this);
                return evalExpr1 + evalExpr2;
            }
        }; 
       System.out.println(e1.accept(v1));
    }
}

