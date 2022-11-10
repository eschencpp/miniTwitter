package miniTwitter;

public abstract class userComponent  {
    private String UID;
   
    public String getUID(){
        return UID;
    }

    public userComponent getComponent(int componentIndex){
        throw new UnsupportedOperationException();
    }

}
