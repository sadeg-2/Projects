package discrete;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DrOsama {
    public static void main(String[] args) {
//        ArrayList<String>grayCode = grayCode(3);
//        System.out.println(grayCode);
        Queue<Integer> q = new PriorityQueue<>();
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println("the Queue before : " + q);
        System.out.println("the max element in the Queue is : " + findMax(q));
        System.out.println("the Queue after : "+ q);

    }
    public static Comparable findMax(Queue Q) {
        Queue n = new PriorityQueue(Q.size());
        int size = Q.size();
        Comparable x =  0 ;
        for (int i = 0; i < size ; i++) {
            Comparable now = (Comparable) Q.remove();//Q.dequeue();
            if (x.compareTo(now) < 0){
                x = now ;
            }
            n.add(now);// n.enqueue(now)
        }
        System.out.println(n);
        for (int i = 0; i < size; i++) {
            Q.add(n.remove());//Q.enqueue(n.dequeue);
        }
        return x ;
    }
    public static ArrayList<String> grayCode(int x){
        ArrayList<String> l = new ArrayList<>();
        if (x==1){
            l.add("0");
            l.add("1");
        }
        else{
            ArrayList<String> l1 = grayCode(x-1);
            ArrayList<String> l2  = reverseArray(l1);
            for (int i = 0; i < l1.size(); i++) {
                l1.set(i,"0"+l1.get(i));
            }
            for (int i = 0; i < l2.size(); i++) {
                l2.set(i,"1"+l2.get(i));
            }
            l.addAll(l1);
            l.addAll(l2);
        }
        return l ;
    }
    public static ArrayList<String> reverseArray(ArrayList<String> arr){
        ArrayList<String> temp = new ArrayList<>();
        for (int i = arr.size()-1; i >= 0 ; i--) {
            temp.add(arr.get(i));
        }
        return temp;
    }
}



