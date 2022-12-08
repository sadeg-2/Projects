package AlgorithmLeetCode;


import java.util.*;

public class FirstWeek {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int[][] num = {{1,4,7,10},{2,5,8,11},{3,6,9,12}};
//        int[][] num2 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        System.out.println("the one group : ");
//        printA(num);
//        System.out.print("Enter the num of group : ");
//        int n1 = input.nextInt();
//        System.out.print("the one group : ");
//        printA(num2);
//        System.out.println("Enter the num of group ");
//        int n2 = input.nextInt();
//        System.out.println("the month is " + num[n1-1][n2-1]);
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> maps = new HashMap<>();
//        map.put('a', 0);
//        map.put('a', 1);
//        System.out.println();
//        System.out.println(checkInclusion("hello", "hellol"));
//        int[] x = {1,3,4,5,6,7,8};
//        System.out.println(reverseWords("fuck you man"));
//        System.out.println(Arrays.toString(twoSum(x,10)));
//        fib(100);
        // 0 1 1 2 3
//        List<String> wordList = new ArrayList<>();
//        wordList.add("cog");
//        System.out.println(!wordList.get(wordList.size()-1).equals("cog"));
        List<List<Integer>> x = allSubset(new int[]{1, 2, 3});
        System.out.println(x);
        System.out.println(addZeroes("1", 3));
        System.out.println(Double.parseDouble("3e1"));
        int[] c = {2, 3, 6, 7};
        List<Integer> v = combinationSum(c, 7, 0, 0, new ArrayList<>());
        System.out.println(v);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode pointer = head;
        ArrayList<Integer> x = new ArrayList<>();
        while (pointer!=null){
            x.add(pointer.val);
            pointer = pointer.next;
        }
        for (int i = 0; i < x.size()/2; i++) {
            if (x.get(i) != x.get(x.size()-1-i))
                return false;
        }
        return true ;
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return null;
    }

    public static List<Integer> combinationSum(int[] candidates, int target, int index, int sum, ArrayList<Integer> elements) {
        if (sum > target) {
            elements.remove(index);
            combinationSum(candidates, target, index + 1, sum - candidates[index], elements);
        }
        if (sum < target) {
            elements.add(candidates[index]);
            combinationSum(candidates, target, index, sum + candidates[index], elements);
        }
        return elements;
    }

    public int singleNumber(int[] nums) {
        int u = 0;
        for (int num : nums) {
            u ^= num;
        }
        return u;
    }

    public boolean isNumber(String s) {
        boolean comma = false;
        double x = 0;
        try {
            x = Double.parseDouble("s");
        } catch (Exception e) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (comma && s.charAt(i) == '.')
                return false;

        }
        return comma;
    }

    public int myAtoi(String s) {
        s = s.trim();
        int num = 0;
        if (s.length() == 0 || Character.isLetter(s.charAt(0)))
            return 0;
        boolean positive = s.charAt(0) != '-';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num *= 10 + num(s.charAt(i));

        }
        return (positive) ? num : -num;
    }

    public static int num(char i) {
        switch (i) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '0':
                return 0;
        }
        return 0;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null)
            return arr;
        arr.addAll(inorderTraversal(root.left));
        arr.add(root.val);
        arr.addAll(inorderTraversal(root.right));
        return arr;
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int maxN = maxDepth(root.children.get(i)) + 1;
            max = Math.max(max, maxN);
        }
        return max + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        int minRight = minDepth(root.right) + 1;
        int minLeft = minDepth(root.left) + 1;

        return Math.min(minLeft, minRight);
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int maxRight = maxDepth(root.right) + 1;
        int maxLeft = maxDepth(root.left) + 1;

        return Math.max(maxLeft, maxRight);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pointer = head.next;
        ListNode previous = head;
        while (pointer != null) {
            if (pointer.val == val) {
                previous.next = pointer.next;
            }
            pointer = pointer.next;
            previous = previous.next;
        }
        if (head.val == val)
            return null;
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        int lenListNode = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            lenListNode++;
        }
        if (lenListNode == 1)
            return null;
        pointer = head;
        for (int i = 1; i < lenListNode / 2; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;

        return head;
    }

    public ListNode middleNode(ListNode head) {
        int lenListNode = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            lenListNode++;
        }
        for (int i = 0; i < lenListNode / 2; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int lenListNode = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            lenListNode++;
        }
        pointer = head;
        for (int i = 1; i < lenListNode - n; i++) {
            pointer = pointer.next;
        }
        if (n == lenListNode) {
            head = head.next;
        } else {
            pointer.next = pointer.next.next;
        }
        return head;
    }

    public static List<List<Integer>> allSubset(int[] arr) {
        int numAll = (int) (Math.pow(2, arr.length));
        int numBit = Integer.toBinaryString(numAll - 1).length();
        List<List<Integer>> set = new ArrayList<>();
        for (int i = 0; i < numAll; i++) {
            String x = Integer.toBinaryString(i);
            //0 1 10 100000
            x = addZeroes(x, numBit);
            List<Integer> c = new ArrayList<>();
            // 1 2 3
            for (int j = x.length() - 1; j >= 0; j--) {
                if (x.charAt(j) == '1') {
                    c.add(arr[j]);
                }
            }
            set.add(c);
        }
        return set;
    }

    public static String addZeroes(String x, int len) {
        for (int i = x.length(); i < len; i++) {
            x = "0" + x;
        }
        return x;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        String word = beginWord;
        for (int i = 0; i < wordList.size(); i++) {
            if (numOfDifference(endWord, word) == 1) {
                word = wordList.get(i);
                map.put(word, 1);
                break;
            }
            if (wordList.get(i).equals(beginWord)) {
                continue;
            }
            if (numOfDifference(word, wordList.get(i)) == 1) {
                word = wordList.get(i);
                map.put(word, 1);
            }
        }

        System.out.println(map);
        if (map.containsKey(endWord))
            return map.size();
        return 0;
    }

    public static int numOfDifference(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1)
                return count;
        }
        return count;
    }

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int n1 = 1;
        int n2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = n2;
            n2 += n1;
            n1 = temp;
            System.out.println(n2);
        }
        return n2;
    }

    public static String reverseWords(String s) {
        String[] x = s.split(" ");
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < x.length - 1; i++) {
            c.append(reverseString(x[i])).append(" ");
        }
        c.append(reverseString(x[x.length - 1]));
        return c.toString();
    }

    public static StringBuilder reverseString(String s) {
        StringBuilder x = new StringBuilder();
        for (int i = s.length() - 1; 0 <= i; i--) {
            x.append(s.charAt(i));
        }
        return x;
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right++;
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (right > left) {
            int sum = numbers[right] + numbers[left];
            if (sum == target)
                return new int[]{left, right};
            if (sum > target)
                right--;
            if (sum < target)
                left++;
        }
        return null;
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[index] = temp;
                index++;
            }
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
            if (map.get(s2.charAt(i)) == 0)
                map.remove(s2.charAt(i));
        }
