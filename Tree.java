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

    /**
    * Prints the tree from starting root
    *
    * @param root  the starting node to search from
    */
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

    /**
    * Searches the tree until user is found
    *
    * @param root  the starting node to search from
    * @param id    the key (username) that is being searched for
    */
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
                    return node;
                }
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
        }
        return null;
    }

    /**
    * Return the data object userName
    */
    public userName getUser(){
        if(userC instanceof userName){
            return (userName)userC;
        }
        return null;
    }
}