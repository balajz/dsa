public class palidromeLinkedList {
    public static void main(String[] args) {
        ListNode head = null, prev = null;
        for (int i = 0; i < 8; i++) {
            ListNode node = new ListNode(i);
            if (prev == null) {
                head = node;
            } else {
                node.next = null;
                prev.next = node;
            }
            prev = node;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        boolean val = isPalindrome(head);
        System.out.println(val);

    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = Reverse(slow.next);
        ListNode first = head, second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
        }

        Reverse(newHead);
        return true;
    }

    public static ListNode Reverse(ListNode head) {
        ListNode temp = head;
        ListNode next, prev = null;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val; } 
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


