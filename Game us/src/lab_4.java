public class lab_4 {
    public static void main(String[] args) {
//        int a = 2 ;
//        int r = 2;
//        int n= 4;
//        num(a,r,n);
        System.out.println(revere("I will don't love you"));
    }
    public static void num(int a , int r , int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            a = a*r;
        }
    }
    public static String revere(String str){
        String[] arr = str.split(" ");
        String temp = "";
        for (int i = arr.length-1; i > 0 ; i--) {
            temp+= arr[i] + " ";
        }
        return temp ;
    }
}
