package miniTwitter;
import javax.swing.*;

public class driver {
    public static void main(String[] args) {
        userComponent g1 = new userGroup("group1");
        userName p1 = new userName("Eric");
        userName p2 = new userName("Bill");
        
        g1.add(p1);
        g1.add(p2);
        
        p1.addfollower(p2);
        p1.tweet("Hello World");
        System.out.println(p2.getNewsFeed().toString());

        //adminCPanel acm = adminCPanel.getInstance();
        //g3.displayDetails();
        
    }
}
