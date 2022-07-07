public class Lagrange
{
 
        
static double lagrange_interpolation(double[] X,double[] Y, int point, int n)
{
    double ans = 0;
    for (int i = 0; i < n; i++)
    {
        double term=1;
        for (int j = 0; j < n; j++)
        {
            if (j != i){
                term = term*((point - X[j]) / (X[i] - X[j]));
            System.out.println(X[j]+"\n"+X[i]+"\n"+term);}
        }
 
        System.out.println(Y[i]);
        ans += term*Y[i];
    }
 
    return ans;
}
 
public static void main(String[] args)
{
 int n=4;
double X[] = {0,1,2,5};

        double Y[] = {2,3,12,147};
    System.out.print("Value of f(3) is : " +
                    (int)lagrange_interpolation(X,Y,3,n));
}
}
