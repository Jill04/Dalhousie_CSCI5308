
    /**
     * The TreeNode class stores the information about each node in the tree
     *
     */
    public class TreeNode {

        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int data;


        //A default constructor that creates an empty node.
        public TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
        //Parameterized constructor to store the parent and item of the node.
        public TreeNode(int data, TreeNode parent) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }
        /**
         * Returns the item of the node
         *
         * @return           int
         */
        public int getData() {
            return this.data;
        }

        /**
         * Returns the left node
         *
         * @return           TreeNode
         */
        public TreeNode getLeftNode() {
            return this.left;
        }

        /**
         * Returns the right node
         *
         * @return           TreeNode
         */
        public TreeNode getRightNode() {
            return this.right;
        }

        /**
         * Returns the parent node
         *
         * @return           TreeNode
         */
        public TreeNode getParent() {
            return this.parent;
        }

        /**
         * Sets the left node
         *
         * @param   left	  Left Tree Node
         * @return           TreeNode
         */
        public void setLeftNode(TreeNode left) {
            this.left = left;
        }

        /**
         * Sets the right node
         *
         * @param   right	  Right Tree Node
         * @return           TreeNode
         */
        public void setRightNode(TreeNode right) {this.right = right;}
    }

