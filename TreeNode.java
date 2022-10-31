package miniTwitter;

import java.util.ArrayList;

public class TreeNode<T> {

    T data;
    TreeNode<T> parent;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<TreeNode<T>>();
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }


}
