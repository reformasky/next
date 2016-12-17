package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/15/16.
 */
public class GenerateTrees_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[][] cache = (List<TreeNode>[][]) new List[n][n];
        for(int i = 0; i < n; i++) {
            List<TreeNode> curr = new ArrayList<>();
            curr.add(new TreeNode(i + 1));
            cache[i][i] = curr;
        }
        for(int diff = 1; diff < n; diff++) {
            for(int left = 0; left < n - diff; left++) {
                int right = left + diff;
                List<TreeNode> curr = new ArrayList<>();
                for(int r = left; r <= right; r++) {
                    List<TreeNode> small = (r > left) ? cache[left][r - 1] : null,
                            large = (r < right) ? cache[r + 1][right] : null;
                    if (small == null) {
                        for(TreeNode largeNode : large) {
                            TreeNode root = new TreeNode(r + 1);
                            root.right = largeNode;
                            curr.add(root);
                        }
                    } else if (large == null) {
                        for(TreeNode smallNode : small) {
                            TreeNode root = new TreeNode(r + 1);
                            root.left = smallNode;
                            curr.add(root);
                        }
                    } else {
                        for(TreeNode smallNode : small) {
                            for(TreeNode largeNode : large) {
                                TreeNode root = new TreeNode(r + 1);
                                root.left = smallNode;
                                root.right = largeNode;
                                curr.add(root);
                            }
                        }
                    }
                }
                cache[left][right] = curr;
            }
        }
        return cache[0][n - 1];
    }
}
