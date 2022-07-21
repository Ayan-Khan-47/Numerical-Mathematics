public class Straight {
    static void fit(double X[], double Y[])
    {
        int n = X.length;
        double a, b, sx = 0, sy = 0,sxy = 0, sx2 = 0;
        for (int i = 0; i < n; i++) {
            sx += X[i];
            sy += Y[i];
            sxy += X[i] * Y[i];
            sx2 += X[i]*X[i];
        }
 
        b = (n * sxy - sx * sy) / (n * sx2 - sx*sx);
        a = (sy - b * sx) / n;
 
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
 
    public static void main(String args[])
    {
        double X[] = { 1, 2, 3, 4, 5 };
        double Y[] = { 5, 7, 9, 10, 11 };
        fit(X,Y);
    }
}
