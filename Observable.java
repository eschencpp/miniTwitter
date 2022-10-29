package miniTwitter;

public interface Observable {
    
    public void addfollower(Observer o);
    public void unfollow(Observer o);
    public void notifyFollowers();
}
