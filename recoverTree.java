/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }else{
                last = root;
            }
        }
        prev = root;
        if(!flag && last != null){
            
        }
        else{
            inorder(root.right);
        }
        
    }
}
