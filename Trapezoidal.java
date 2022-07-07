public class Trapezoidal
{
    
    static double trapezoidal(double a, double b, double n)
    {
        double h = (b - a) / n;
     

        double y = Solution.SOLVE("1/(1+x^2)",a) + Solution.SOLVE("1/(1+x^2)",b);
     
        for (int i = 1; i < n; i++)
            y += 2 * Solution.SOLVE("1/(1+x^2)", (a + i * h));
     
        return (h / 2) * y;
    }
     
    public static void main (String[] args)
    {
        float x0 = 0;
        float xn = 6;
        int n = 6;
     
        System.out.println("Value of integral is "+
                           Math.round(trapezoidal(x0, xn, n)
                           * 10000.0) / 10000.0);
    }
}
