package miniTwitter;

import java.util.ArrayList;
import java.util.List;


public class userName extends userComponent implements Observable, Observer{
    
    private String UUID;
    private  ArrayList<Observer> followerList = new ArrayList();
    private  ArrayList<userName> following = new ArrayList();
    private  ArrayList newsFeed = new ArrayList();
    private  ArrayList messages = new ArrayList();


    public userName(String username){
        this.UUID = username;
    }
    
    //Returns the username
    public String getUserName(){
        return UUID;
    }
    
    //Returns the list of followers
    public ArrayList getFollowerList() {
        return followerList;
    }

    //Returns the list of users that are being followed
    public ArrayList<userName> getFollowing() {
        return following;
    }

    public String[] getFollowingNames(){
        String[] s = new String[20]; 
        for(int i = 0; i < following.size(); i++){
            s[i] = this.following.get(i).getUserName();
        }

        return s;
    }

    //Returns messages from the user and their following list
    public ArrayList getNewsFeed() {
        return newsFeed;
    }

    public void displayDetails(){
        System.out.println(this.UUID);
    }

    public void tweet(String tweet){
        this.newsFeed.add("From "+ this.UUID + ":    " + tweet);
        notifyFollowers(tweet);
    }

    //Returns the tweets that the user has made
    public ArrayList getTweets(){
        return messages;
    }

    public void addfollower(Observer o){
        followerList.add(o);
        if(o instanceof userName){
            userName u = (userName)o;
            u.following.add(this);
            System.out.println(u.following.size());
        }
    }
    public void unfollow(Observer o){
        followerList.remove(o);
    }
    public void notifyFollowers(String tweet){
        for(Observer follower : followerList){
            follower.update(tweet);
        }   
    }

    public void update(String tweet){
        newsFeed.add(tweet);
    }


}
