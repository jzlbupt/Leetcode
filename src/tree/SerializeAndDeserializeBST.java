package tree;

/**
 * Created by ziljin on 06/09/2017.
 */

import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary search tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
 You just need to ensure that a binary search tree can be serialized to a string and
 this string can be deserialized to the original tree structure.

 The encoded string should be as compact as possible.

 Note: Do not use class member/global/static variables to store states.
 Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> preOrder =  preOrder(root);
        StringBuilder sb = new StringBuilder();
        preOrder.forEach(i -> sb.append(i).append(","));
        return sb.toString().substring(0, sb.length()-1);
    }
    private List<Integer> preOrder(TreeNode root) {
        LinkedList<Integer> rst = new LinkedList<Integer>();
        if(root == null) return rst;
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        toVisit.push(root);
        while(!toVisit.isEmpty()) {
            TreeNode node = toVisit.pop();
            rst.add(node.val);
            if(node.right != null) toVisit.push(node.right);
            if(node.left != null) toVisit.push(node.left);
        }
        return rst;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preOrder = data.split(",");
        List<Integer> pre = new ArrayList<Integer>();
        for(int i=0; i<preOrder.length; i++) {
            pre.add(Integer.valueOf(preOrder[i]));
        }
        List<Integer> in = new ArrayList<Integer>(pre);
        Collections.sort(in);
        TreeNode rst = buildTree(pre, in, 0, pre.size()-1, 0, in.size() -1);
        return rst;
    }

    private TreeNode buildTree(List<Integer> pre, List<Integer> in, int ps, int pe, int is, int ie) {
        if(ps > pe) return null;
        TreeNode root = new TreeNode(pre.get(ps));
        int rootIndex = is;

        while(pre.get(ps) != in.get(rootIndex) && rootIndex <=ie){
            rootIndex ++;
        }
        root.left = buildTree(pre, in, ps+1, ps + rootIndex-is, is, rootIndex -1);
        root.right = buildTree(pre, in, ps + rootIndex-is+1, pe, rootIndex+1, ie);
        return root;
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(4);
        String rst = new SerializeAndDeserializeBST().serialize2(node);
        System.out.println(rst);
        TreeNode root = new SerializeAndDeserializeBST().deserialize2(rst);
        System.out.println(rst);
    }

    // try another way to slove the problem...
    public static final String NULL="null";
    public static final String SEP=",";
    public String serialize2(TreeNode root) {
        if(root == null) return NULL;
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(SEP);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return sb.toString();
    }

    public TreeNode deserialize2(String data) {
        if(data.equals(NULL)) return null;
        String[] vals = data.split(SEP);
        Queue<Integer> nodes = new LinkedList<>();
        for(String val : vals) {
            nodes.offer(Integer.valueOf(val));
        }
        return getRoot(nodes);
    }

    private TreeNode getRoot(Queue<Integer> nodes) {
        if(nodes.isEmpty()) return null;
        TreeNode root = new TreeNode(nodes.poll());
        Queue<Integer> smallerNodes = new LinkedList<>();
        while(!nodes.isEmpty() && nodes.peek() < root.val) {
            smallerNodes.offer(nodes.poll());
        }
        root.left = getRoot(smallerNodes);
        root.right = getRoot(nodes);
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
