package miniTwitter;

import java.util.ArrayList;


public class userName extends userComponent implements Observable, Observer{
    
    private String UUID;
    private  ArrayList<Observer> followerList = new ArrayList();
    private  ArrayList following = new ArrayList();
    private  ArrayList newsFeed = new ArrayList();
    private  ArrayList messages = new ArrayList();


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

    public void tweet(String tweet){
        messages.add(tweet);
        notifyFollowers(tweet);
    }

    public ArrayList getTweets(){
        return messages;
    }

    public void addfollower(Observer o){
        followerList.add(o);
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
