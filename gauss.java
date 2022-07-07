import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class gauss {
  public static final int MAX_ITERATIONS = 100;
  private static double[][] Mat;
  private static double[] cons;
  
  public gauss(double [][] matrix) {
      Mat = matrix; 
  }
  
  public static void main(String[] args) throws IOException
  {
   int n;
   double[][] Mat;
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
   System.out.println("Enter the data");
   
   n=Integer.parseInt(reader.readLine());
   Mat=new double[n][n+1];
   
   for(int i=0;i<n;i++){
       StringTokenizer strtk=new StringTokenizer(reader.readLine());
       
       while(strtk.hasMoreTokens()){
           for(int k=0;k<n+1 && strtk.hasMoreTokens();k++){
               Mat[i][k]=Double.parseDouble(strtk.nextToken());
           }
       }
   }
   
   gauss gau=new gauss(Mat);
   if(!gau.isOK()){
       System.out.println("The coefficient are not diagonally dominant");
   }
   
   System.out.println();
   
   gau.show();
   gau.SOLVE();
  }
  
  public void show(){
      int n=Mat.length;
      for(int i=0;i<n;i++){
          for(int k=0;k<n+1;k++){
              System.out.printf("%.3f", Mat[i][k]);
          }
          System.out.println();
      }
      System.out.println();
  }
  
  public boolean isOK(){
      boolean[] done=new boolean[Mat.length];
      int[] rows = new int[Mat.length];
      
      Arrays.fill(done, false);
      
      return Change(0, done, rows);
  }
  
  public boolean Change(int r, boolean[] done, int[] rows){
      int n= Mat.length;
      if(r==Mat.length){
          double[][] Trans=new double[n][n+1];
          for(int i=0;i<rows.length;i++){
              for(int k=0;k<n+1;k++){
                  Trans[i][k]=Mat[rows[i]][k];
              }
          }
          Mat=Trans;
          return true;
      }
      
      for(int i=0;i<n;i++){
          if(done[i]){
              continue;
          }
          double add=0;
          for(int j=0;j<n;j++){
              add+=Math.abs(Mat[i][j]);
          }
          if(2*Math.abs(Mat[i][r])>add){
              done[i]=true;
              rows[r]=i;
              
              if(Change(r+1,done, rows)){
                  return true;
              }
              
              done[i]=false;
          }
      }
      return false;
  }
  
  public void SOLVE(){
      int iterations = 0;
    int n = Mat.length;
    double AERR=1e-15;
    double[] X = new double[n];
    double[] P = new double[n];
    Arrays.fill(X, 0);
      
      while (true) {
      for (int i = 0; i < n; i++) {
        double sum = Mat[i][n]; // b_n

        for (int j = 0; j < n; j++)
          if (j != i)
            sum -= Mat[i][j] * X[j];

        // Update x_i to use in the next row calculation
        X[i] = 1/Mat[i][i] * sum;   
        X[i]=Math.round(X[i]*1000.0)/1000.0;
      }

      System.out.print("X_" + iterations + " = {");
      if(iterations==0){
              for(int i=0;i<n;i++){
                  System.out.print("0.000");
              }
          }
      
      for (int i = 0; i < n; i++)
        System.out.print(X[i] + " ");
      System.out.println("}");

      iterations++;
      if (iterations == 1) continue;

      boolean stop = true;
      for (int i = 0; i < n && stop; i++)
        if (Math.abs(X[i] - P[i]) > AERR)
          stop = false;

      if (stop || iterations == MAX_ITERATIONS) break;
      P = (double[])X.clone();
    }
  }
  }
