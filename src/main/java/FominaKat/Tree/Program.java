package FominaKat.Tree;

public class Program {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(9);
        tree.add(7);
        tree.add(1);
        tree.add(15);
        tree.add(6);
        tree.add(4);
        tree.add(8);

        System.out.println(tree.find(8));
        System.out.println(tree.find(20));
    }
}
