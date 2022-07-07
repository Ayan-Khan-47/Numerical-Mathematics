public class NewtonDividedDifference{
 

  
public static void main(String[] args)
{
    int n = 5;
    float Y[][]=new float[n][n];
    float X[] = { 5, 7, 11, 13, 17 };
  
    Y[0][0] = 150;
    Y[1][0] = 392;
    Y[2][0] = 1452;
    Y[3][0] = 2366;
    Y[4][0] = 5202;
    
  
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
            Y[j][i] = (Y[j][i - 1] - Y[j + 1]
                        [i - 1]) / (X[j] - X[i + j]);
        }
    }
  
    for (int i = 0; i < n; i++) {
            System.out.print(X[i] + "\t");
            for (int j = 0; j < n - i; j++) {
                System.out.print(Y[i][j] + "\t");
            }
            System.out.println();
        }
  
    float point = 9;

    float sum = Y[0][0];
  
    for (int i = 1; i < n; i++) {
    sum = sum + (product(i, point, X) * Y[0][i]);
    }
      
    System.out.println("\nValue at "+point+" is "+
            sum);
}
static float product(int i, float point, float x[])
{
    float p = 1;
    for (int j = 0; j < i; j++) {
        p = p * (point - x[j]);
    }
    return p;
}
}
