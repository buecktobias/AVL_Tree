import java.util.LinkedList;
import java.util.List;

public class AVL_Tree<E extends Comparable<E>> {
    private AVL_Tree<E> leftChild;
    private AVL_Tree<E> rightChild;
    private E data;
    private short balanceFactor;

    public AVL_Tree(){
    }

    public AVL_Tree(E data){
        this.data = data;
    }

    public void add(E data){
        if(this.data == null){
            this.data = data;
        }else{
            AVL_Tree<E> avl_tree = new AVL_Tree<>(data);
            if(this.data.compareTo(data) <= 0){
                if(this.getRightChild() != null) {
                    this.getRightChild().add(data);
                }else{
                    this.setRightChild(avl_tree);
                }
            }else{
                if(this.getLeftChild() != null){
                    this.getLeftChild().add(data);
                }else{
                    this.setLeftChild(avl_tree);
                }
            }
        }
    }

    public int getHeight(){
        return getHeight(0);
    }
    private int getHeight(int height){
        if(this.getLeftChild() == null && this.getRightChild() == null){
            return height;
        }
        else{
            if(this.getLeftChild() == null){
                return this.getRightChild().getHeight(height + 1);
            }else if(this.getRightChild() == null){
                return this.getLeftChild().getHeight(height + 1);
            }else{
                return Math.max(this.getLeftChild().getHeight(height + 1), this.getRightChild().getHeight(height+1));
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
    }

    protected AVL_Tree<E> getRightChild() {
        return rightChild;
    }

    private void setRightChild(AVL_Tree<E> rightChild) {
        this.rightChild = rightChild;
    }

    protected E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public List<E> traverseInOrder() {
        return this.traverseInOrder(new LinkedList<>());
    }

    private List<E> traverseInOrder(List<E> list) {
        if(getLeftChild() != null) {
            getLeftChild().traverseInOrder(list);
        }

        list.add(this.data);

        if(getRightChild() != null) {
            getRightChild().traverseInOrder(list);
        }

        return list;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + this.traverseInOrder().toString();
    }
}
