package miniTwitter;

import java.util.ArrayList;
import java.util.List;


public class userName extends userComponent implements Observable{
    
    private String UUID;
    private  ArrayList<Observer> observerList = new ArrayList();
    private  ArrayList<userName> following = new ArrayList();
    private newsFeed newsFeed = new newsFeed();
    private  ArrayList<String> messages = new ArrayList<String>();


    public userName(String username){
        this.UUID = username;
        this.attach(newsFeed);
    }
    
    //Returns the username
    public String getUserName(){
        return UUID;
    }
    
    //Returns the list of followers
    public ArrayList getobserverList() {
        return observerList;
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


    public newsFeed getNewsFeed() {
        return newsFeed;
    }


    public void tweet(String tweet){
        this.messages.add(tweet);
        notifyFollowers(tweet);
    }

    //Returns the tweets that the user has made
    public ArrayList<String> getTweets(){
        return this.messages;
    }

    public int getPositive(){
        int pMsg = 0;
        String[] positiveWords = {"good","great","nice"};
        for(int i = 0; i < this.messages.size(); i++){
            for(int k = 0; k < positiveWords.length; k++){
                if(this.messages.get(i).contains(positiveWords[k])){
                    pMsg++;
                }
            }
        }
        return pMsg;
    }

    public void follow(userName user){
        this.following.add(user);
    }

    public void attach(Observer o){
        observerList.add(o);
    }

    public void detach(Observer o){
        observerList.remove(o);
    }

    public void notifyFollowers(String tweet){
        for(Observer follower : observerList){
            follower.update("From "+ this.UUID + ":    " + tweet);
        }   
    }

}
