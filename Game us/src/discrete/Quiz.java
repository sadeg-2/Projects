//package discrete;
//
//import org.apache.commons.compress.utils.Sets;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Quiz {
//    public static void main(String[] args) {
//        Set<Integer> a = new HashSet<>(Sets.newHashSet(1,2,3));
//        Set<Integer> b = new HashSet<>(Sets.newHashSet(1,5,2,3,6));
//        Set<Integer> c = new HashSet<>(Sets.newHashSet(1,2,3));
//        if (sub(a,b)){
//            System.out.println("A sub b");
//        }
//        if (sub(b,a)){
//            System.out.println("B sub A");
//        }
//        if (sub(a,c)){
//            System.out.println("A sub C");
//        }
//        if (sub(c,a)){
//            System.out.println("C sub A");
//        }
//        if (sub(b,c)){
//            System.out.println("B sub C");
//        }if(sub(c,b)){
//            System.out.println("C sub b");
//        }
//        if (a.equals(b)&&a.equals(c)){
//            System.out.println("three sets equals ");
//        }
//    }
//    public static boolean sub(Set<Integer> small , Set<Integer> big){
//        return big.containsAll(small);
//    }
//}