//        for (int i = 0; i < s1.length(); i++) {
//            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
//            if (map.get(s2.charAt(i)) == 0)
//                map.remove(s2.charAt(i));
//        }
        if (map.isEmpty()) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
            char ch = s2.charAt(i - s1.length());
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.getOrDefault(s2.charAt(i), 0) == 0)
                map.remove(s2.charAt(i));
            if (map.getOrDefault(ch, 0) == 0) {
                map.remove(ch);
            }
            if (map.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        System.out.println(count);
        return count;
//        for (int i = 1; i < nums.length; i++) {
//            nums[i]+=nums[i-1];
//            if (map.containsKey(nums[i]))
//                map.put(nums[i],map.get(nums[i])+1);
//            else
//                map.put(nums[i],1);
//        }
//
//        System.out.println(Arrays.toString(nums));
//        System.out.println(map);
//       // int count = 0 ;
//
//        for (Integer x:map.keySet()) {
//            int ex = x - k ;
//            if (map.containsKey(ex) && k!=0){
//                count += map.get(x)*map.get(ex);
//                System.out.println(ex);
//            }if (ex==0)
//                count+=map.get(x);
//        }
//
//        System.out.println("count :"+count);
//        return count ;
    }

    public static void printA(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("the %d group ", (i + 1));
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("\n----------------");
        }
    }

    // binary search
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (right >= left) {
            System.out.println(left + " " + mid + " " + right);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (right >= left) {
            System.out.println(left + " " + mid + " " + right);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
            mid = (left + right) / 2;
        }
        System.out.println(left + " " + mid + " " + right);
        return left;
    }

    public static int firstBadVersion(int n, int bad) {
        int mid = n / 2;
        int left = 0;
        // 1 2 3 4 5 6 -7 -8 -9
        while (n > left) {
            if (mid >= bad) {
                n = mid;
            } else {
                left = mid + 1;
            }
            mid = left + (n - left) / 2;
        }
        return mid;
    }

    public static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> num = new HashMap<>();
        int numOfPairs = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (num.containsKey(nums[i]))
                    num.put(nums[i], 2);
                else
                    num.put(nums[i], 1);
            }
            for (Integer x : num.keySet()) {
                if (num.get(x) == 2)
                    numOfPairs++;
            }
            return numOfPairs;
        }

        for (int i = 0; i < nums.length; i++) {
            num.put(nums[i], nums[i] - k);
        }
        for (Integer x : num.keySet()) {
            if (num.containsKey(num.get(x))) {
                System.out.println(x);
                System.out.println(num);
                System.out.println(numOfPairs);
                System.out.println("---------------");
                numOfPairs++;
            }
        }
        return numOfPairs;
    }

    public static boolean isPalindrome(int x) {
        String c = x + "";
        if (c.length() == 1 || c.length() == 0)
            return true;
        for (int i = 0; i < c.length() / 2; i++) {
            if (c.charAt(i) != c.charAt(c.length() - i - 1))
                return false;
        }
        return true;
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[p] = nums[i] * nums[i];
                i++;
            } else {
                result[p] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1)
            return;
        if (k > nums.length)
            k %= nums.length;
        int left = nums.length - k;
        int right = nums.length - 1;
        System.out.println(Arrays.toString(nums));
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(nums));
        left = 0;
        right = nums.length - k - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(nums));
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(nums));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
