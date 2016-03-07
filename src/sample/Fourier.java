package sample;

import static java.lang.StrictMath.*;

/**
 * Created by abedaigorou on 15/12/17.
 */
public class Fourier
{
    private static final int f=100,n=10000;
    private static final double pd=0.2,a=0,b=2*PI;
    public static double dx;
    private double sum=0;

    static{
        dx = (b - a) / n;
    }


    public static double fourierCalc(double x) {
        double sum=0;
        sum = 0;
        for (int j = 1; j < 1001; j++) {
            sum += an(j) * cos(j * x) + bn(j) * sin(j*x);
        }
        sum += an(0) / 2;
        return sum;
    }

    public static double spectrum(int n)
    {
        return (sqrt(an(n)*an(n)+bn(n)*bn(n)));
    }

    public static double F(double x)
    {
        double fx=sin(2*PI*f*x);//+sin(f*x+2*PI*pd);

        //double fx=x;
        return (fx);
    }

    private static double an(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx) {
            s += F(i) * cos(2*PI*n * i) * dx;
        }
        return (s/PI);
    }
    //test
    private static double bn(int n)
    {
        double s=0;
        for(double i=0;i<2*PI;i+=dx)
            s+=F(i)*sin(2*PI*n * i)*dx;
        return (s/PI);
    }


}
