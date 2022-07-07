import static java.lang.Math.*;

public class BISECTION {

    static final Double AERR=0.0001;
    static int iteration = 12, i = 0, DecimalUpto = 6;

    static double Bisec_func(double x) {
        return x-2;
    }

    static void bisection(double x0, double x1) {
        double x2, a, b, c;
        for(int j=0;;j++){
                x0=j;
            x1=j+1;
            a=Bisec_func(x0);
            b=Bisec_func(x1);
            if(a*b<0)
            {
                break;
            }
        }
        System.out.printf("x0 = %f/n",x0);
        System.out.printf("x1 = %f/n",x1);
        do{
           a=Solution.SOLVE("x-2",x0);
           b=Solution.SOLVE("x-2",x1);
           x2=(x0+x1)/2;
           c=Bisec_func(x2);
           if(a*c<0){
               x1=x2;
           }
           else{
               x0=x2;
           }
           i++;
           System.out.printf("Number of Iterations=%d\t",i);
           System.out.printf("Root=%f\t", Math.round(x2 * Math.pow(10, DecimalUpto))/ Math.pow(10, DecimalUpto));
           System.out.printf("Value of function=%f\n", c);
        }while(abs(c)>AERR);
        System.out.printf("Total number of iterations=%d\n", i);
        System.out.printf("Final Rooit=%f\t", Math.round(x2 * Math.pow(10, DecimalUpto))/ Math.pow(10, DecimalUpto));
           System.out.printf("Final Value of function=%f\n", c);
    }

    public static void main(String[] args) {
        double x0 = 0, x1 = 0;
        bisection(x0,x1);
    }
}
