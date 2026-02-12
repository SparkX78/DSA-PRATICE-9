public class Recover_tree_preorder {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        static int index = 0;
        public static TreeNode recover(String traversal){
            int n = traversal.length();
            int depth = 0;
            return solve(traversal, depth);

        }
        private static TreeNode solve(String s, int depth){
            int temp = index;
            if(temp >= s.length()){
                return null;
            }
            int dashes = 0;
            while(temp < s.length() && s.charAt(temp) == '-'){
                temp++;
                dashes++;
            }
            index = temp;
            int num = 0;
            while(index < s.length() && Character.isDigit(s.charAt(index))){
                num = (num*10) + (s.charAt(index) - '0');
                index++;
            }
            TreeNode root = new TreeNode(num);
            root.left = solve(s, depth+1);
            root.right = solve(s, depth+1);
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
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root =  TreeNode.recover(traversal);
        root.printPreorder(root);
    }
}
