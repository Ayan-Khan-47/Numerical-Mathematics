import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;

public class RungaKutta4
{
    static double calculate(double X0, double Y0, double X, double h)
    {
        int n = (int)((X-X0) / h);
 
        double K1,K2,K3,K4;
 
        double Y=Y0;
        for (int i = 1; X0<=(X-h/2); i++)
        {
            K1 = h * (SOLVE("y^(1/3)*x",X0, Y));
            System.out.println(K1);
            K2 = h * (SOLVE("y^(1/3)*x",(X0 + 0.5 * h), (Y + 0.5 * K1)));
            System.out.println(K2);
            K3 = h * (SOLVE("y^(1/3)*x",(X0 + 0.5 * h), (Y + 0.5 * K2)));
            System.out.println(K3);
            K4 = h * (SOLVE("(y)^(1/3)*x",(X0 + h), (Y + K3)));
            System.out.println(K4);
 
            Y = Y + (1.0 / 6.0) * (K1 + 2 * K2 + 2 * K3 + K4);
             
            X0 = X0 + h;
            System.out.println(X0);
        }
        return Y;
    }
     static Double SOLVE(String ex, Double set, Double set2) {
        DoubleEvaluator eval = new DoubleEvaluator();
        StaticVariableSet<Double> variables = new StaticVariableSet<>();
        variables.set("x", set);
        variables.set("y", set2);
        return eval.evaluate(ex, variables);
    }
    public static void main(String args[])
    {
        double X0 = 1, Y0 = 1, X =1.2, h=0.1;
         
        System.out.println(calculate(X0,Y0,X,h));
    }
}
