package setup_binary_search_tree;

public interface Tree<E> {
    boolean insert(E e);

    void inorder();
    void postorder();
    void preorder();
    boolean remove(E e);
    int getSize();
}
