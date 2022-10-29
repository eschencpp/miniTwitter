package miniTwitter;
import javax.swing.*;
/**
 * adminCPanel
 */
public class adminCPanel {

    private static adminCPanel acp = null;

    private adminCPanel()
    {
       JFrame frame = new JFrame("MiniTwitter");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,800);
       JButton button = new JButton("Press");
       frame.getContentPane().add(button); // Adds Button to content pane of frame
       frame.setVisible(true);
        
    }
    
    public static adminCPanel getInstance()
    {
        if (acp == null)
        acp = new adminCPanel();
  
        return acp;
    }


}