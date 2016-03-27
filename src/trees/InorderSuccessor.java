package trees;


import java.util.Stack;

public class InorderSuccessor {
    private Node root;

    InorderSuccessor(Node root) {
        this.root = root;
    }

    Node inorderSuccessor(int val) {
        Stack<Node> parents = new Stack<>();
        Node node = root;
        while(node.data != val) {
            parents.push(node);
            if(node.data < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if(node.right != null) {
            Node temp = node.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            while(!parents.empty()) {
                Node parent = parents.pop();
                if(parent.left == node) {
                    return parent;
                } else {
                    node = parent;
                }
            }
            return null;
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
        InorderSuccessor prog = new InorderSuccessor(root);
        Node succ = prog.inorderSuccessor(11);
        System.out.println("successor is: " + succ.data);
    }
}
