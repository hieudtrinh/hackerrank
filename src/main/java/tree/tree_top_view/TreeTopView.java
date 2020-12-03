package tree.tree_top_view;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeTopView {
    static class WrapperNode {
        TreeNode node;
        int pos;
        public WrapperNode(TreeNode node, int pos){
            this.node = node;
            // position which determine the order within the queue,
            // which represent the top view
            this.pos = pos;
        }
    }

    public void topView(TreeNode root) {
        //took a queue - similar to BFS approach
        Queue<WrapperNode> queue = new LinkedList<>();

        //Taking a TreeMap<first, second>
        //first - stores the level of the node
        //second - stores the node.data
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //why TreeMap? Because I want the nodes to be sorted from leftmost to rightmost

        //start (since root, level = 0)
        queue.add(new WrapperNode(root, 0));

        while(!queue.isEmpty()){
            //remove element from queue
            WrapperNode w = queue.poll();
            //if the level of this node has never been reached before -> visible in top view
            if(!map.containsKey(w.pos)){
                map.put(w.pos, w.node.val);
            }

            //add node's descendants
            //all left child node levels = node.level - 1
            //all right child node levels = node.level + 1
            if(w.node.left != null){
                queue.add(new WrapperNode(w.node.left, w.pos - 1));
            }
            if(w.node.right != null){
                queue.add(new WrapperNode(w.node.right, w.pos + 1));
            }
        }
        //since already sorted (cuz TreeMap), print from left to right
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
    }
}
