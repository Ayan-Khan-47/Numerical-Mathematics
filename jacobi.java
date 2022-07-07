import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jacobi {
  public static final int MAX_ITERATIONS = 100;
  private static double[][] Mat;
  private static double[] cons;
  
  public jacobi(double [][] matrix) {
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
   
   jacobi jac=new jacobi(Mat);
   if(!jac.isOK()){
       System.out.println("The coefficient are not diagonally dominant");
   }
   
   System.out.println();
   
   jac.show();
   jac.SOLVE();
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
      int iterations=0;
      int n=Mat.length;
      
    double epsilon = 1e-15;
      double[] x= new double[n];
      double[] y= new double[n];
      Arrays.fill(x, 0);
      Arrays.fill(y, 0);
      
      while(true){
          for(int i=0;i<n;i++){
              double add=Mat[i][n];
              for(int k=0;k<n;k++){
                  if(k!=i){
                      add-=Mat[i][k]*y[k];
                  }
              }
              x[i]=1/Mat[i][i]*add;
              x[i]=Math.round(x[i]*1000.0)/1000.0;
          }
          System.out.println("iter "+iterations+"\t =(");
          if(iterations==0){
              for(int i=0;i<n;i++){
                  System.out.print("0.000");
              }
          }
          for(int i=0;i<n&& iterations!=0;i++){
              System.out.printf("%.3f",x[i]);
          }
          System.out.println(")");
          iterations++;
          if(iterations==1) continue;
          
          boolean stop = true;
      for (int i = 0; i < n && stop; i++)
        if (Math.abs(x[i] - y[i]) > epsilon)
          stop = false;
      
          if(stop || iterations==MAX_ITERATIONS){
              System.out.println("\n ** Converges at iterations "+(iterations-2));
              System.out.println("\n");
              break;
          }
          y=(double[])x.clone();
      }
  }
  
}
