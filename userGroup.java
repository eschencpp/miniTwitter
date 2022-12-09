package miniTwitter;
import java.util.ArrayList;

public class userGroup extends userComponent{

    private String UID;
    private  ArrayList<userComponent> userComponents = new ArrayList();

    public userGroup(String newGroupName){
        UID = newGroupName;
        this.setCreationTime(System.currentTimeMillis());
    }

    @Override
    public String getUID(){
        return UID;
    }

    //Remove a user or group
    @Override
    public void remove(userComponent removeUserComponent) {
        userComponents.remove(removeUserComponent);
    }

    //Gets one specific node
    @Override
    public userComponent getComponent(int componentIndex) {
        return userComponents.get(componentIndex);
    }
    
}
