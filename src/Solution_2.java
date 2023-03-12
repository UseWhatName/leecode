import com.sun.xml.internal.ws.api.pipe.NextAction;
import javafx.application.Platform;
import sun.print.SunMinMaxPage;

import javax.swing.text.StyleContext;

/**
 * @author by zling
 * @classname Solution_2
 * @description TODO
 * @date 2023/3/8 23:47
 */
public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur = new ListNode(0);
        ListNode head = cur;
        boolean plus = false;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + (plus ? 1 :0);
            if (sum < 10) {
                plus = false;
            } else {
                plus = true;
            }
            ListNode listNode = new ListNode(sum % 10);
            cur.next = listNode;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (plus) {
            cur.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {

        Solution_2 solution_2 = new Solution_2();
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode2.next = listNode4;
        ListNode listNode3 = new ListNode(9);
        listNode4.next = listNode3;

        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        ListNode listNode42 = new ListNode(4);
        listNode6.next = listNode42;
        ListNode listNode92 = new ListNode(9);
        listNode42.next = listNode92;

        solution_2.addTwoNumbers(listNode2, listNode5);


    }




    public static class ListNode {
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
}
