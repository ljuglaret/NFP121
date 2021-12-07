package question2;

import question1.VisiteurExpression;

public class VisiteurBoolEvaluation extends VisiteurExpressionBooleenne<Boolean> {

    private VisiteurExpression<Integer> ve;

    public VisiteurBoolEvaluation(VisiteurExpression<Integer> ve) {
        this.ve = ve;
    }

    /**
     * Visite v <br>
     * 
     * @param v
     * @return true
     */
    public Boolean visite(Vrai v) {
        return true;
    }

    /**
     * Visite f <br>
     * 
     * @param f
     * @return false
     */
    public Boolean visite(Faux f) {
        return false;
    }

    
    /**
     * Visite de n <br>
     * 
     * @param n
     * @return !n
     */
    public Boolean visite(Non n) { 
        return !n.bop().accepter(this); 
    }

    /**
     * Visite de ou(bop1,bop2) <br>
     * 
     * @param bop1,bop2
     * @return bop1||bop2
     */
    public Boolean visite(Ou ou) {
        return ou.bop1().accepter(this) || ou.bop2().accepter(this);
    }

    
    /**
     * Visite de et(bop1,bop2) <br>
     * 
     * @param bop1,bop2
     * @return bop1&&bop2
     */
    public Boolean visite(Et et) {
        return et.bop1().accepter(this) && et.bop2().accepter(this);
    }

    
    /**
     * Visite de sup(op1,op2) <br>
     * 
     * @param op1,op2
     * @return op1 > op2
     */
    public Boolean visite(Sup sup) {
        return sup.op1().accepter(ve) > sup.op2().accepter(ve);
    }

    /**
     * Visite de eg(op1,op2) <br>
     * 
     * @param op1,op2
     * @return op1 == op2
     */
    public Boolean visite(Egal eg) {
        return eg.op1().accepter(ve) == eg.op2().accepter(ve);
    }

    /**
     * Visite de inf(op1,op2) <br>
     * 
     * @param op1,op2
     * @return op1 < op2
     */
    public Boolean visite(Inf inf) {
        return inf.op1().accepter(ve) < inf.op2().accepter(ve);
    }

}
