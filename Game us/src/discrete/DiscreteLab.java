//package discrete;
//
//import com.sun.deploy.panel.AbstractRadioPropertyGroup;
//import org.apache.commons.compress.utils.Sets;
//
//import java.util.*;
//
//public class DiscreteLab {
//    public static void main(String[] args) {
////        int i = 4 ;
////        int j = 4 ;
////        int index_Row = 0 ;
////        int index_Column = 0 ;
////        snake(i, j, index_Row, index_Column);
//
////        int[] a1 = {1,4,7};
////        int[] a2 = {2,3,5};
////        int[] big = new int[6];
////        int a1i = 0 , a2i = 0 ;
////        for (int i = 0; i < 6; i++) {
////            if (a1i!=a1.length-1 && a1[a1i] < a2[a2i]){
////                big[i] = a1[a1i] ;
////                a1i++;
////            }
////        }
////        findSingleElement( 0, 111, 111, 22, 22, 3, 3, 4, 4, 5 ,5,6, 6, 7, 7, 8, 8, 9, 9,
////                10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16);
////        int[] a1 = {0,1,5,6};
////        int[] a2 = {2,4,7,8};
////        int[] a3 = new int[a1.length + a2.length];
////        int index1 = 0 ,index2 = 0  ;
////        for (int i = 0; i < a3.length; i++) {
////            boolean x = index1!= a1.length && index2!= a2.length ;
////            if (x && a1[index1] < a2[index2]){
////                a3[i] = a1[index1];
////                index1++;
////            }else if (x  && a2[index2] < a1[index1]){
////                a3[i] = a2[index2];
////                index2++;
////            }else if(index1 == a1.length){
////                a3[i] = a2[index2];
////                index2++;
////            }else if(index2 == a2.length){
////                a3[i] = a1[index1];
////                index1++;
////            }
////        }
////        System.out.println(Arrays.toString(a3));
////
////        System.out.println("GCD " + GCD(8, 22));
////        System.out.println("GCD" + GCDMod(8, 22));
////        System.out.println("GCF " + GCF(5, 35));
////        System.out.println("GCF" + GCF(5, 35, 1));
////        System.out.println(sumOfArray(0,new int[]{1,2,3,4,5,6}));
////        Set<Integer> a = new HashSet<>(Sets.newHashSet(0,1));
////        Set<Integer> b = new HashSet<>(Sets.newHashSet(2,3));
////        Set<Integer> a1 = new HashSet(Sets.newHashSet(0,2));
////        Set<Integer> a2 = new HashSet(Sets.newHashSet(2,3));
////        Set<Integer> a3 = new HashSet(Sets.newHashSet(0,1));
////        Set<Set<Integer>> axb = new HashSet<>();
////        for (Integer c :a) {
////            for (Integer d: b) {
////                axb.add(new HashSet<>(Sets.newHashSet(c,d)));
////            }
////        }
////        if (axb.contains(a1)){
////            System.out.println("A1 is a subset from(AxB)");
////        }
////        if (axb.contains(a2)){
////            System.out.println("A2 is a subset from(AxB)");
////        }
////        if (axb.contains(a3)){
////            System.out.println("A3 is a subset from(AxB)");
////        }
////        String eq = "5 * 6.3";
////        String temp = "";
////        char operand = ' ';
////        String x = "" ;
////        String y = "";
////        for (int i = 0; i < eq.length(); i++) {
////            if (eq.charAt(i) == '*') {
////                operand = '*';
////                continue;
////            } else if (eq.charAt(i) == '+') {
////                operand = '+';
////                continue;
////            } else if (eq.charAt(i) == '-') {
////                operand = '-';
////                continue;
////            } else if (eq.charAt(i) == '/') {
////                operand = '/';
////                continue;
////            }
////            temp+=eq.charAt(i);
////        }
////        boolean isNum1 = false;
////        for (int i = 0; i < temp.length(); i++) {
////            if (!isNum1){
////                if (temp.charAt(i) != ' ')
////                    x +=temp.charAt(i);
////                else
////                    isNum1=true;
////            }else {
////                if (temp.charAt(i) != ' ')
////                    y+=temp.charAt(i);
////            }
////        }
////        double x1 = Double.parseDouble(x);
////        double y1 = Double.parseDouble(y);
////        double result = 0 ;
////        switch (operand) {
////            case '*':
////                result = x1*y1;
////                break;
////            case '+':
////                result= x1+y1;
////                break;
////            case '-':
////                result = x1 - y1;
////                break;
////            case '/':
////                result = x1/y1;
////                break;
////        }
////        System.out.println(eq + " = " + result);
////        Stack<Integer> s = new Stack<>();
////        Deque<Integer> q = new ArrayDeque<>(Arrays.asList(2, 3, 4, 5, 6, 7));
////        s.push(q.removeLast());
////        s.push(q.removeLast());
////        s.push(q.removeFirst());
////        s.push(q.removeFirst());
////        s.push(q.removeLast());
////        q.addFirst(s.pop());
////        q.addFirst(s.pop());
////        q.addFirst(s.pop());
////        q.addLast(s.pop());
////        q.addLast(s.pop());
////        System.out.println(q);
////        System.out.println(s);
//        Set<Set<Integer>> x = allSubset(new int[]{1,2,3,4});
//        for (Set<Integer> c:x) {
//            System.out.println(c);
//        }
//
//    }
//    public static Set<Set<Integer>> allSubset(int[] arr){
//        int numAll = (int)(Math.pow(2,arr.length));
//        Set<Set<Integer>> set = new HashSet<>();
//        for (int i = 0; i < numAll; i++) {
//            String x = Integer.toBinaryString(i);
//            //0 1 10 100000
//            Set<Integer> c = new HashSet<>();
//            for (int j = x.length() -1; j >= 0; j--) {
//                if (x.charAt(j) == '1')
//                    c.add(arr[j]);
//            }
//            set.add(c);
//        }
//        return set ;
//    }
//
//    //    public static boolean isExist(Stack s , Element x){
////        Queue q = new Queue();
////        boolean exist = false ;
////        while (!s.isEmpty()){
////            Element e = s.pop();
////            q.enQueue(e);
////            if (e.equal(e)){
////                exist = true ;
////                break;
////            }
////        }
////        while (!q.isEmpty()){
////            Element e = q.deQueue();
////            s.push(e);
////        }
////        return exist;
////    }
//
//
//    public static String reCrypto(String x, int k) {
//        String ne = "";
//        for (int i = 0; i < x.length(); i++) {
//            int c = x.charAt(i) - 'A' - k;
//            if (c >= 0) {
//                ne += (char) ('A' + (x.charAt(i) - 'A' - k) % 26);
//            } else {
//                ne += (char) ('A' + 26 + (x.charAt(i) - 'A' - k) % 26);
//            }
//        }
//        return ne;
//    }
//
//    public static int sumOfArray(int index, int[] array) {
//        if (index == array.length)
//            return 0;
//        return array[index] + sumOfArray(index + 1, array);
//    }
//
////    public static Position addLast(E e){
////        Position current = null ;
////        if (isEmpty())
////            current = addfirst(e);
////        else {
////            Position last = last();
////            current = addAfter(last,e);
////        }
////        return current ;
////    }
//
//
//    public static int GCD(int m, int n) {
//        if (n == 0) return m;
//        return GCD(n, m % n);
//    }
//
//    public static int GCDMod(int n, int m) {
//        int gcd = 1;
//        if (n > m) {
//            int temp = n;
//            n = m;
//            m = temp;
//        }
//        for (int i = 2; i < n; i++) {
//            if (m % i == 0 && n % i == 0 && i > gcd) {
//                gcd = i;
//            }
//        }
//        return gcd;
//    }
//
//    public static int GCF(int m, int n, int x) {
//        if ((m * x) % n == 0)
//            return m * x;
//        return GCF(m, n, x + 1);
//    }
//
//    public static int GCF(int m, int n) {
//        return m * n / GCD(m, n);
//    }
//
//    private static void snake(int i, int j, int index_Row, int index_Column) {
//        int[][] x = new int[i][j];
//        for (int k = 0; k < i * j; k++) {
//            if (k != 0 && k % 4 == 0) {
//                index_Row++;
//                index_Column = 0;
//                System.out.println(" ");
//            }
//            if ((index_Row + 2) % 2 != 0) {
//                x[index_Row][index_Column] = k + 1;
//            } else {
//                x[index_Row][j - index_Column - 1] = k + 1;
//            }
//            System.out.println(index_Row + " " + index_Column + " " + k);
//            index_Column++;
//
//        }
//        for (int k = 0; k < x.length; k++) {
//            System.out.println(Arrays.toString(x[k]));
//
//        }
//    }
//
//    private static void findSingleElement(int... x) {
//        int left = 0, right = x.length - 1, mid = x.length / 2;
//        int index_symbol = 0;
//        while (left < right) {
//            System.out.println("times");
//            if (x[mid] == x[mid + 1] && mid % 2 == 0 || (x[mid] == x[mid - 1] && mid % 2 != 0)) {
//                left = mid + 1;//5
//            } else {
//                right = mid - 1;
//            }
//            mid = (right - left) / 2 + left;
//            boolean b = x.length - 1 != mid && x[mid + 1] != x[mid];
//            if (b && (mid == 0 || (mid == left))) {
//                if (mid != 0 && x[mid - 1] == x[mid]) {
//                    index_symbol = mid + 1;
//                    break;
//                }
//                index_symbol = mid;
//                break;
//            } else if (left == mid && left == right) {
//                System.out.println("No Single Number");
//                System.exit(0);
//            } else {
//                index_symbol = right;
//            }
//        }
//        System.out.println("the number is : " + x[index_symbol]);
//    }
//
//    public static void plusMinus(List<Integer> arr) {
//        // Write your code here
//        int[] ration = new int[3];
//        for (int e : arr) {
//            if (e > 0)
//                ration[0]++;
//
//            else if (e < 0)
//                ration[1]++;
//            else
//                ration[2]++;
//
//        }
//        System.out.println(ration[0] / arr.size());
//        System.out.println(ration[1] / arr.size());
//        System.out.println(ration[2] / arr.size());
//
//    }
//
//    public static boolean isAnotherExist(int[] list, int k) {
//        for (int i = 0; i < list.length; i++) {
//            if (i == k)
//                continue;
//            if (list[i] == list[k])
//                return true;
//        }
//        return false;
//    }
//
//
//    public static int diagonalDifference(List<List<Integer>> arr) {
//        // Write your code here
//        int r = 0;
//        int l = 0;
//        for (int i = 0; i < arr.size(); i++) {
//            r += arr.get(i).get(i);
//            l += arr.get(i).get(arr.size() - i - 1);
//        }
//        return Math.abs(r - l);
//    }
//}
//
//class Queue {
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    void enQueue(int x) {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        stack1.push(x);
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//    }
//
//    int deQueue() {
//        if (stack1.isEmpty()) {
//            System.out.println("Q is Empty");
//            System.exit(0);
//        }
//        int x = stack1.peek();
//        stack1.pop();
//        return x;
//    }
//}
