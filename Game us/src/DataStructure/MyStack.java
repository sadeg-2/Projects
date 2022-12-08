package DataStructure;

import com.sun.xml.internal.ws.dump.LoggingDumpTube;

import javax.swing.text.Position;
import java.math.BigInteger;

public class MyStack {
    public static void main(String[] args) {
//        String str2 = "abbaca";
//        System.out.println("the length of close character is : "+removeCloseCharacters(str2));
//        String str1 = "[[[[]][[]][[]]]]";
//        System.out.printf("the Expression is %s",isExpressionValid(str1)? "Valid" :
//                "in Valid");
//
//        String eq = "5 + 3 * -2 + 6 * 2 + 3 * -2";
//        System.out.println("the result is : "+calculate(eq));

    }
    public  static void print(int x){
        if (x==12000)
            return;
        System.out.println(x);
        print(++x);
    }
    public static void dataCallYou(boolean response){
        if (response)
            System.out.println("Come to me Baby");
        dataCallYou(false);
    }
    public static int factorial(int x ){
        return (x == 1 )? 1 :x * factorial(x-1);
    }




    private static int calculate(String eq) {
        String[] ch = eq.split(" ");
        Stack<Integer> integer = new Stack<>();
        Stack<Character> operate = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            String temp = ch[i].trim();
            if ((i+2)%2 ==0){
                int x = Integer.parseInt(temp+"");
                integer.push(x);
            }else{
                char op = ch[i].trim().charAt(0);
                if (operate.isEmpty())
                    operate.push(op);
                else if (highO(op,operate.peek())){
                    operate.push(op);
                }else {
                    int x1 = integer.pop();
                    int x2 = integer.pop();
                    x1 = compute(operate.pop(),x1 ,x2);
                    x2 = integer.pop();
                    int result = compute(operate.pop(),x1 ,x2);
                    integer.push(result);
                    operate.push(op);
                }
            }
        }
        int size = operate.getSize();
        for (int i = 0; i < size; i++) {
            int x1 = integer.pop();
            int x2 = integer.pop();
            int result = compute(operate.pop(),x1 ,x2);
            integer.push(result);
        }
        return integer.pop();
    }

    //return if a high of b as a is * or / and b is + , -
    public static boolean highO(char a , char b){
        return (a == '*' || a == '/')&&(b=='+' || b == '-');
    }
    public static int compute(char type , int x1 , int x2){
        switch (type){
            case '+':
                return x1 + x2 ;
            case '-':
                return x2 - x1 ;
            case '*' :
                return x1 * x2 ;
            case '/':
                return x2/x1 ;
            default:
                return -1 ;
        }
    }

    public static int removeCloseCharacters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()){
                char c = stack.peek();
                if (c == s.charAt(i)){
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.getSize();
    }
    public static int multi (int x1 , int x2){
        if (x1 == 0)
            return 0 ;
        return x2 + multi(x1-1,x2);
    }



    public static boolean isExpressionValid(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (!stack.isEmpty()){
                char c = stack.peek();
                if (c == '[' && expression.charAt(i)==']'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(expression.charAt(i));
        }
        return stack.isEmpty();
    }
}

class Stack <T>{
    T[] x ;

    private int top = -1;

    public Stack() {
        x =(T[])new Object[1000];
    }

    public T pop() {
        T temp = x[top];
        top--;
        return temp;
    }

    public void push(T n) {
        top++;
        x[top] = n;
    }
    public T peek(){
        return (T)x[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public int getSize(){
        return top +1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{ ");
        for (int i = 0; i <= top; i++) {
            s.append(x[i] + " ,");
        }
        s.append("\b } ");
        return s.toString();
    }
}