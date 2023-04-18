package setup_binary_search_tree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    @Override
    public boolean remove(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean isLeftChild = true;
        if (e.equals(root.element)) {
            parent = root;
            replace(parent,current,isLeftChild);
            root = root.left;
        }
        while (current != null) {
            if (e.equals(current.element)) {
                break;
            } else if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        if (current == null) {
            return false;
        } else {
            replace(parent, current, isLeftChild);
            return true;
        }
    }

    private void replace(TreeNode<E> parent, TreeNode<E> current, boolean isLeftChild) {
        if (current.left == null) {
            if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            TreeNode<E> rightMost = current.left;
            TreeNode<E> parentOfRightMost = current;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            if (!parentOfRightMost.equals(current)) {
                parentOfRightMost.right = rightMost.left;
                rightMost.left = current.left;
                if (isLeftChild) {
                    parent.left = rightMost;
                } else {
                    parent.right = rightMost;
                }
            }else {
                if (isLeftChild) {
                    parent.left = rightMost;
                } else {
                    parent.right = rightMost;
                }
                rightMost.right = current.right;
            }
        }
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
