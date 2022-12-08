package DataStructure;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayD {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(5);
//        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(4);
//        l2.next.next = new ListNode(6);
//        ListNode l3 = new ListNode(2);
//        l3.next = new ListNode(4);
//        l3.next.next = new ListNode(6);
//        ListNode xc = mergeKLists(new ListNode[]{l1, null});
//        printLinkedList(xc);
//        int[] x = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3};
//        int k = removeDuplicates(x);
//        System.out.println(199999);
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        int b = firstMissingPositive(nums);
        System.out.println(addDigits(388));
        System.out.println(addDigit(388));
        //5 7 8 9
        //5 7 8 9 6
//        String c = "";
//        String b = "a";
//        System.out.println(findTheDifference(c,b));
    }
    public static int addDigits(int num) {
        while(num >= 10){
            num = sumDigits(num);
        }
        return num ;
    }
    public static int addDigit(int num) {
        if (num == 0){
            return 0;
        }
        if (num % 9 == 0){
            return 9;
        }
        else {
            return num % 9;
        }
    }
    public static int sumDigits(int num){
        int sum = 0 ;
        while (num>0){
            sum+= num%10;
            num /= 10 ;
        }
        return sum ;
    }
    public static char findTheDifference(String s, String t) {
        long sumC =0;
        for (int i = 0; i < s.length(); i++) {
            sumC += t.charAt(i) - s.charAt(i);
        }
        sumC+=t.charAt(t.length()-1);
        return (char)sumC;
    }

    public static int removeDuplicates(int[] nums) {
        int k = nums.length;
        int repeat = 1;
        if (nums.length == 0)
            return 0;
        int element = nums[0];
        for (int i = 1; i < k; i++) {
            if (nums[i] == element) {
                repeat++;
                if (repeat > 2) {
                    for (int j = i; j < k - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    i--;
                    k--;
                }

            } else {
                repeat = 1;
                element = nums[i];
            }
        }
        return k;
    }

    // 1 4 7 5 2 3
    // len
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = 0;
        }
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i + 1 || nums[i] > nums.length || nums[i] == 0) {
                i++;
                continue;
            }
            if (nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }
            // 2 5 7 8 9 10 3 4
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
            System.out.println(Arrays.toString(nums));

        }
        for (int i = 1; i <= nums.length; i++) {
            if (i != nums[i - 1])
                return i;
        }

        return nums.length + 1;
    }

    public static int firstMissingPositives(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0)
                nums[i]=nums.length+1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(Math.abs(nums[i])-1);
            System.out.println(num);
            if (num > nums.length - 1)
                continue;
            if (nums[num]>0)
                nums[num]*= -1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] >= 0) return i+1 ;
        }

        return nums.length  +1;
    }
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> repeat = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (repeat.containsKey(nums[i])) {
                repeat.put(nums[i], repeat.get(nums[i]) + 1);
            } else {
                repeat.put(nums[i], 1);
            }
        }
        int max = nums[0];
        System.out.println(repeat.keySet());
        System.out.println(repeat.values());
        for (int x : repeat.keySet()) {
            if (repeat.get(x) > repeat.get(max)) {
                max = x;
            }
        }
        int smallest = getSmall(nums, max);
        for (int x : repeat.keySet()) {
            if (repeat.get(x).equals(repeat.get(max))) {
                int tem = getSmall(nums, x);
                if (tem > smallest)
                    smallest = tem;
            }
        }
        return smallest;
    }

    public static int getSmall(int[] nums, int k) {
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                first = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == k)
                return i - first + 1;
        }
        return 1;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        int index = 0;
        int numOfNull = 0;
        if (lists.length == 0)
            return null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                lists[index] = lists[i];
                index++;
            } else
                numOfNull++;

        }
        if (numOfNull == lists.length)
            return null;

        int smallNumber = lists[0].val;
        while (true) {
            index = 0;
            for (int i = 0; i < lists.length - numOfNull; i++) {
                if (lists[i].val < smallNumber) {
                    smallNumber = lists[i].val;
                    index = i;
                }
            }
            ListNode pointer = temp;
            while (pointer.next != null)
                pointer = pointer.next;
            pointer.next = new ListNode(smallNumber);

            lists[index] = lists[index].next;
            if (lists[index] == null) {
                lists[index] = lists[lists.length - numOfNull - 1];
                lists[lists.length - numOfNull - 1] = null;
                numOfNull++;
            }
            if (numOfNull == lists.length)
                break;
            smallNumber = lists[0].val;

        }


        return temp.next;
    }

    public static void printLinkedList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "  ");
            l = l.next;
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        String longest = strs[0];
        if (strs.length == 1)
            return "";
        int match = longest.length() - 1;
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];
            if (temp.length() < match)
                match = temp.length();
            for (int j = 0; j < match; j++) {
                if (temp.charAt(j) == longest.charAt(j))
                    continue;
                else {
                    match = j;
                    break;
                }
            }
        }
        StringBuilder lo = new StringBuilder();
        for (int i = 0; i < match; i++) {
            lo.append(longest.charAt(i));
        }
        return lo.toString();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(' || stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char x = stack.peek();
            if (s.charAt(i) == '}' && x == '{' || s.charAt(i) == ']' && x == '[' || s.charAt(i) == ')' && x == '(') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    // 1 2 3  , 2 7 9 >> 1 2 2 3 7 9
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int k = 0;
        int k2 = 0;
        for (int i = 0; i < temp.length; i++) {
            if (k == nums1.length) {
                for (int j = k + k2; j < temp.length; j++) {
                    temp[j] = nums2[k2];
                    k2++;
                }
                break;
            }
            if (k2 == nums2.length) {
                for (int j = k + k2; j < temp.length; j++) {
                    temp[j] = nums1[k];
                    k++;
                }
                break;
            }
            if (nums1[k] < nums2[k2]) {
                temp[i] = nums1[k];
                k++;
            } else {
                temp[i] = nums2[k2];
                k2++;
            }
        }
        if (temp.length % 2 != 0)
            return temp[temp.length / 2];
        else {
            return (temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2.0;
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            } else {
                return nums2[nums2.length / 2];
            }
        } else if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        int k = (nums1.length + nums2.length) / 2;
        int l1 = 0;
        int l2 = 0;
        int before = 0;
        boolean is1 = true;
        for (int i = 0; i <= k; i++) {
            if (i == k) {
                before = is1 ? nums1[l1 - 1] : nums2[l2 - 1];
            }
            if (l1 == nums1.length) {
                l2++;
                is1 = false;
                continue;
            }
            if (l2 == nums2.length) {
                l1++;
                is1 = true;
                continue;
            }
            if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
                is1 = false;
            }
        }
        int after = is1 ? nums1[--l1] : nums2[--l2];
        if ((nums1.length + nums2.length) % 2 != 0)
            return after;
        else {
            return (after + before) / 2.0;
        }
    }

}



