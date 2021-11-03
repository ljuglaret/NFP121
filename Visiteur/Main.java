
public class Main
{
    public static void main(String[] args){
        
        Expr un     =   new Constante(1);
        Expr cinq   =   new Constante(5);
        Expr quatre =   new Constante(4);
        
        //(4*(2^3 - 1)) + 5 
        Expr e1 = new Plus(new Prod(quatre,new Moins(new Puissance(new Constante(2),new Constante(3)),un)),cinq);
        
        Visiteur<Double> v1 = new Visiteur<Double>(){
            public Double  visitConstante(Constante constante){
                return constante.getValeur();
            }
            public Double visitProd(Prod prod){
                Double evalExpr1 =  prod.getExpr1().accept(this);
                Double evalExpr2 =  prod.getExpr2().accept(this);
                return evalExpr1 * evalExpr2;
            }
            public Double visitMoins(Moins moins){
                Double evalExpr1 =  moins.getExpr1().accept(this);
                Double evalExpr2 =  moins.getExpr2().accept(this);
                return evalExpr1 - evalExpr2;
            }
            public Double visitPlus(Plus plus){
                Double evalExpr1 =  plus.getExpr1().accept(this);
                Double evalExpr2 =  plus.getExpr2().accept(this);
                return evalExpr1 + evalExpr2;
            }
            public Double visitPuissance(Puissance puissance){
                Double evalExpr1 =  puissance.getExpr1().accept(this);
                Double evalExpr2 =  puissance.getExpr2().accept(this);
                return Math.pow(evalExpr1 , evalExpr2);
            }
        }; 
       System.out.println(e1.accept(v1));
    }
}

