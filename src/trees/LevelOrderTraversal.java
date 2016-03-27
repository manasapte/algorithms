package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mapte on 3/20/16.
 */
public class LevelOrderTraversal {
    void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        Node sentinel = new Node(Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(sentinel);
        Node last = null;
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if(last == sentinel) {
                queue.add(sentinel);
            }
            if(cur == sentinel) {
                System.out.println("$");
            } else {
                System.out.print(cur.data + " ");
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            last = cur;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(
                4,
                new Node(2, new Node(1), new Node(3)),
                new Node(
                        6,
                        new Node(5),
                        new Node(
                                10,
                                new Node(
                                        9,
                                        new Node(7, null, new Node(8)),
                                        null
                                ),
                                new Node(11)
                        )
                )
        );
        LevelOrderTraversal trav = new LevelOrderTraversal();
        trav.levelOrder(root);
    }
}
