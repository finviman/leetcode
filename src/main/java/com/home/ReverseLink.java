package leetcode.easy;

/**
 * Created by liyang on 23/9/2017.
 */
public class ReverseLink {

    public static void main(String[] args) {
        ReverseLink a = new ReverseLink();
        a.test();
    }

    public void test() {
        Node head = new Node(1);
        Node v1 = new Node(2);
        head.next=v1;
        Node v2 = new Node(3);
        v1.next=v2;
        Node v3 = new Node(4);
        v2.next=v3;
        Node v4 = new Node(5);
        v3.next=v4;

        Node newHead = reverse(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newHead = newHead.next;
        }
    }

    public Node reverse(Node head) {
        Node pre = head;
        Node cur = head.next;
        head.next=null;
        if (cur==null) {
            return head;
        }

        while (true) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            if (next==null) {
                break;
            }
            cur =next;
        }
        return cur;
    }

    class Node{
        Node(int val) {
            this.val=val;
        }
        Node next;
        int val;
    }
}
