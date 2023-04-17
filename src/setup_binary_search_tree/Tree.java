package setup_binary_search_tree;

public interface Tree<E> {
    public boolean insert(E e);

    public void inorder();
    public void postorder();
    public void preorder();
    public int getSize();
}
