package miniTwitter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    
    String uid;
    List<Tree> children = new LinkedList<>();
    userComponent userC;
    Tree(String userid, userComponent component){
        uid = userid;
        userC = component;
    }

    public void printNAryTree(Tree root){
        if(root == null) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Tree node = queue.poll();
                assert node != null;
                System.out.print(node.uid + " ");
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }

    public Tree findUser(Tree root, String id){
        if(root == null) return null;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Tree node = queue.poll();
                assert node != null;
                if(node.uid.equals(id)){
                    //System.out.println("Returning node " + id);
                    return node;
                }
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
        return null;
    }
}