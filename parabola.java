public class Parabola {
    static void fit(double X[], double Y[])
    {
        int n=3;
        int m=X.length;
        double[][] matrix=new double[3][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                matrix[i][j]=0;
            }
        }
        
        double a, b,c, sx = 0, sy = 0, sx2 = 0,t,sxy=0,sx3=0,sx4=0,sx2y=0;
        for (int i = 0; i < m; i++) {
            sx += X[i];
            sy += Y[i];
            sx2 += X[i]*X[i];
            sxy+=X[i]*Y[i];
            sx3+=X[i]*X[i]*X[i];
            sx4+=X[i]*X[i]*X[i]*X[i];
            sx2y+=X[i]*X[i]*Y[i];
        }
        matrix[0][0]=m;
        matrix[0][1]=sx;
        matrix[0][2]=sx2;
        matrix[0][3]=sy;
        
        matrix[1][0]=sx;
        matrix[1][1]=sx2;
        matrix[1][2]=sx3;
        matrix[1][3]=sxy;
        
        matrix[2][0]=sx2;
        matrix[2][1]=sx3;
        matrix[2][2]=sx4;
        matrix[2][3]=sx2y;
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.printf(matrix[i][j]+"\t\t");
            }
            System.out.println();
        }
        
     
    for (int i = 0; i < n; i++)
    {
        
 
        for (int j = 0; j < n; j++)
        {
             
            if (i != j)
            {
           
                double p = matrix[j][i] / matrix[i][i];
 
                for (int k = 0; k <= n; k++)                
                    matrix[j][k] = matrix[j][k] - (matrix[i][k]) * p;            
            }
        }
    }
    
    a=matrix[0][3]/matrix[0][0];
    b=matrix[1][3]/matrix[1][1];
    c=matrix[2][3]/matrix[2][2];
    System.out.println(a+"\t\t"+b+"\t\t"+c+"\t\t");
}
    public static void main(String args[])
    {
        double X[] = {1, 2, 3, 4,5,6,7,8,9 };
        double Y[] = { 2,6,7,8,10,11,13,10,9};
        fit(X,Y);
    }
}
