package setup_binary_search_tree;

public class TestBST {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        tree.insert("Bani");
        tree.insert("Fan");
        tree.insert("Emi");
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
//        System.out.println("Postorder: ");
//        tree.postorder();
//        tree.preorder();
        tree.remove("Emi");
        tree.inorder();
    }
}
