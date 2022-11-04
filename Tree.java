package miniTwitter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    
    String uid;
    List<Tree> children = new LinkedList<>();
    public userComponent userC;
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
     * Count the total number of messages sent from all users in index 0 and 
     * the count of positive messages in index 1
     * @param root node to start traversal
     * @return the total number of messages from all users starting from root
    */
    public int[] countMsg(Tree root){
        int msgCount = 0;
        int posMsg = 0;
        int[] c = new int[2];
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Tree node = queue.poll();
                assert node != null;
                if(node.userC instanceof userName){
                    msgCount += node.getUser().getTweets().size();
                    posMsg += node.getUser().getPositive();
                }
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
        }
        c[0] = msgCount;
        c[1] = posMsg;
        return c;
    }

    public userComponent getUserComponent(){
        return userC;
    }

    public Tree accept(componentVisitor visitor, userComponent userComp){

        if(userComp instanceof userName){
            return visitor.visit(this, (userName)(userComp));
        }
        return visitor.visit(this, (userGroup)(userComp));
    }
}