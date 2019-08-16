import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;

public class AVLTreeTester{
    private AVL_Tree<Integer> avl_tree = new AVL_Tree<>();

    @Test
    void testSize(){
        final int size = 10;
        for(int i = 0; i < size;i++){
            avl_tree.add(i);
        }
        assertEquals(size, avl_tree.getSize());
    }
    @Test
    void testAdding() throws Exception{
        avl_tree = new AVL_Tree<>();

        avl_tree.add(4);
        avl_tree.add(3);
        avl_tree.add(8);

        assertEquals(avl_tree.traverseInOrder(), Arrays.asList(3, 4, 8));
    }

}
