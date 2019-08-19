import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AVL_Tree<E extends Comparable<E>> {
    private AVL_Tree<E> leftChild;
    private AVL_Tree<E> rightChild;
    private AVL_Tree<E> parent;
    private E data;

    public AVL_Tree(){
        this.parent = null;
    }

    private AVL_Tree(AVL_Tree<E> parent){
        this.parent = parent;
    }


    public AVL_Tree<E> getRoot(){
        AVL_Tree<E> root = this;
        while(root.getParent() != null){
            root = root.getParent();
        }
        return root;
    }

    private void leftLeftRotation(){
        AVL_Tree<E> B = this.getLeftChild();
        this.setLeftChild(B.getRightChild());
        B.setRightChild(this);
        B.setParent(null);
    }

    private void leftRightRotation(){
        AVL_Tree<E> B = this.getLeftChild();
        AVL_Tree<E> C = B.getRightChild();

        B.setRightChild(C.getLeftChild());
        this.setLeftChild(C);
        C.setLeftChild(B);

        this.leftLeftRotation();
    }

    private void rightRightRotation(){
        AVL_Tree<E> B = this.getRightChild();
        this.setRightChild(B.getLeftChild());
        B.setLeftChild(this);
        B.setParent(null);
    }

    private void rightLeftRotation(){
        AVL_Tree<E> B = this.getRightChild();
        AVL_Tree<E> C = B.getLeftChild();

        B.setLeftChild(C.getRightChild());
        C.setRightChild(B);
        this.setRightChild(C);

        this.rightRightRotation();
    }


    private void testBalanceFactors(){
        if(this.getParent() != null && this.getParent().getParent() != null && !this.getParent().getParent().isBalanced()){
            String kindOfRotation = this.getParent().leftOrRightChild() + this.leftOrRightChild();
            AVL_Tree<E> rootOfRotation = this.getParent().getParent();
            System.out.println(Colors.ANSI_RED +  "rotate "  + kindOfRotation + Colors.ANSI_RESET);

            switch(kindOfRotation){
                case "RR":
                    rootOfRotation.rightRightRotation();
                    break;
                case "RL":
                    rootOfRotation.rightLeftRotation();
                    break;
                case "LL":
                    rootOfRotation.leftLeftRotation();
                    break;
                case "LR":
                    rootOfRotation.leftRightRotation();
                    break;
            }
        }
    }

    private String leftOrRightChild(){
        return this.isLeftChild() ? "L" : "R";
    }

    private boolean isLeftChild(){
        if(this.getParent() == null) {
            return false;
        }else{
            return this.getParent().getLeftChild() == this;
        }
    }
    public void addElement(E data){
        this.getRoot().add(data);
    }
    private void add(E data){
        if(this.data == null){
            this.data = data;
            this.testBalanceFactors();
        }else{
            AVL_Tree<E> avl_tree = new AVL_Tree<>(this);
            if(this.data.compareTo(data) < 0){
                if(this.getRightChild() == null) {
                    this.setRightChild(avl_tree);
                }
                this.getRightChild().add(data);
            }else if (this.data.compareTo(data) > 0){
                if(this.getLeftChild() == null){
                    this.setLeftChild(avl_tree);
                }
                this.getLeftChild().add(data);
            }else{
                ;
                // no duplicates!!
                // TODO save amount of element for each node/tree    private void testBalanceFactors(){

            }
        }
    }

    public int getHeight(){
        return getHeight(0);
    }

    protected String getBalanceFactorAsString(){
        String color = this.isBalanced() ?  Colors.ANSI_GREEN : Colors.ANSI_RED;
        return color + this.getBalanceFactor() + Colors.ANSI_RESET;
    }

    protected boolean isBalanced(){
        return Math.abs(this.getBalanceFactor()) < 2;
    }

    private int getBalanceFactor() {
        int leftChildHeight = 0;
        int rightChildHeight = 0;

        if(this.getLeftChild() != null){
            leftChildHeight = this.getLeftChild().getHeight(1);
        }
        if(this.getRightChild() != null){
            rightChildHeight = this.getRightChild().getHeight(1);
        }
        return rightChildHeight - leftChildHeight;
    }

    private int getHeight(int height){
        if(this.getLeftChild() == null && this.getRightChild() == null){
            return height;
        }
        else{
            final int new_height = height + 1;
            if(this.getLeftChild() == null){
                return this.getRightChild().getHeight(new_height);
            }else if(this.getRightChild() == null){
                return this.getLeftChild().getHeight(new_height);
            }else{
                return Math.max(this.getLeftChild().getHeight(new_height), this.getRightChild().getHeight(new_height));
            }
        }
    }

    public int getSize(){
        return this.traverseInOrder().size();
    }


    protected AVL_Tree<E> getLeftChild() {
        return leftChild;
    }

    private void setLeftChild(AVL_Tree<E> leftChild) {

        this.leftChild = leftChild;
        if(this.leftChild != null) {
            this.leftChild.setParent(this);
        }
    }

    protected AVL_Tree<E> getRightChild() {
        return rightChild;
    }

    private void setRightChild(AVL_Tree<E> rightChild) {
        this.rightChild = rightChild;
        if(this.rightChild != null){
            this.rightChild.setParent(this);
        }
    }

    protected E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
    private AVL_Tree<E> getParent() {
        return parent;
    }

    private void setParent(AVL_Tree<E> parent) {
        this.parent = parent;
    }

    protected List<AVL_Tree<E>> traverseInOrder() {
        return this.traverseInOrder(new LinkedList<>());
    }

    private List<AVL_Tree<E>> traverseInOrder(List<AVL_Tree<E>> list) {
        if(getLeftChild() != null) {
            getLeftChild().traverseInOrder(list);
        }

        list.add(this);

        if(getRightChild() != null) {
            getRightChild().traverseInOrder(list);
        }

        return list;
    }

    protected List<E> getElementsInOrder(){
        List<AVL_Tree<E>> allSubTreesInOrder = this.traverseInOrder();
        ArrayList<E> elements = new ArrayList<E>(allSubTreesInOrder.size());
        for(AVL_Tree<E> subTree: allSubTreesInOrder){
            elements.add(subTree.getData());
        }
        return elements;
    }
    @Override
    public String toString() {
        return this.getClass().getName() + " " + this.getElementsInOrder();
    }
}
