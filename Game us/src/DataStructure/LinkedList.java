package DataStructure;

public class LinkedList {
    public static void main(String[] args) {
        ListNode a5 = new ListNode(5, null);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode head = new ListNode(1, a2);
        ListNode[] m = splitList(head, 2);
        for (int i = 0; i < m.length; i++) {
            ListNode c = m[i];
            while (c != null) {
                System.out.print(c.val +((c.next == null) ? "" : " -> "));
                c = c.next;
            }
            System.out.println();
        }
//        ListNode a5 = new ListNode(10, null);
//        ListNode a4 = new ListNode(8, a5);
//        ListNode a3 = new ListNode(2, a4);
//        ListNode a2 = new ListNode(4, a3);
//        ListNode head = new ListNode(1, a2);
//        int difference = differenceBetweenTwoSums(head,2);
//        System.out.println("the difference is : " + difference);
    }

    public static int differenceBetweenTwoSums(ListNode head, int N) {
        int sumNFirst = sumOfNode(head, N);
        ListNode reverse = reverseList(head);
        int sumNEnd = sumOfNode(reverse, N);
        head = reverseList(reverse);
        return sumNFirst - sumNEnd;
    }

    public static int sumOfNode(ListNode head, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += head.val;
            head = head.next;
        }
        return sum;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode jumpToNode(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    public static boolean isThereNNode(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (head == null)
                return false;
        }
        return true;
    }

    public static int numOfNode(ListNode head, int k) {
        int n = 0;
        ListNode start = new ListNode(0, head);
        while (isThereNNode(start, k)) {
            n++;
            start = jumpToNode(start, k);
        }
        return n;
    }

    public static ListNode[] splitList(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        int numOfNOde = numOfNode(head, k);
        ListNode start = new ListNode(0, head);
        for (int i = 0; i < k; i++) {
            ListNode tempHead = new ListNode(start.next.val, null);
            start = start.next;
            //System.out.println("the head is : " + tempHead.val);
            if (i != k - 1) {
                for (int j = 1; j < numOfNOde; j++) {
                    start = start.next;
                    ListNode current = new ListNode(start.val);
                    current.next = tempHead;
                    tempHead = current;
                    //  System.out.println(current.val);
                }
            } else {
                while (start.next != null) {
                    start = start.next;
                    ListNode current = new ListNode(start.val);
                    current.next = tempHead;
                    tempHead = current;
                    //  System.out.println(current.val);
                }
            }
            //   System.out.println("-------");
            listNodes[i] = reverseList(tempHead);
        }

        return listNodes;
    }

}


