package miniTwitter;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.*;

public class driver {
    public static void main(String[] args) {
        userComponent g1 = new userGroup("group1");
        userName p1 = new userName("Eric");
        userName p2 = new userName("Bill");
        

        adminCPanel acm = adminCPanel.getInstance();
        
        System.out.println("Clicked");
    }
}
