package miniTwitter;

import java.util.LinkedList;
import java.util.Queue;

public class findUserCompVisitor implements componentVisitor {

    public Tree visit(Tree root,userName userName){
        if(root == null) return null;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Tree node = queue.poll();
                assert node != null;
                if(node.uid.equals(userName.getUserName())){
                    return node;
                }
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
        }
        return null;
    }

    public Tree visit(Tree root,userGroup userGroup){
        if(root == null) return null;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                Tree node = queue.poll();
                assert node != null;
                if(node.uid.equals(userGroup.getGroupName())){
                    return node;
                }
                for (Tree item : node.children) {
                    queue.offer(item);
                }
            }
        }
        return null;
    }
    
}