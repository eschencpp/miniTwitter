package miniTwitter;
import java.util.ArrayList;

public class newsFeed implements Observer {

    private  ArrayList<String> messages;

    public newsFeed(){
        this.messages = new ArrayList<String>();
    }

    //Add messages to newsfeed
    @Override
    public void update(String tweet){
        messages.add(tweet);
    }

    //Return the messages in user's newsfeed
    public ArrayList<String> getMessages(){
        return messages;
    }

    /** 
     * Count the number of messages in the user's newsfeed
     * @return The count of all messages
    */
    public int countMessages(){
        return messages.size();
    }

    /** 
     * Count the number of positive messages in the user's newsfeed
     * @return The count of positive messages
    */
    public int countPositiveMessages(){
        int posMsg = 0;
        String[] positiveWords = {"good","great","nice","happy"};
        for(int i = 0; i < messages.size(); i++){
            for(int k = 0; k < positiveWords.length; k++){
                if(this.messages.get(i).contains(positiveWords[k])){
                    posMsg++;
                }
            }
        }
        return posMsg;
    }
    
}
