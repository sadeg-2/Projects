package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class stairs {
    public static void main(String[] args) {
        System.out.println(pow(5,-2));
        System.out.println(1.0/25);
        System.out.println(pow(5,-1));
    }
    public static double pow(int a, int b) {
        if (b==0)
            return 1 ;
        double res = pow(a,b/2);
        if (b%2 == 0){
            return res*res ;
        }else{
            if (b > 0)
                return a*res*res ;
            else
                return 1.0/a * res * res ;
        }
    }

    // by use iteration loop
    private static ArrayList<Long> getRowPascal1(long n) {
        ArrayList<Long> x = new ArrayList<>();
        x.add((long) 1);
        if (n > 1) {
            x.add(n - 1);
        }
        long mul = 2;
        long v = (n - 1) * (n - 2);
        if (n > 2) {
            x.add(v / 2);
        }
        for (int i = 3; i <= n / 2; i++) {
            mul *= i;
            v = v * (n - i);
            x.add(v / mul);
        }
        int c = x.size();
        for (int i = c - 2; i >= 0; i--) {
            x.add(x.get(i));
        }
        if (n % 2 == 0 && n > 2) {
           x.remove((int)n/2);
        }
        return x ;
    }
    // by get the previous row the compute the current row
    public static ArrayList<Integer> getRowPascal2(int n){
        if (n==1)
            return new ArrayList<>(Arrays.asList(1));
        else if (n==2)
            return new ArrayList<>(Arrays.asList(1,1));
        else{
            ArrayList<Integer> row = new ArrayList<>(Arrays.asList(1));
            ArrayList<Integer> prev = getRowPascal2(n-1);
            for (int i = 0; i < prev.size()-1; i++) {
                row.add(prev.get(i) + prev.get(i+1));
            }
            row.add(1);
            return row ;
        }
    }
    // by get compute every element in row
    public static ArrayList<Integer> getRowPascal3(int n ){
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(getIndexRowPascal(n,i));
        }
        return x ;
    }
    // get the specific row and index
    public static int getIndexRowPascal(int n , int index){
        if (index==0 || index==n-1)
            return 1;
        if (n == 1 || n == 2)
            return 1;
        if (index == 1 || index == n-2)
            return n-1;
        return getIndexRowPascal(n-1,index-1) + getIndexRowPascal(n-1,index);
    }



    public static void series(int n, int r, int a) {
        if (n == 0)
            return;
        System.out.print(a + " ");
        series(n - 1, r, a * r);
    }

    public static ArrayList<String> getAll(int num, int sum, String str) {
        ArrayList<String> c = new ArrayList<>();
        if (sum == num) {
            c.add(str);
            return c;
        } else if (sum < num) {
            ArrayList<String> y = getAll(num, sum + 1, str + "1");
            ArrayList<String> z = getAll(num, sum + 2, str + "2");
            c.addAll(y);
            c.addAll(z);
        }
        return c;
    }

}
