public class BinaryTree {

    //Root node of the tree
    TreeNode root;
    //Number of nodes in the tree
    public int size = 0;

    /*
     * Default Constructor
     */
    public BinaryTree() {
        this.root = null;
    }

    public boolean add(int key) {
        boolean isAdded = false;

        //Add the first node in an empty tree
        if(this.root == null){
            this.root = new TreeNode(key,null);
            size++;
            return isAdded = true;
        }

        //Add leaf node in the tree
        else{
            //Add to right if the node is less than the root
            if(key > this.root.getData()){
                TreeNode child = new TreeNode(key,this.root);
                this.root.setRightNode(child);
                size++;
                return isAdded = true;
            }
            //Add to left if the node is less than the root
            else{
                TreeNode child = new TreeNode(key,this.root);
                this.root.setLeftNode(child);
                size++;
                return isAdded = true;
            }
        }
    }
    public int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }
}
