public class gaussbackward {

    public static void main(String[] args) {
        int number = 6;
        double X[] = {1939, 1949, 1959, 1969, 1979, 1989};

        double Y[][] = new double[number][number];
        Y[0][0] = 12;
        Y[1][0] = 15;
        Y[2][0] = 20;
        Y[3][0] = 27;
        Y[4][0] = 39;
        Y[5][0] = 52;
        

        for (int i = 1; i < number; i++) {
            for (int j = 0; j < number - i; j++) {
                Y[j][i] = Y[j + 1][i - 1] - Y[j][i - 1];
                Y[j][i] = Math.round(Y[j][i] * 1000000.0) / 1000000.0;
            }
        }

        for (int i = 0; i < number; i++) {
            System.out.print(X[i] + "\t");
            for (int j = 0; j < number - i; j++) {
                System.out.print(Y[i][j] + "\t");
            }
            System.out.println();
        }

        double point = 1974;
        double centre = Close(X, point);
        int ans_point=0;
        
        for(int k=0;k<X.length;k++){
            if(X[k]==centre){
                ans_point=k;
            }
        }
        if(X[ans_point]==point){
            ans_point=ans_point*1;
        }else{
            ans_point=ans_point-1;
        }
        double p = (point - X[ans_point]) / (X[1] - X[0]);
        double ans=Y[ans_point][0];
        ans_point=ans_point-1;
        for (int i = 1; i < number; i++) {
            
                ans = ans + ((numeratorbackward(p, i) * Y[(int)(ans_point)][i]) / factor(i));
                
         if(i%2==0){
             ans_point=ans_point-1;
         }
         if((ans_point<0)||(ans_point>=number)){
              break;}
        }
        
        ans = Math.round(ans * 1000000.0) / 1000000.0;
        System.out.println("\n Value at " + point
                + " is " + ans);
    }

    static double numeratorbackward(double p, int number) {
        double update = p;
        int i=1;
        while(i < number) {
            int k=1;
            if(i>1){
                if(i%2==1){
                    k=i-1;
                }else{
                    k=(int)i/2;
                }
                    
            }
            if (i % 2 == 1) {
                update = update * (p + k);
            } else {
                update = update * (p - k);
            }
            i++;
        }
        System.out.println(update);
        return update;
    }

    static int factor(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static double Close(double X[], double given) {
        int n = X.length;

        if (given <= X[0]) {
            return X[0];
        }
        if (given >= X[n - 1]) {
            return X[n - 1];
        }
        int i = 0, j = n;
        int middle = 0;
        while (i < j) {
            middle = (i + j) / 2;

            if (X[middle] == given) {
                return X[middle];
            }
            if (given < X[middle]) {

                if (middle > 0 && given > X[middle - 1]) {
                    return getClose(X[middle - 1],
                            X[middle], given);
                }

                j = middle;
            } else {
                if (middle < n - 1 && given < X[middle + 1]) {
                    return getClose(X[middle],
                            X[middle + 1], given);
                }
                i = middle + 1;
            }
        }

        return X[middle];
    }

    static double getClose(double val1, double val2,double given) {
        if (given - val1 >= val2 - given) {
            return val2;
        } else {
            return val1;
        }
    }
}

