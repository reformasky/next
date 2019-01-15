package org.xuan.tree;

import org.xuan.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhou2 on 2/21/17.
 */
public class PathSumIII_437 {
    public int pathSum_dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = root.val == sum ? 1 : 0;
        return result + pathSum_dfs(root.left, sum) + pathSum_dfs(root.right, sum) +
                next(root.left, sum - root.val) + next(root.right, sum - root.val);
    }

    public int next(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = root.val == sum ? 1 : 0;
        return result +  next(root.left, sum - root.val) + next(root.right, sum - root.val);
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }

    private int dfs(TreeNode root, int sum, int pathSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        pathSum += root.val;
        int result = map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        result += dfs(root.left, sum, pathSum, map) + dfs(root.right, sum, pathSum, map);
        map.put(pathSum, map.getOrDefault(pathSum, 0) - 1);
        return result;
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.fromList(new Integer[]{1, -1, null, 1,null, - 1, null, 1, null, -1});
        int count = new PathSumIII_437().pathSum(node, 0);
        System.out.print(count);
    }
}
