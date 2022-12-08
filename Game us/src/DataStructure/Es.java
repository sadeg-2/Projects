package DataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Es {
    public static void main(String[] args) {
        int[] cc = {5,5,5,55,55,55};
        System.out.println(countPairOf60(cc));
    }
    public static int countPairOf60(int[] time){
        int[] map = new int[60];
        int res = 0 ;
        for (int c : time) {
            res += map[(60-c%60)%60];
            System.out.println(res);
            map[c%60]++;
        }
        return res ;
    }
}

