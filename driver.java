package miniTwitter;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Arrays;
import java.awt.*;

public class driver {
    public static void main(String[] args) {

        adminCPanel acm = adminCPanel.getInstance();

        userName Eric = new userName("Eric");
        userName Bill = new userName("Bill");
        userName Steve = new userName("Steve");
        userName Jerry = new userName("Jerry");

        Eric.addfollower(Steve);
        Bill.addfollower(Steve);
        Jerry.addfollower(Steve);

        for(int i = 0; i < Steve.getFollowing().size(); i++){
            userName u = Steve.getFollowing().get(i);
            System.out.println(u.getUserName());
        }
    }
}
