public class Convert_preorderto_binarytree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    
        public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            return solve(preorder, postorder, 0, 0, n-1);
        }
        private static TreeNode solve(int[] preorder, int[] postorder, int preStart, int postStart, int preEnd){
        
            if(preStart > preEnd){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
        
            if(preStart == preEnd){
                return root;
            }
            int nextNode = preorder[preStart+1];
            int j = postStart;
            while(postorder[j] != nextNode){
                j++;
            }
            int num_of_nodes = j- postStart +1;
            root.left = solve(preorder, postorder, preStart+1, postStart, preStart+num_of_nodes);
            root.right = solve(preorder, postorder, preStart+num_of_nodes+1, j+1, preEnd);
            return root;
        }
        public static void printPreorder(TreeNode root){
            if(root == null) return;
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }


    }
    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        TreeNode root = TreeNode.constructFromPrePost(preorder, postorder);
        root.printPreorder(root);
    }
}

