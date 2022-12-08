package DataStructure;

public class quiz {
    public static void main(String[] args) {

    }
    public static void count_odd(int[] numbers){
        int count = 0 ;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2!=0)
                count++;
        }
        System.out.println("the number of the odd number is " + count);
    }
}
