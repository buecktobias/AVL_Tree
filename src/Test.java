import java.util.Random;

public class Test {
    private static void addRandomElement(AVL_Tree<Integer> avl_tree){
        avl_tree.addElement(new Random().nextInt(100));
    }
    public static void main(String[] args) {
        AVL_Tree<Integer> avl = new AVL_Tree<>();
        for(int i = 0; i < 20; i++){
            Test.addRandomElement(avl);
        }
        System.out.println(BinaryTreePrinter.print(avl.getRoot()));

    }
}
