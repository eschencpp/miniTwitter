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

    public int countMessages(){
        return messages.size();
    }

    public int countPositiveMessages(){
        int posMsg = 0;
        String[] positiveWords = {"good","great","nice"};
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
