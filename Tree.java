public class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public Tree() {
        root = null;
    }

    public void insertNode(E insertValue) {
        System.out.print(insertValue + " ");    
        if (root == null) {
            root = new TreeNode<E>(insertValue);   
        } else {
            root.insert(insertValue);
        }
    }

    private void preorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;   
        }

        System.out.printf("%s ", node.getData());  
        preorderHelper(node.getLeftNode());    
        preorderHelper(node.getRightNode());    
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void inorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.getLeftNode());      
        System.out.printf("%s ", node.getData());       
        inorderHelper(node.getRightNode());     
    }

    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void postorderHelper(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.getLeftNode());    
        postorderHelper(node.getRightNode());
        System.out.printf("%s ", node.getData());     
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }


    private boolean searchBSTHelper(TreeNode<E> node, E key) {
        boolean result = false;

        if (node != null) {
            if (key.equals(node.getData())) {
                result = true;
            } else if (key.compareTo(node.getData()) < 0) {
                result = searchBSTHelper(node.getLeftNode(), key);
            } else {
                result = searchBSTHelper(node.getRightNode(), key);
            }
        }
        return result;
    }

    public void searchBST(E key) {
        boolean hasil = searchBSTHelper(root, key);

        if (hasil) {
            System.out.println("Data " + key + " ditemukan pada tree");
        } else {
            System.out.println("Data "+ key + " tidak ditemukan pada tree");
        }
    }


}
