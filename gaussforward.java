public class gaussforward {

    public static void main(String[] args) {
        int number = 6;
        double X[] = {20, 25, 30, 35, 40, 45};

        double Y[][] = new double[number][number];
        Y[0][0] = 354;
        Y[1][0] = 332;
        Y[2][0] = 291;
        Y[3][0] = 260;
        Y[4][0] = 231;
        Y[5][0] = 204;
        

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

        double point = 22;
        double centre = Closest(X, point);
        int ans_point=0;
        
        for(int k=0;k<X.length;k++){
            if(X[k]==centre){
                ans_point=k;
            }
        }
        if(X[ans_point]==point){
            ans_point=ans_point*1;
        }else{
            ans_point=ans_point+1;
        }
        double p = (point - X[ans_point]) / (X[1] - X[0]);
        double ans=Y[ans_point][0];
        for (int i = 1; i < number; i++) {
                ans = ans + ((numerator(p, i) * Y[(int)(ans_point)][i]) / fact(i));
                System.out.println(Y[ans_point][i]);
         if(i%2==1){
             ans_point=ans_point-1;
         }
         if((ans_point<0)||(ans_point>=number)){
              break;}
        }
        
        ans = Math.round(ans * 1000000.0) / 1000000.0;
        System.out.println("\n Value at " + point
                + " is " + ans);
    }

    static double numerator(double p, int number) {
        double update = p;
        int i=1;
        while(i < number) {
            int k=1;
            if(i>1){
                if(i%2==1){
                    k=i-2;
                }else{
                    k=(int)i/2;
                }
                    
            }
            if (i % 2 == 1) {
                update = update * (p - k);
            } else {
                update = update * (p + k);
            }
            i++;
        }
        System.out.println(update);
        return update;
    }

    static int fact(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static double Closest(double X[], double given) {
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
                    return getClosest(X[middle - 1],
                            X[middle], given);
                }

                j = middle;
            } else {
                if (middle < n - 1 && given < X[middle + 1]) {
                    return getClosest(X[middle],
                            X[middle + 1], given);
                }
                i = middle + 1;
            }
        }

        return X[middle];
    }

    static double getClosest(double val1, double val2,double given) {
        if (given - val1 >= val2 - given) {
            return val2;
        } else {
            return val1;
        }
    }
}
