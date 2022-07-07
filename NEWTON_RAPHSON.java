import static java.lang.Math.*;

public class NEWTON_RAPHSON{
    static final Double AERR=0.0001;
    static int iteration = 20, DecimalUpto = 6;
    
    static double fun(double x){
        return(x*x-10);
    }
    
    static double Derivative(double x){
        return (2*x);
    }
    
    double halfPart(double x){
        return(fun(x)/Derivative(x));
    }
    
    static double newtonRaphson(double x1){
        double x=0.0;
        int iteration=1;
        System.out.printf("\nInitial Guess: %f\n", x1);
        System.out.printf("\n x \t\t x1 \t\t f'(x) \t\t |x-x1|\n");
        do{
            System.out.printf("\n %f \t %f \t %f \t %f\n", x, x1, Derivative(x), (x-x1));
            x=x1;
            if(abs(Derivative(x))>=10e-9);
        }while(abs(x-x1)>=AERR);
        System.out.printf("Number of iterations = %d", iteration);
        return x1;
    }
    public static void main(String[] args){
        System.out.println("Root = "+newtonRaphson(5));
        System.out.println("Root = "+newtonRaphson(-5));
    }
}
