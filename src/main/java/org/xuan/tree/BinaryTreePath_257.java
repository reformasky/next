package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 1/6/17.
 */
public class BinaryTreePath_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, new ArrayList<Integer>());
        return result;
    }

    private void dfs(TreeNode root, List<String> result, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i) + "->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
        } else {
            if (root.left != null) {
                dfs(root.left, result, path);
            }
            if (root.right != null) {
                dfs(root.right, result, path);
            }
        }

        path.remove(path.size() - 1);
    }
}
