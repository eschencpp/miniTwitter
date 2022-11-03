package miniTwitter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class userPanel extends JFrame{
    
    private JPanel contentPane;
	private JTextField userTxtField;
	private JTextField message_box;
    String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday","Tuesday","Tuesday",};
                
    private userName user;
	private Tree root;

	JList following_JList;
	JList newsFeed_Jlist;

    public userPanel(userName u, Tree tree){
        user = u;
		root = tree;
        makeGui();
    }

	//Return the user object of this class
	private userName getUser(){
		return user;
	}

    private void makeGui(){
        this.setTitle("User Panel: " + user.getUserName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		followUser();
		
		followerList();
		
		tweetPanel();
		
		newsFeed();

        setVisible(true);
    }

    private void followUser(){
        JPanel follow_panel = new JPanel();
		contentPane.add(follow_panel);
		follow_panel.setLayout(new BoxLayout(follow_panel, BoxLayout.X_AXIS));
		follow_panel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
		
		JPanel userTxt_panel = new JPanel();
		follow_panel.add(userTxt_panel);
		
		userTxtField = new JTextField();
		userTxtField.setText("Enter user");
		userTxt_panel.add(userTxtField);
		userTxtField.setColumns(10);
		
		JPanel followBtn_panel = new JPanel();
		follow_panel.add(followBtn_panel);
		
		JButton followButton = new JButton("Follow User");
		followButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName u = root.findUser(root, userTxtField.getText()).getUser(); //The observable 
				u.addfollower(getUser());

				//Set the following list data and update the UI 
				following_JList.setListData(getUser().getFollowingNames());
				following_JList.updateUI();
			}
		});
		followButton.setPreferredSize(new Dimension(100, 20));
		followBtn_panel.add(followButton);
    }

    private void followerList(){
        JPanel follower_panel;
		follower_panel = new JPanel();
		contentPane.add(follower_panel);
		follower_panel.setLayout(new BoxLayout(follower_panel, BoxLayout.Y_AXIS));

        JPanel ftitle_panel;
		ftitle_panel = new JPanel();
		ftitle_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		follower_panel.add(ftitle_panel);
		ftitle_panel.setLayout(new BoxLayout(ftitle_panel, BoxLayout.X_AXIS));
		
		JLabel followingLabel = new JLabel("Following");
		followingLabel.setFont(new Font("Arial", Font.BOLD, 13));
		ftitle_panel.add(followingLabel);
		
		JPanel flist_panel;
		flist_panel = new JPanel();
		follower_panel.add(flist_panel);
		flist_panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Add JList to scrollpane
		JScrollPane scrollPane = new JScrollPane();
		flist_panel.add(scrollPane);
		following_JList = new JList();
		scrollPane.setViewportView(following_JList);
		following_JList.setFont(new Font("Arial", Font.PLAIN, 12));
		following_JList.setListData(getUser().getFollowingNames());
    }

    private void tweetPanel(){
        JPanel tweet_panel = new JPanel();
		contentPane.add(tweet_panel);
		tweet_panel.setLayout(new BoxLayout(tweet_panel, BoxLayout.X_AXIS));
		tweet_panel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
		
		JPanel msgBox_panel = new JPanel();
		tweet_panel.add(msgBox_panel);
		
		message_box = new JTextField();
		message_box.setHorizontalAlignment(SwingConstants.LEFT);
		msgBox_panel.add(message_box);
		message_box.setColumns(10);
		
		JPanel tweetBtn_panel = new JPanel();
		tweet_panel.add(tweetBtn_panel);
		
		JButton tweetBtn = new JButton("Tweet");
		tweetBtn.setPreferredSize(new Dimension(100, 20));
		tweetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUser().tweet(message_box.getText());
				newsFeed_Jlist.setListData(getUser().getNewsFeed().toArray());
				newsFeed_Jlist.updateUI();
			}
		});
		tweetBtn_panel.add(tweetBtn);
    }

    private void newsFeed(){
        JPanel newsFeed_panel = new JPanel();
		contentPane.add(newsFeed_panel);
		newsFeed_panel.setLayout(new BoxLayout(newsFeed_panel, BoxLayout.Y_AXIS));
		
		JPanel nfTitle_panel = new JPanel();
		newsFeed_panel.add(nfTitle_panel);
		nfTitle_panel.setLayout(new BoxLayout(nfTitle_panel, BoxLayout.X_AXIS));
		nfTitle_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		JLabel newsFeedLbl = new JLabel("News Feed");
		newsFeedLbl.setFont(new Font("Arial", Font.BOLD, 13));
		nfTitle_panel.add(newsFeedLbl);
		
		JPanel nfList_panel = new JPanel();
		newsFeed_panel.add(nfList_panel);
		nfList_panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		nfList_panel.add(scrollPane_1);
		
		newsFeed_Jlist = new JList();
		scrollPane_1.setViewportView(newsFeed_Jlist);
		newsFeed_Jlist.setFont(new Font("Arial", Font.PLAIN, 12));
		newsFeed_Jlist.setListData(getUser().getNewsFeed().toArray());
    }
}
