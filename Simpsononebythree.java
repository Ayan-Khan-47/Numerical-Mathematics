public class Simpsononebythree{
 
 
    static double simp(double lower, double upper,
                                       int n)
    {
        double h = (upper - lower) / n;
 
        double[] X = new double[n+1];
        double[] f= new double[n+1];
 
        for (int i = 0; i <= n; i++) {
            X[i] = lower + i * h;
            f[i] = Solution.SOLVE("sin(x)-ln(x)",X[i]);
        }
 
        double res = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == n)
                res += f[i];
            else if (i % 2 != 0)
                res += 4 * f[i];
            else
                res += 2 * f[i];
        }
         
        res = res * (h / 3);
        return res;
    }
    public static void main(String s[])
    {  
        double lower = 0.2;
         
        double upper = 1.4;
         
        int n = 6;
         
        System.out.println(simp(lower,
                                upper, n));
    }
}
