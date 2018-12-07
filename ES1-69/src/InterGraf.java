import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import com.restfb.Facebook;

import Mail.*;
import Twitter.tudoTwitter;
import Facebook.searchFacebook;
import Facebook.shareFacebook;
import twitter4j.Twitter;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JToggleButton;

public class InterGraf extends JFrame {

	private JPanel contentPane;
	private static JTextField txtSearch;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private DefaultListModel<String> listMailModel = new DefaultListModel<>();
	private DefaultListModel<String> listaTwitterModel = new DefaultListModel<>();
	private tudoTwitter tweet;
	private tudoTwitter tweet1;
	private searchFacebook face;
	private shareFacebook face1;
	private searchMail maill;
	private shareMail mail1;
	//private shareMail enviarMail;
	//	private searchT twittter;
	private String search;
	private String user;
	private String pass;

	private String messagePostTweet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					InterGraf frame = new InterGraf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterGraf() {

		setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		setForeground(Color.WHITE);
		setTitle("ISCTE_APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		txtSearch = new JTextField();
		txtSearch.setText("\r\n");
		txtSearch.setBackground(SystemColor.inactiveCaptionBorder);
		txtSearch.setToolTipText("Search");
		txtSearch.setBounds(552, 66, 425, 25);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		search = txtSearch.getText();

		ArrayList<JToggleButton> tougle = new ArrayList<>();

		JToggleButton twitter = new JToggleButton("Twitter");
		twitter.setBounds(57, 125, 379, 91);
		contentPane.add(twitter);
		twitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(twitter.isSelected()) {
					tougle.add(twitter);
				}
				else{
					tougle.remove(twitter);
				}
			}
		});
		contentPane.add(twitter);

		JToggleButton facebook = new JToggleButton("Facebook");
		facebook.setBounds(57, 245, 379, 100);
		facebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(facebook.isSelected()) {
					tougle.add(facebook);
				}
				else{
					tougle.remove(facebook);
				}
			}
		});
		contentPane.add(facebook);

		JToggleButton mail = new JToggleButton("Mail");
		mail.setBounds(57, 374, 379, 91);
		mail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mail.isSelected()) {
					tougle.add(mail);
				}
				else{
					tougle.remove(mail);
				}
			}
		});
		contentPane.add(mail);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(57, 66, 379, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtSearch!=null) {
					for(JToggleButton j : tougle) {

						if(j.equals(mail)) {
							user = JOptionPane.showInputDialog("User:");
							pass = JOptionPane.showInputDialog("Password:");


							maill = new searchMail();
							searchMail.connectMail(user, pass, getSearch());
							for(String m : searchMail.getMailList()) {
								listModel.addElement(m);
							}


						}

						if(j.equals(facebook)) {
							face = new searchFacebook();
							searchFacebook.connect(getSearch());
							//searchF.setSearch(search);

							for(String f : searchFacebook.getSearchFacebook()) {
								listModel.addElement(f);
							}
						}

						if(j.equals(twitter)) {
							//							tweet = new tudoTwitter();
							tudoTwitter.searchT(getSearch());

							for(String t : tudoTwitter.getListT()) {
								listModel.addElement(t);
							}
						}
					}
				}
			}
		});
		contentPane.add(btnSearch);

		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				for(JToggleButton j : tougle) {

					if(j.equals(mail)) {
						String user1 = JOptionPane.showInputDialog("User:");
						String pass1 = JOptionPane.showInputDialog("Password:");
						//Validar dados com xml

						String to = JOptionPane.showInputDialog("To:");
						String subj = JOptionPane.showInputDialog("Subject:");
						String message = JOptionPane.showInputDialog("Text Message:");
						//listModel.addElement("From : \n" + user + "To: " + to + "\n" + "Subject:\n" + subj);
						
						//						enviarMail= new shareMail();
//						mail1;
						shareMail.sendMail(user1, pass1, to, subj, message);


					}
					if(j.equals(facebook)) {
						String post = JOptionPane.showInputDialog("Post:");
						System.out.println(post);
						face1.post(post);

					}
					if(j.equals(twitter)) {
						//invocar fun��o do twitter para publicar
						String messagePostTweet1 = JOptionPane.showInputDialog("Tweet:");
						tudoTwitter.makeTweet(messagePostTweet1);

						//						System.out.println(messagePostTweet);
					}
				}
			}
		});


		btnNewButton_3.setBounds(57, 505, 379, 25);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(552, 125, 425, 405);
		contentPane.add(scrollPane);

		JList<String> list = new JList<>();
		list.clearSelection();
		scrollPane.setViewportView(list);
		list.setModel(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBackground(SystemColor.inactiveCaptionBorder);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedValuesList = (list.getSelectedValue().toString());
					String[] parts = selectedValuesList.split(" ");
					if(parts[0].equals("Twitter")) {

						JCheckBox checkbox = new JCheckBox("ReTweet");
						Object[] params = {list.getSelectedValue(), checkbox};
						int n = JOptionPane.showConfirmDialog(null, params, "Twitter", JOptionPane.CANCEL_OPTION);
						boolean retweet = checkbox.isSelected();

						if(n==2) { 
							retweet = false;
						}
						if(retweet) {
							System.out.println("ReTweet");
						}
					}
				}
			}

		});

	}

	public static String getSearch() {
		return txtSearch.getText();
	}
};
