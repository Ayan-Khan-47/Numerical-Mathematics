public class Simpsonthreebyeight {
     
    static double simp(double lower,
                           double upper, int n )
    {
        double ans;
        double size = (upper - lower)/ n;
 
        double sum = Solution.SOLVE("1/(1+x^2)",lower) + Solution.SOLVE("1/(1+x^2)",upper);
      
        for (int i = 1 ; i < n ; i++)
        {
            if (i % 3 == 0)
                sum = sum + 2 * Solution.SOLVE("1/(1+x^2)",(lower+ i * size));
            else
                sum = sum + 3 * Solution.SOLVE("1/(1+x^2)",(lower + i*size));
        }
        return ( 3 * size / 8 ) * sum ;
    }
     
    public static void main(String[] args)
    {
        int n = 6;
        double lower = 0;
        double upper = 6;
        double integral = simp(lower, upper,
                                       n);
      
        System.out.println(integral);
        }
    }
