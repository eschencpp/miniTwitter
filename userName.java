package miniTwitter;

import java.util.ArrayList;


public class userName extends userComponent {
    
    private String UUID;
    private  ArrayList followerList = new ArrayList();
    private  ArrayList following = new ArrayList();
    private  ArrayList newsFeed = new ArrayList();

    public userName(String username){
        this.UUID = username;
    }
    
    public String getUserName(){
        return UUID;
    }
    
    public ArrayList getFollowerList() {
        return followerList;
    }

    public ArrayList getFollowing() {
        return following;
    }

    public ArrayList getNewsFeed() {
        return newsFeed;
    }

    public void displayDetails(){
        System.out.println(this.UUID);
    }


}
