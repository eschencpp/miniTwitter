package miniTwitter;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * adminCPanel
 */
public class adminCPanel extends JFrame {

    private static adminCPanel acp = null;
	DefaultMutableTreeNode root, parent, child, node;
	JTree tree;
    
	userGroup rootG = new userGroup("root");
	Tree root2 = new Tree("root", rootG);
	

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
        JTextField userTxtField;
        JTextField groupTxtField;
        this.setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane);
		
        JPanel tree_Panel = new JPanel();
		splitPane.setLeftComponent(tree_Panel);

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
        //Jtree
		root = new DefaultMutableTreeNode("root");
		tree = new JTree(root);
		//Add tree to panel
		tree_Panel.add(tree);
		

		//Panel to add user
        JPanel user_Panel = new JPanel();
		panel.add(user_Panel);
		user_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

		//Text field to add user
		userTxtField = new JTextField();
		user_Panel.add(userTxtField);
		userTxtField.setColumns(10);
		
		//Button for adding user
		JButton addUser_button = new JButton("Add User");
		addUser_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Element that cursor selected in JTree
				DefaultMutableTreeNode selectedElement 
   					=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
				parent = selectedElement;

				//Backend functionality
				userName username = new userName(userTxtField.getText());
				if(root2.findUser(root2,parent.toString()).userC instanceof userGroup ){
					root2.findUser(root2,parent.toString()).children.add(new Tree(userTxtField.getText(),username));
				}else{
					System.out.println("Error can not add user to user.");
					return;
				}

				//Update UI
				child = new DefaultMutableTreeNode(userTxtField.getText());
				parent.add(child);
				System.out.println(parent.toString());
				tree.updateUI();
			}
		});

        addUser_button.setPreferredSize(new Dimension(200, 25));
		user_Panel.add(addUser_button);
		
		//Panel for adding group
		JPanel group_Panel = new JPanel();
		panel.add(group_Panel);
		group_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		groupTxtField = new JTextField();
		group_Panel.add(groupTxtField);
		groupTxtField.setColumns(10);
		
		JButton addGroup_button = new JButton("Add Group");
		addGroup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				root2.printNAryTree(root2);
			}
		});
		addGroup_button.setPreferredSize(new Dimension(200, 25));
		group_Panel.add(addGroup_button);
		
		JPanel userView_Panel = new JPanel();
		panel.add(userView_Panel);
		userView_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton openUserView_button = new JButton("Open User View");
		openUserView_button.setPreferredSize(new Dimension(300, 25));
		userView_Panel.add(openUserView_button);
	
		
		JPanel total_Panel = new JPanel();
		panel.add(total_Panel);
		total_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton userTotal_button = new JButton("Show User Total");
		userTotal_button.setPreferredSize(new Dimension(200, 25));
		total_Panel.add(userTotal_button);
		
		JButton groupTotal_button = new JButton("Show Group Total");
		groupTotal_button.setPreferredSize(new Dimension(200, 25));
		total_Panel.add(groupTotal_button);
		
		JPanel message_Panel = new JPanel();
		panel.add(message_Panel);
		message_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		
		JButton messageTotal_button = new JButton("Show Messages Total");
		messageTotal_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		messageTotal_button.setPreferredSize(new Dimension(200, 25));
		message_Panel.add(messageTotal_button);
		
		JButton posTotal_button = new JButton("Show Positive Percentage");
		posTotal_button.setPreferredSize(new Dimension(200, 25));
		message_Panel.add(posTotal_button);
	
		

        setVisible(true);
	}    



}