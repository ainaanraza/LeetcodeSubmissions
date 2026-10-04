/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exist(TreeNode root, TreeNode node){
        if(node==root) return true;
        if(root==null) return false;
        return exist(root.left,node)|| exist(root.right, node);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root|| q==root) return root;
        boolean pinLST=exist(root.left,p);
        boolean qinLST=exist(root.left,q);
        if(pinLST==true&&qinLST==true) return lowestCommonAncestor(root.left,p,q);
        if(pinLST==false&& qinLST==false) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}