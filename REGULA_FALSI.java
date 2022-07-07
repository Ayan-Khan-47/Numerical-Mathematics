public class REGULA_FALSI{
    static final Double AERR=0.0001;
    static int iteration = 20, DecimalUpto = 6;

    static double Regula_func(double x) {
        return x-5;
    }
    static void regulaFalsi(double a, double b){
        if(Regula_func(a)*Regula_func(b)>=0){
            System.out.println("Initial values are wrong ");
            return;
        }
        double c=a;
        for(int i=0;i<20;i++){
            c=(a*Regula_func(b)-b*Regula_func(a))/(Regula_func(b)-Regula_func(a));
            if(Regula_func(c)==0)
                break;
            else if(Regula_func(c)*Regula_func(a)<0)
                b=c;
            else
                System.out.println("Roots are :"+Math.round(c * Math.pow(10, DecimalUpto))/ Math.pow(10, DecimalUpto));
            a=c;
        }
        System.out.println("The approximate root is : "+Math.round(c * Math.pow(10, DecimalUpto))/ Math.pow(10, DecimalUpto));
    }
    public static void main(String[] args){
        double a=1, b=6;
        regulaFalsi(a, b);
    }
}
