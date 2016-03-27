package linkedlists;

public class MergeSorted {
    Node mergeSorted(Node first, Node second) {
        if(first == null) {
            return second;
        }
        if(second == null) {
            return first;
        }
        Node temp;
        if(first.data < second.data) {
            temp = first;
            first = first.next;
        } else if(first.data == second.data) {
            temp = first;
            first = skipDups(first, first.data);
            second = skipDups(second, second.data);
        } else {
            temp = second;
            second = skipDups(second, second.data);
        }
        temp.next = mergeSorted(first, second);
        return temp;
    }

    Node skipDups(Node cur, int data) {
        while(cur != null && cur.data == data) {
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Node first = new Node(1, new Node(1, new Node(2, new Node(2, new Node(2, new Node(3, new Node(4, new Node(4))))))));
        Node second = new Node(2, new Node(3, new Node(3, new Node(3, new Node(4, new Node(4, new Node(4, new Node(4))))))));
    }
}
