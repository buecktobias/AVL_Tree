import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AVLTreeTester{
    private AVL_Tree<Integer> avl_tree = new AVL_Tree<>();
    private Random r = new Random();
    @Test
    void testSize(){
        AVL_Tree<Integer> avl_tree = new AVL_Tree<>();
        final int size = 10;
        for(int i = 0; i < size;i++){
            avl_tree.addElement(i);
        }
        assertEquals(size, avl_tree.getRoot().getSize());
    }

    @Test
    void testaddElementing() throws Exception{
        AVL_Tree<Integer> avl_tree = new AVL_Tree<>();

        avl_tree.addElement(8);
        avl_tree.addElement(4);
        avl_tree.addElement(3);

        assertEquals(avl_tree.getRoot().getElementsInOrder(), Arrays.asList(3, 4, 8));
    }
    void addElementRandomElementToAVLTree(AVL_Tree<Integer> avl_tree){
        avl_tree.addElement(this.r.nextInt());
    }


    @Test
    void testRotation(){
        AVL_Tree<Integer> avlTree = new AVL_Tree<>();
        for(int i = 0; i < 100; i++){
            this.addElementRandomElementToAVLTree(avlTree);
        }
        List<AVL_Tree<Integer>> allSubTrees = avlTree.traverseInOrder();
        for(AVL_Tree<Integer> avlSubTree:allSubTrees){
            assertTrue(avlSubTree.isBalanced());
        }
    }

}
