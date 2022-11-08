package miniTwitter;
import java.util.ArrayList;

public class newsFeed implements Observer {

    private  ArrayList<String> messages;

    public newsFeed(){
        this.messages = new ArrayList<String>();
    }

    @Override
    public void update(String tweet){
        messages.add(tweet);
    }

    public ArrayList<String> getMessages(){
        return messages;
    }
    
}
