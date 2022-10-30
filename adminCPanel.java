package miniTwitter;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Font;
/**
 * adminCPanel
 */
public class adminCPanel extends JFrame {

    private static adminCPanel acp = null;

    private adminCPanel(){ 
        makeGui();
    }
    
    public static adminCPanel getInstance()
    {
        if (acp == null)
        acp = new adminCPanel();
  
        return acp;
    }


    public void makeGui() {

        JPanel contentPane;
        JTextField textField;
        JTextField textField_1;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.setPreferredSize(new Dimension(200, 25));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Group");
		btnNewButton_1.setPreferredSize(new Dimension(200, 25));
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton btnNewButton_2 = new JButton("Open User View");
		btnNewButton_2.setPreferredSize(new Dimension(300, 25));
		panel_3.add(btnNewButton_2);
	
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton btnNewButton_3 = new JButton("Show User Total");
		btnNewButton_3.setPreferredSize(new Dimension(200, 25));
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Show Group Total");
		btnNewButton_4.setPreferredSize(new Dimension(200, 25));
		panel_4.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton btnNewButton_5 = new JButton("Show Messages Total");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setPreferredSize(new Dimension(200, 25));
		panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Show Positive Percentage");
		btnNewButton_6.setPreferredSize(new Dimension(200, 25));
		panel_5.add(btnNewButton_6);
		
		JPanel panel_6 = new JPanel();
		splitPane.setLeftComponent(panel_6);
		
		JTree tree = new JTree();
		panel_6.add(tree);

        setVisible(true);
	}    

}