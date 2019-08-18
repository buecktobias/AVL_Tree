
public class Test {
    public static void main(String[] args) {
        AVL_Tree<Integer> avl = new AVL_Tree<>();
        avl.addElement(5);
        avl.addElement(3);
        avl.addElement(4);
        System.out.println(BinaryTreePrinter.print(avl.getRoot()));

    }
}
