public class Euler {
   static double differential(double x, double y)
    {
        return x+y;
    }
    static void calculate(double X0, double Y0, double h, double X)
    {
int i=0;
        for( i=0;X0<=(X-h/2);i++) {
            System.out.println("x"+i+" = "+X0);
            System.out.println("y"+i+" = "+Y0);
            
            Y0 = Y0 + h * differential(X0, Y0);
            X0 = X0 + h;
        }
 System.out.println("x"+i+" = "+X0);
            System.out.println("y"+i+" = "+Y0);
        System.out.println("Approximate solution at x = "
                           + X + " is " + Y0);
    }
 
    public static void main(String args[])
    {
        double X0 = 0;
        double Y0 = 1;
        double h=0.1;
 
        double X = 1;
 
        calculate(X0, Y0, h, X);
    }
}
