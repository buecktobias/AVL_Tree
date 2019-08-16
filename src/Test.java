public class Test {
    public static void main(String[] args) {
        AVL_Tree<Integer> avl = new AVL_Tree<>();
        avl.add(4);
        avl.add(3);
        avl.add(2);
        avl.add(5);
        avl.add(7);
        avl.add(8);
        System.out.println(avl);
        System.out.println(BinaryTreePrinter.print(avl));
        System.out.println(avl.getHeight());
    }
}
