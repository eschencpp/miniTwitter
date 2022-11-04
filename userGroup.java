package miniTwitter;
import java.util.ArrayList;
import java.util.Iterator;

public class userGroup extends userComponent{

    private String groupName;
    private  ArrayList<userComponent> userComponents = new ArrayList();

    public userGroup(String newGroupName){
        groupName = newGroupName;
    }

    //Get group name
    @Override
    public String getGroupName() {
        return groupName;
    }

    //Add a user or group
    @Override
    public void add(userComponent newUserComponent) {
        userComponents.add(newUserComponent);
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
