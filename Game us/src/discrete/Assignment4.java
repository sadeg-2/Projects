package discrete;

public class Assignment4 {
    public static void main(String[] args) {
        sLE(1,1,2,2,-1,1);
    }
    //ax + by = c
    //dx + fy = e
    public static void sLE(double a , double b , double c , double d , double f , double e) {
        double[][] m = {{a,b},{d,f}};
        double[][] r = {{c},{e}};
        double[][] result = multiplyMatrix(inverseMatrix(m),r);
        System.out.println("the x equal " + result[0][0]);
        System.out.println("the y equal " + result[1][0]);
    }
    public static double[][] multiplyMatrix(double[][] a1 , double[][] a2){
        double[][] result = new double[2][1];
        result[0][0] = a1[0][0] * a2[0][0] + a1[0][1]*a2[1][0];
        result[1][0] = a1[1][0] * a2[0][0] + a1[1][1]*a2[1][0];
        return result ;
    }

    public static double[][] inverseMatrix(double[][] m) {
        double c = m[0][0] * m[1][1] - m[0][1] * m[1][0];
        c = 1 / c;
        double[][] inverse = new double[2][2];
        inverse[0][0] = c * m[1][1];
        inverse[1][1] = c * m[0][0];
        inverse[0][1] = -c * m[0][1];
        inverse[1][0] = -c * m[1][0];
        return inverse;
    }
    // m , a , c , s
    public static int lengthOfSequence(int m, int a, int c, int s) {
        int xn = s;
        xn = (a * xn + c) % m;
        int count = 1;
        while (xn != s) {
            xn = (a * xn + c) % m;
            count++;
        }
        return count;
    }


}
