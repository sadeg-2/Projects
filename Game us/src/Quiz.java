//import org.apache.commons.compress.utils.Sets;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class Quiz {
//    public static void main(String[] args) {
//        Set<Integer> a = new HashSet<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        Set<Integer> b = new HashSet<>();
//        b.add(3);
//        b.add(5);
//        b.add(6);
//        b.add(1);
//        b.add(2);
//        Set<Integer> c = new HashSet<>();
//        c.add(9);
//        c.add(8);
//        c.add(10);
//        if (b.containsAll(a)){
//            System.out.println("A sub B");
//        }
//        if (a.containsAll(b)){
//            System.out.println("B sub A");
//        }
//        if (c.containsAll(a)){
//            System.out.println("A sub C");
//        }
//        if (a.containsAll(c)){
//            System.out.println("C sub A");
//        }
//        if (b.containsAll(c)){
//            System.out.println("B sub C");
//        }if(c.containsAll(b)){
//            System.out.println("C sub b");
//        }
//
//    }
//}
