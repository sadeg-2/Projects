package interpolation;

public class SolveInterpolation {
    public static void main(String[] args) {
        double[][] points = {{0,1},{5,10},{6,49},{2,142}};
        double[][] matrix = getMatrix(points);
        double[] c =solveMatrix(matrix);
        double[][] x = {{1,2,3},{2,11,6},{1,3,4}};
        gawLaw(x);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + ",,");
            }
            System.out.println();
        }
//        System.out.print(points[0][1] + " ");
//        for (int i = 0; i < c.length; i++) {
//            System.out.printf("%.1fx^%d ",c[i],i+1);
//        }
    }
    public static double[][] getMatrix(double[][] points){
        double[][] matrix = new double[points.length-1][points.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                matrix[i][j] = Math.pow(points[i+1][0],1+j);
            }
            matrix[i][matrix.length] = points[i+1][1] - points[0][1];
        }
        return matrix ;
    }
    public static void gawLaw(double[][] matrix){
        for (int i = 0; i < matrix.length-1 ; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                zeroNextMatrix(matrix[i],matrix[j],i);
            }
        }
        for (int i = matrix.length-1; i > 0; i--) {
            for (int j = i-1; j >=0 ; j--) {
                zeroNextMatrix(matrix[i],matrix[j],i);
            }
        }
    }
    public static double[] solveMatrix(double[][] matrix){
        double[] result = new double[matrix[0].length-1];
        for (int i = 0; i < matrix.length-1 ; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                zeroNextMatrix(matrix[i],matrix[j],i);
            }
        }
        for (int i = matrix.length-1; i > 0; i--) {
            for (int j = i-1; j >=0 ; j--) {
                zeroNextMatrix(matrix[i],matrix[j],i);
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i][3]/matrix[i][i];
        }
        return result ;
    }
    public static double[] multiMatrix(double[] m , double k){
        double[] temp = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            temp[i] = m[i]*k;
        }
        return temp ;
    }
    public static void zeroNextMatrix(double[] m1, double[] m2 , int index){
        double k = -m2[index]/m1[index];
        double[] m3 = multiMatrix(m1,k);
        for (int i = 0; i < m2.length; i++) {
            m2[i] +=m3[i];
        }
    }
}
