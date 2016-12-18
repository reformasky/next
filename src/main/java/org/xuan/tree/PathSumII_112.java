package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class PathSumII_112 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, sum, path, result);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        int tmp = sum - root.val;
        if (root.left != null) {
            dfs(root.left, tmp, path, result);
        }
        if (root.right != null) {
            dfs(root.right, tmp, path, result);
        }
        if (root.left == null && root.right == null && tmp == 0) {
            result.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);

    }
}
