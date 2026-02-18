import java.util.ArrayList;
import java.util.List;

public class oddAndEven {

    public ListNode oddEvenListUsingList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        List<Integer> list = new ArrayList<>();

        while (temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.val);
        }

        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.val);
        }

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.val = list.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }

    public ListNode oddAndEvenOptimal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode even = head.next;
        ListNode odd = head;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
