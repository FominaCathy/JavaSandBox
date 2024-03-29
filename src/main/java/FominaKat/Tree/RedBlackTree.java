package FominaKat.Tree;

public class RedBlackTree {
    Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean res = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return res;
        } else {
            root = new Node(value, Color.BLACK);
            return true;
        }
    }

    public Node find(int value) {
        return find(root, value);

    }

    private Node find(Node node, int value) {
        if (node == null){
            return null;
        }
        if (node.value == value){
            return node;
        } else {
            if (node.value < value){
                return find(node.right, value);
            } else {
                return find(node.left, value);
            }
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left == null) {
                    node.left = new Node(value, Color.RED);
                    return true;
                } else {
                    boolean res = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return res;
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(value, Color.RED);
                    return true;
                } else {
                    boolean res = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return res;
                }
            }
        }
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.RED;
        return left;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private Node rebalance(Node node) {
        Node res = node;
        boolean needRe = true;
        while (needRe) {
            needRe = false;
            if ((res.right != null && res.right.color == Color.RED) &&
                    (res.left == null || res.left.color == Color.BLACK)) {
                needRe = true;
                res = rightSwap(res);
            }
            if ((res.left != null && res.left.color == Color.RED) &&
                    (res.left.left != null && res.left.left.color == Color.RED)) {
                needRe = true;
                res = leftSwap(res);
            }
            if (res.left != null && res.left.color == Color.RED &&
                    res.right != null && res.right.color == Color.RED) {
                needRe = true;
                colorSwap(res);
            }
        }
        return res;
    }

    private class Node {
        int value;
        private Color color;
        Node left;
        Node right;

        public Node(int value, Color color) {
            this.value = value;
            this.color = color;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }
}
