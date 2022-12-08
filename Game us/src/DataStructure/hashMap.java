package DataStructure;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class hashMap {
    public static void main(String[] args) {
        TreeMap<Character,Integer> c = new TreeMap<>();
        String x = "assadf";
        for (int i = 0; i < x.length(); i++) {
            c.put(x.charAt(i),i);
        }
        System.out.println(hasAllSmallChars("abcdefgghijklmnopqrstuvwxyz"));

    }
    private static String sortString1(String s) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (h.containsKey(index)) {
                h.put(index, h.get(index) + 1);
            } else {
                h.put(index, 1);
            }
        }
        String str = "" ;
        for (int i = 0; i < 26; i++) {
            if (h.containsKey(i)){
                int count = h.get(i);
                for (int j = 0; j < count; j++) {
                    str += (char)('a' + i) ;
                }
            }
        }
        return str;
    }

    public static boolean hasAllSmallChars(String s) {
        HashMap<Integer, Character> hash = new HashMap<>();
        hash.put(0, s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i)))
                return false;
            char before = (char) (s.charAt(i) - 1);
            if (before != hash.get(i - 1)) {
                return false;
            } else {
                hash.put(i, s.charAt(i));
            }
        }
        return hash.size() == 26;
    }


    private static String sortString(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (h.containsKey(s.charAt(i))) {
                h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
            } else {
                h.put(s.charAt(i), 1);
            }
        }
        System.out.println(h);
        Set<Character> c = h.keySet();
        StringBuilder str = new StringBuilder();
        for (Character ch : c) {
            int num = h.get(ch);
            for (int i = 0; i < num; i++) {
                str.append(ch);
            }
        }
        return str.toString();
    }


}
