package miniTwitter;
import java.util.ArrayList;
import java.util.List;

public class userName extends userComponent implements Observable{
    
    private String UID;
    private  ArrayList<Observer> observerList = new ArrayList();
    private  ArrayList<userName> following = new ArrayList();
    private newsFeed newsFeed = new newsFeed();
    private  ArrayList<String> messages = new ArrayList<String>();


    public userName(String username){
        this.UID = username;
        this.attach(newsFeed);
    }
    
    //Returns the username
    public String getUID(){
        return UID;
    }
    
    //Returns the list of followers
    public ArrayList getObserverList() {
        return observerList;
    }

    //Returns the list of users that are being followed
    public ArrayList<userName> getFollowing() {
        return following;
    }

    //Get list of names that user is following
    public String[] getFollowingNames(){
        String[] s = new String[100]; //Max Capacity 100
        for(int i = 0; i < following.size(); i++){
            s[i] = this.following.get(i).getUID();
        }
        return s;
    }

    //Return the user's newsfeed
    public newsFeed getNewsFeed() {
        return newsFeed;
    }

    //Add tweet to user and notify observers
    public void tweet(String tweet){
        this.messages.add(tweet);
        notifyFollowers(tweet);
    }

    //Returns the tweets that the user has made
    public ArrayList<String> getTweets(){
        return this.messages;
    }

    //Add other userNames to following list
    public void follow(userName user){
        this.following.add(user);
    }

    //Add observers
    public void attach(Observer o){
        observerList.add(o);
    }

    public void detach(Observer o){
        observerList.remove(o);
    }

    //Update followers when tweet posted
    public void notifyFollowers(String tweet){
        for(Observer follower : observerList){
            follower.update("From "+ this.UID + ":    " + tweet);
        }   
    }
}
