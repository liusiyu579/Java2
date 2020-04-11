import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public static Node copyRandomList(Node head) {
        Map<Node, Node> m = new HashMap<>();
        Node node = head;
        while (node != null) {
            m.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            m.get(node).next = m.get(node.next);
            m.get(node).random = m.get(node.random);
            node = node.next;
        }
        return m.get(head);
    }
    public static void print(Node head){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.val +" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
