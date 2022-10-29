package miniTwitter;

public abstract class userComponent {

    public void add(userComponent newUserComponent){

    }

    public void remove(userComponent newUserComponent){
        
    }

    public userComponent getComponent(int componentIndex){
        throw new UnsupportedOperationException();
    }

    public String getUserName(){
        throw new UnsupportedOperationException();

    }

    public String getGroupName(){
        throw new UnsupportedOperationException();

    }

    public void displayDetails(){
        throw new UnsupportedOperationException();

    }

    
}
