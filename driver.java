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


        userGroup rootGroup = new userGroup("root");
	    Tree root = new Tree("root", rootGroup);

        // root.children.add(new Tree(Eric.getUserName(),Eric));
        // root.children.add(new Tree(Bill.getUserName(),Bill));

        // findUserCompVisitor findVisitor = new findUserCompVisitor();
        // if(root.accept(findVisitor, Eric) instanceof userName){
        //     System.out.println("yessss");
        // } 
        // userName b = (userName)root.accept(findVisitor, Eric);
        // System.out.println(b.getUserName());

        
    }
}
