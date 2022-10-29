package miniTwitter;

public class driver {
    public static void main(String[] args) {
        userGroup g1 = new userGroup("group1");
        userName g2 = new userName("Eric");
        userGroup g3 = new userGroup("group2");
        
        g1.add(g2);
        g1.add(g3);
        g3.add(g2);
        g1.displayDetails();
        
    }
}
