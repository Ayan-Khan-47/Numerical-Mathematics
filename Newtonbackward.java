public class Newtonbackward
{
public static void main(String[] args)
{
    int number = 7;
    double X[] = {100, 150, 200, 250,300, 350, 400 };
     
    double Y[][]=new double[number][number];
    Y[0][0] = 10.63;
    Y[1][0] = 13.03;
    Y[2][0] = 15.04;
    Y[3][0] = 16.81;
    Y[4][0] = 18.42;
    Y[5][0] = 19.90;
    Y[6][0] = 21.27;
 
    for (int i = 1; i < number; i++)
    {
        for (int j = number - 1; j >= i; j--){
            Y[j][i] = Y[j][i - 1] - Y[j - 1][i - 1];
            Y[j][i]=Math.round(Y[j][i]*1000000.0)/1000000.0;
        }
    }
 
    for (int i = 0; i < number; i++)
    {
        for (int j = 0; j <= i; j++)
            System.out.print(Y[i][j] + "\t");
        System.out.println("");
    }

 
    double ans = Y[number - 1][0];
     
    double point = 410;
    double p = (point - X[number - 1]) / (X[1] - X[0]);
    for (int i = 1; i < number; i++)
    {
        ans = ans + (numerator(p, i) * Y[number - 1][i]) /
                                    fact(i);
    }
    System.out.println("\n Value at " + point +
                    " is " + String.format("%.6g%n",ans));
}

static double numerator(double p, int number)
{
    double update = p;
    for (int i = 1; i < number; i++)
        update = update * (p + i);
    return update;
}
static int fact(int number)
{
    int factorial = 1;
    for (int i = 2; i <= number; i++)
        factorial *= i;
    return factorial;
}
}
